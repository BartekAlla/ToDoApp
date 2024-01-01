package pl.prg.ba.Model;

import jakarta.persistence.*;
import pl.prg.ba.Enums.List.ListRole;

@Entity
@Table(name = "users_lists")
public class UserListLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer listID;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private ListRole userListRole;
}
