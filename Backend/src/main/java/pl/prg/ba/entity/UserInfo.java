package pl.prg.ba.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import pl.prg.ba.enums.user.UserGender;
import pl.prg.ba.enums.user.UserRole;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    //private Integer age;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserListLink> userListLinks;
}
