package TodoApp.TaskManager.Service;

import TodoApp.TaskManager.Entity.TaskEntity;
import TodoApp.TaskManager.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    // 🔍 Find by username
    public TaskEntity findByUserName(String userName) {
        return taskRepo.findByUserName(userName);
    }

    // 📋 Get all tasks
    public List<TaskEntity> findAll() {
        return taskRepo.findAll();
    }

    // 🔍 Find by ID
    public TaskEntity findById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    // 💾 Save task
    public TaskEntity save(TaskEntity task) {
        return taskRepo.save(task);
    }

    // 🔍 Find by completed
    public TaskEntity findByCompleted(boolean completed) {
        return taskRepo.findByCompleted(completed);
    }

    // ✏️ Update task
    public TaskEntity update(Long id, TaskEntity task) {
        TaskEntity existing = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existing.setTaskName(task.getTaskName());
        existing.setUserName(task.getUserName());
        existing.setCompleted(task.isCompleted());

        return taskRepo.save(existing);
    }

    // 🗑 Delete task
    public void deleteById(Long id) {
        if (!taskRepo.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        taskRepo.deleteById(id);
    }
}

