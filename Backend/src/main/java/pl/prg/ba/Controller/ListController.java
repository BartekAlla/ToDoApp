package pl.prg.ba.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.Model.UserList;
import pl.prg.ba.Services.ListService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class ListController {
    @Autowired
    private ListService listService;

    // Create a new list
    @PostMapping
    public UserList createList(@RequestBody UserList userList) {
        return listService.createList(userList);
    }

    // Get all lists
    @GetMapping
    public List<UserList> getAllLists() {
        return listService.getAllLists();
    }

    // Get list by ID
    @GetMapping("/{id}")
    public Optional<UserList> getListById(@PathVariable Integer id) {
        return listService.getListById(id);
    }

    // Update list by ID
    @PutMapping("/{id}")
    public UserList updateList(@PathVariable Integer id, @RequestBody UserList listDetails) {
        return listService.updateList(id, listDetails);
    }

    // Delete all lists
    @DeleteMapping
    public String deleteAllLists() {
        listService.deleteAllLists();
        return "All lists have been deleted successfully.";
    }

    // Delete list by ID
    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable Integer id) {
        listService.deleteList(id);
    }
}