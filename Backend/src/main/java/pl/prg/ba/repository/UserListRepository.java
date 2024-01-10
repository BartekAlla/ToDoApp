package pl.prg.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.prg.ba.entity.UserList;

import java.util.List;


public interface UserListRepository extends JpaRepository<UserList, Integer> {
    @Query("SELECT ul FROM UserList ul WHERE LOWER(ul.listType) = LOWER('Public')")
    List<UserList> findPublicLists();
}
