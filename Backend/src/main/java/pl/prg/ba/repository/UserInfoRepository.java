package pl.prg.ba.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pl.prg.ba.entity.UserInfo;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);
    Optional<UserInfo> findByEmail(String email);
}