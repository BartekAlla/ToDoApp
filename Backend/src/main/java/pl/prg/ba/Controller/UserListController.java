package pl.prg.ba.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.Model.UserList;
import pl.prg.ba.Services.UserListService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/lists")
public class UserListController {
    @Autowired
    private UserListService userListService;
    @PostMapping
    public UserList createList(@RequestBody UserList userList) {
        return userListService.createList(userList);
    }
    @GetMapping
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
    @PutMapping("/{id}")
    public UserList updateList(@PathVariable Integer id, @RequestBody UserList listDetails) {
        return userListService.updateList(id, listDetails);
    }
    @DeleteMapping
    public String deleteAllLists() {
        userListService.deleteAllLists();
        return "All lists have been deleted successfully.";
    }
    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable Integer id) {
        userListService.deleteList(id);
    }
}