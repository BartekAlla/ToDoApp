package pl.prg.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.entity.Category;
import pl.prg.ba.entity.UserList;
import pl.prg.ba.repository.CategoryRepository;
import pl.prg.ba.repository.UserListRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private final UserListRepository userListRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, UserListRepository userListRepository) {
        this.categoryRepository = categoryRepository;
        this.userListRepository = userListRepository;
    }

    public Category createCategory(Category category) {
        UserList userList = category.getUserList();
        if (userList.getId() == null) {
            throw new IllegalArgumentException("UserList ID cannot be null");
        }
        UserList existingUserList = userListRepository.findById(userList.getId()).orElse(null);

        if (existingUserList != null) {
            category.setUserList(existingUserList);
            return categoryRepository.save(category);
        } else {
            throw new RuntimeException("UserList with id " + userList.getId() + " not found");
        }
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }


    public Category updateCategory(Integer id, Category categoryDetails) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            existingCategory.setName(categoryDetails.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }


    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }


    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> getCategoriesByListId(Integer id) {
        return categoryRepository.findCategoryByListId(id);
    }
}
