package pl.prg.ba.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.prg.ba.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}