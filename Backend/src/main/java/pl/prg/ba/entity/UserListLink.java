package pl.prg.ba.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.prg.ba.enums.list.ListRole;

@Entity
@Table(name = "user_list_link")
@Getter
@Setter
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


}