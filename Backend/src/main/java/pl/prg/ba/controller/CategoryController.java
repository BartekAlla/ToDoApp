package pl.prg.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.entity.Category;
import pl.prg.ba.service.CategoryService;

import java.util.List;
import java.util.Optional;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<Category> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(id, categoryDetails);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteAllCategories() {
        categoryService.deleteAllCategories();
        return "All categories have been deleted successfully.";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }


}
