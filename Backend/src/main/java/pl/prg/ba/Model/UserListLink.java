package pl.prg.ba.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import pl.prg.ba.Enums.List.ListRole;

@Entity
@Table(name = "user_list_link")
public class UserListLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private UserList userList;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private ListRole listRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    public ListRole getListRole() {
        return listRole;
    }

    public void setListRole(ListRole listRole) {
        this.listRole = listRole;
    }

}