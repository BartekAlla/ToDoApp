package pl.prg.ba.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> { }