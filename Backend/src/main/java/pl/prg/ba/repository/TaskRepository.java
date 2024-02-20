package pl.prg.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.prg.ba.entity.Category;
import pl.prg.ba.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE t.category.id = :id")
    List<Task> findTasksByCategoryId(Integer id);
}
