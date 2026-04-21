package TodoApp.TaskManager.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class TaskEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private Long id;

    @NotNull
    private  String userName;
    @NotNull
    private String taskName;

    private boolean completed;



}
