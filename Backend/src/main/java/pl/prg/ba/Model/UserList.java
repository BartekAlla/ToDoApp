package pl.prg.ba.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import pl.prg.ba.Enums.List.ListRole;
import pl.prg.ba.Enums.List.ListType;

import java.util.Set;

@Entity
@Table(name = "lists")
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

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public ListType getListType() {
        return listType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }

    public Set<Category> getListCategories() {
        return listCategories;
    }

    public void setListCategories(Set<Category> listCategories) {
        this.listCategories = listCategories;
    }


    public Set<UserListLink> getListLinks() {
        return listLinks;
    }

    public void setListLinks(Set<UserListLink> listLinks) {
        this.listLinks = listLinks;
    }
}
