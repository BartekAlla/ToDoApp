package pl.prg.ba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
