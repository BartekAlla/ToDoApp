package pl.prg.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.entity.UserListLink;
import pl.prg.ba.service.UserListLinkService;


import java.util.List;
import java.util.Optional;
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ullinks")
public class UserListLinkController {
    @Autowired
    private UserListLinkService userListLinkService;
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserListLink createUserListLink(@RequestBody UserListLink userListLink) {
        return userListLinkService.createUserListLink(userListLink);
    }
    @GetMapping
    public List<UserListLink> getAllUserListLink() {
        return userListLinkService.getAllUserListLinks();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<UserListLink> getUserListLinkById(@PathVariable Integer id) {
        return userListLinkService.getUserListLinkById(id);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
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
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void deleteUserListLink(@PathVariable Integer id) {
        userListLinkService.deleteUserListLink(id);
    }
}















