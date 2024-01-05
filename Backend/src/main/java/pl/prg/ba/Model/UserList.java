package pl.prg.ba.Model;

import jakarta.persistence.*;
import pl.prg.ba.Enums.List.ListType;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "lists")
public class UserList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //@Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private ListType listType;

    public UserList(String name, ListType listType, User user) {
        this.id = null;
        this.name = name;
        this.listType = listType;
    }

    public UserList(Long id, String name, ListType listType) {
        this.id = id;
        this.name = name;
        this.listType = listType;
    }

    public UserList() {
        this.id = null;
        this.name = null;
        this.listType = null;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public ListType getListType() {
        return listType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }


}
