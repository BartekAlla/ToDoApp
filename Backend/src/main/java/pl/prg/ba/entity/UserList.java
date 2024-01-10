package pl.prg.ba.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import pl.prg.ba.enums.list.ListType;

import java.util.Set;

@Entity
@Table(name = "lists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    //@Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private ListType listType;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "list_id")
    private Set<UserListLink> listLinks;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "list_id")
    private Set<Category> listCategories;

//    public UserList(String name, ListType listType) {
//        this.id = null;
//        this.name = name;
//        this.listType = listType;
//    }
//
//    public UserList(Integer id, String name, ListType listType) {
//        this.id = id;
//        this.name = name;
//        this.listType = listType;
//    }
//
//    public UserList() {
//        this.id = null;
//        this.name = null;
//        this.listType = null;
//    }
}
