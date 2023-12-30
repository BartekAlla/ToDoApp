package pl.prg.ba.Creator;

import pl.prg.ba.Enums.User.Gender;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.Model.User;
import pl.prg.ba.PostgreSQL.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCreator {
    public static void createNewUser(String name, String surname, Gender gender, Integer age, String email, String password) {
        User newUser = new User(name, surname, gender, age, email, password);
        UserManagement.addUser(newUser);
        addUserToDB(newUser);
        newUser.setId(newUser.getUserIDByEmail(email));
    }

    private static void addUserToDB(User newUser) {
        String sql = "INSERT INTO users (name, surname, gender, age, email, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, newUser.getName());
            preparedStatement.setString(2, newUser.getSurname());
            preparedStatement.setString(3, newUser.getGender().getUserGender());
            preparedStatement.setInt(4, newUser.getAge());
            preparedStatement.setString(5, newUser.getEmail());
            preparedStatement.setString(6, newUser.getPassword());
            //int rowsAffected = preparedStatement.executeUpdate();
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("User added successfully.");
            } else {
                System.out.println("Failed to add the user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
