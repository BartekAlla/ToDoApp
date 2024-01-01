package pl.prg.ba.Model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import pl.prg.ba.Enums.User.Gender;
import pl.prg.ba.PostgreSQL.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private Gender gender;
    private Integer age;
    private String email;
    private String password;
//    private ArrayList<List> userLists;

    public User(String name, String surname, Gender gender, Integer age, String email, String password) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;
        // this.userLists = new ArrayList<>();
    }

    public User(Integer id, String name, String surname, String gender, Integer age, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = Gender.fromString(gender);
        this.age = age;
        this.email = email;
        this.password = password;
        // this.userLists = new ArrayList<>();
    }

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


//    public List getUserListByID(int id) {
//        for (List list : userLists) {
//            if (list.getId() == id) {
//                return list;
//            }
//        }
//        return null;
//    }

//    public void addListToUser(List list) {
//        this.userLists.add(list);
//    }

    public int getUserIDByEmail(String email) {
        String sql = "SELECT id FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

//    public void deleteList(int id) {
//        this.userLists.remove(getUserListByID(id));
//    }

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
//    public ArrayList<List> getUserLists() {
//        return userLists;
//    }

//    public void addList(List newList) {
//        this.userLists.add(newList);
//    }

    public String getSurname() {
        return surname;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
