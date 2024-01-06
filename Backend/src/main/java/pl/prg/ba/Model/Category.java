package pl.prg.ba.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private UserList userList;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<Task> categoryTasks;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    public Set<Task> getCategoryTasks() {
        return categoryTasks;
    }

    public void setCategoryTasks(Set<Task> categoryTasks) {
        this.categoryTasks = categoryTasks;
    }
}
