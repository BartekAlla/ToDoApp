package pl.prg.ba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.Model.UserList;



public interface ListRepository extends JpaRepository<UserList, Integer> { }
