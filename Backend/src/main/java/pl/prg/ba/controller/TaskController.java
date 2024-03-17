package pl.prg.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.entity.Category;
import pl.prg.ba.entity.Task;
import pl.prg.ba.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;


    @PostMapping("/addNew")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/category/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Task> getTasksByCategoryId(@PathVariable Integer id) {
        return taskService.getTasksByCategoryId(id);
    }
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Task updateTask(@PathVariable Integer id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteAllTasks() {
        taskService.deleteAllTasks();
        return "All tasks have been deleted successfully.";
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }

}
