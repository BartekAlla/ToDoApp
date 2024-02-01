package pl.prg.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.entity.UserList;
import pl.prg.ba.entity.UserListLink;
import pl.prg.ba.service.UserListService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class UserListController {
    @Autowired
    private UserListService userListService;
    @PostMapping
    public UserList createList(@RequestBody UserList userList) {
        return userListService.createList(userList);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserList> getAllLists() {
        return userListService.getAllLists();
    }
    @GetMapping("/public")
    public List<UserList> getPublicLists() {
        return userListService.getPublicLists();
    }
    @GetMapping("/{id}")
    public Optional<UserList> getListById(@PathVariable Integer id) {
        return userListService.getListById(id);
    }

    @GetMapping("/links/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<UserListLink> getUserListLinksByUserId(@PathVariable Integer id) {
        return userListService.getUserListLinksByUserId(id);
    }

    @PutMapping("/{id}")
    public UserList updateList(@PathVariable Integer id, @RequestBody UserList listDetails) {
        return userListService.updateList(id, listDetails);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteAllLists() {
        userListService.deleteAllLists();
        return "All lists have been deleted successfully.";
    }
    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable Integer id) {
        userListService.deleteList(id);
    }
}