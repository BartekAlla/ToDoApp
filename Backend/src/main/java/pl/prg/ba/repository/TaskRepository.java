package pl.prg.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
