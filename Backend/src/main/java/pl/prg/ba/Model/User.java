package pl.prg.ba.Model;

import jakarta.persistence.*;
import pl.prg.ba.Enums.User.Gender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    //@Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private String gender;
//    private String gender;
    private Integer age;
    private String email;
    private String password;



    public User(String name, String surname, String gender, Integer age, String email, String password) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;
        // this.userLists = new ArrayList<>();
    }

//    public User(Integer id, String name, String surname, String gender, Integer age, String email, String password) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.gender = Gender.fromString(gender);
//        this.age = age;
//        this.email = email;
//        this.password = password;
//        // this.userLists = new ArrayList<>();
//    }

    public User() {
        this.id = null;
        this.name = null;
        this.surname = null;
        this.gender = null;
        this.age = null;
        this.email = null;
        this.password = null;
        // this.userLists = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //public Gender getGender() {
    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;

    }
}
