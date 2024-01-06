package pl.prg.ba.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.Model.UserListLink;
import pl.prg.ba.Services.UserListLinkService;


import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ullinks")
public class UserListLinkController {
    @Autowired
    private UserListLinkService userListLinkService;
    @PostMapping
    public UserListLink createUserListLink(@RequestBody UserListLink userListLink) {
        return userListLinkService.createUserListLink(userListLink);
    }
    @GetMapping
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
    public String deleteAllUserListLink() {
        userListLinkService.deleteAllUserListLinks();
        return "All user-list links have been deleted successfully.";
    }
    @DeleteMapping("/{id}")
    public void deleteUserListLink(@PathVariable Integer id) {
        userListLinkService.deleteUserListLink(id);
    }
}















