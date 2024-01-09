package pl.prg.ba.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.prg.ba.Enums.User.UserGender;
import pl.prg.ba.Enums.User.UserRole;

import java.util.Set;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private UserGender userGender;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private UserRole userRole;

    private Integer age;
    private String email;
    private String password;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserListLink> userListLinks;


//    public User(String name, String surname, Gender gender, Integer age, String email, String password) {
//        this.id = null;
//        this.name = name;
//        this.surname = surname;
//        this.gender = gender;
//        this.age = age;
//        this.email = email;
//        this.password = password;
//    }
//
//
//    public User() {
//        this.id = null;
//        this.name = null;
//        this.surname = null;
//        this.gender = null;
//        this.age = null;
//        this.email = null;
//        this.password = null;
//    }

//    public String getEmail() {
//        return email;
//    }
}
