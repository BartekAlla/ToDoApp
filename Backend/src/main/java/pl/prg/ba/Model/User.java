package pl.prg.ba.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import pl.prg.ba.Enums.User.Gender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private Gender gender;
//    private String gender;
    private Integer age;
    private String email;
    private String password;



    public User(String name, String surname, Gender gender, Integer age, String email, String password) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;
    }


    public User() {
        this.id = null;
        this.name = null;
        this.surname = null;
        this.gender = null;
        this.age = null;
        this.email = null;
        this.password = null;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public Gender getGender() {
    public Gender getGender() {
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

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;

    }
}
