package pl.prg.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.entity.Category;
import pl.prg.ba.entity.Task;
import pl.prg.ba.repository.CategoryRepository;
import pl.prg.ba.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public Task createTask(Task task) {
        Category category = task.getCategory();
        if (category.getId() == null) {
            throw new IllegalArgumentException("Category ID cannot be null");
        }
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);

        if (existingCategory != null) {
            task.setCategory(existingCategory);
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Category with id " + category.getId() + " not found");
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }


    public Task updateTask(Integer id, Task taskDetails) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setName(taskDetails.getName());
            existingTask.setTaskStatus(taskDetails.getTaskStatus());
            return taskRepository.save(existingTask);
        }
        return null;
    }


    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }


    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByCategoryId(Integer id) {
        return taskRepository.findTasksByCategoryId(id);
    }


}
