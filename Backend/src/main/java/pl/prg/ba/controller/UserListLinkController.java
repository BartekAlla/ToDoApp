package pl.prg.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.entity.UserListLink;
import pl.prg.ba.service.UserListLinkService;


import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/ullinks")
public class UserListLinkController {
    @Autowired
    private UserListLinkService userListLinkService;
    @PostMapping
    public UserListLink createUserListLink(@RequestBody UserListLink userListLink) {
        return userListLinkService.createUserListLink(userListLink);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserListLink> getAllUserListLink() {
        return userListLinkService.getAllUserListLinks();
    }
    @GetMapping("/{id}")
    public Optional<UserListLink> getUserListLinkById(@PathVariable Integer id) {
        return userListLinkService.getUserListLinkById(id);
    }
    @PutMapping("/{id}")
    public UserListLink updateUserListLink(@PathVariable Integer id, @RequestBody UserListLink userListLinkDetails) {
        return userListLinkService.updateUserListLink(id, userListLinkDetails);
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteAllUserListLink() {
        userListLinkService.deleteAllUserListLinks();
        return "All user-list links have been deleted successfully.";
    }
    @DeleteMapping("/{id}")
    public void deleteUserListLink(@PathVariable Integer id) {
        userListLinkService.deleteUserListLink(id);
    }
}















