package TodoApp.TaskManager.Repository;

import TodoApp.TaskManager.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskEntity, Long> {

    TaskEntity findByUserName(String userName);

    TaskEntity findByTaskName(String taskName);

    TaskEntity findByCompleted(boolean completed);
}
