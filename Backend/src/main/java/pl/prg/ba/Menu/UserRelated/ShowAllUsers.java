package pl.prg.ba.Menu.UserRelated;



import pl.prg.ba.PostgreSQL.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowAllUsers {
    public static void display() {
        String sql = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    System.out.println("There are no users yet.");
                } else {
                    System.out.println("User ID | User ");
                    do {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        System.out.printf("%d | %s %s\n", id, name, surname);
                    } while (resultSet.next());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
