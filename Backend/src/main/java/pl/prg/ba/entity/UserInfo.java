package pl.prg.ba.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import pl.prg.ba.enums.user.UserGender;
import pl.prg.ba.enums.user.UserRole;

import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private UserGender userGender;
    private String roles;

    private Integer age;
    private String email;
    private String password;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserListLink> userListLinks;
}
