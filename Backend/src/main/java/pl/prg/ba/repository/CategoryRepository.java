package pl.prg.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.prg.ba.entity.Category;
import pl.prg.ba.entity.UserList;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT cat FROM Category cat WHERE cat.userList.id = :id")
    List<Category> findCategoryByListId(Integer id);
}
