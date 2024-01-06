package pl.prg.ba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.Model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
