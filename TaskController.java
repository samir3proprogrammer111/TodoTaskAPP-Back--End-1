package TodoApp.TaskManager.Controller;
import TodoApp.TaskManager.Entity.TaskEntity;
import TodoApp.TaskManager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<TaskEntity> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskEntity findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    public TaskEntity save(@RequestBody TaskEntity task) {
        return taskService.save(task);
    }

    @GetMapping("/user")
    public TaskEntity findByUserName(@RequestParam String userName) {
        return taskService.findByUserName(userName);
    }

    @PutMapping("/update/{id}")
    public TaskEntity update(@PathVariable Long id, @RequestBody TaskEntity task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @GetMapping("/completed")
    public TaskEntity findByCompleted(@RequestParam boolean completed) {
        return taskService.findByCompleted(completed);
    }
}
