package pl.prg.ba.Menu.AccountRelated;

import pl.prg.ba.MD5;
import pl.prg.ba.Menu.UserRelated.UserMenu;
import pl.prg.ba.PostgreSQL.DatabaseConnection;
import pl.prg.ba.ScannerHolder;
import pl.prg.ba.ToDoApp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SignIn {
    public static UserMenu userMenu;

    public static void userSignIn() {
        System.out.println("SING IN");
        System.out.print("E-mail: ");
        String email = ScannerHolder.scanner.next();
        checkIfUserExists(email);
    }

    private static void checkIfUserExists(String email) {
        if (checkIfSpecificEmailExists(email)) {
            System.out.print("Password: ");
            String password = ScannerHolder.scanner.next();
            checkIfPasswordMatchEmail(email, password);
        } else {
            System.out.println("There is no account with provided e-mail.");
        }
    }

    private static boolean checkIfSpecificEmailExists(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private static void checkIfPasswordMatchEmail(String email, String password) {
        String storedPassword = getPasswordForUserWithSpecificEmail(email);
        if (storedPassword != null && storedPassword.equals(MD5.getMD5(password))) {
            System.out.println("Successfully logged in.");
            ToDoApp.currentUserEmail = email;
            userMenu = new UserMenu();
            userMenu.display();
        } else {
            System.out.println("Invalid e-mail or password.");
        }
    }

    private static String getPasswordForUserWithSpecificEmail(String email) {
        String sql = "SELECT password FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
