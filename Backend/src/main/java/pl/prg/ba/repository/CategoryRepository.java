package pl.prg.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
