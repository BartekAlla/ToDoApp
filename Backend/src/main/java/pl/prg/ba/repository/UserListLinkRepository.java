package pl.prg.ba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.prg.ba.entity.UserList;
import pl.prg.ba.entity.UserListLink;
import pl.prg.ba.enums.list.ListRole;

import java.util.List;

public interface UserListLinkRepository extends JpaRepository<UserListLink, Integer> {
    @Query("SELECT ull FROM UserListLink ull WHERE ull.userInfo.id = :userId")
    List<UserListLink> getUserListLinksByUserId(@Param("userId") Integer userId);

    @Query("SELECT ull.listRole FROM UserListLink ull WHERE ull.userInfo.id = :userId AND ull.userList.id = :listId")
    ListRole getCurrentUserPermissionForThisList(@Param("userId") Integer userId, @Param("listId") Integer listId);
}
