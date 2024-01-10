package pl.prg.ba.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "categories")
@Getter
@Setter
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
}
