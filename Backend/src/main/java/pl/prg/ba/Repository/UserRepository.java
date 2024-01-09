package pl.prg.ba.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.prg.ba.Model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}