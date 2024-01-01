package pl.prg.ba.Menu.ListRelated;

import pl.prg.ba.Enums.List.ListType;
import pl.prg.ba.Management.ListManagement;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.PostgreSQL.DatabaseConnection;
import pl.prg.ba.ToDoApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowPublicLists {
    public static void display() {
        String sql = "SELECT " +
                "    l.id AS list_id," +
                "    l.name AS list_name," +
                "    l.list_type AS list_type," +
                "    u.name AS owner_name," +
                "    u.surname AS owner_surname " +
                "FROM" +
                "    users_lists ul," +
                "    lists l," +
                "    users u " +
                "WHERE" +
                "    ul.listID = l.id" +
                "    AND ul.userID = u.id" +
                "    AND ul.userRole = 'Owner'" +
                "    AND NOT u.email = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, ToDoApp.currentUserEmail);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Public lists:");
                if (!resultSet.next()) {
                    System.out.println("There are no public lists yet.");
                } else {
                    System.out.println("List ID | List name | List type | Owner");
                    do {
                        int listId = resultSet.getInt("list_id");
                        String listName = resultSet.getString("list_name");
                        String listType = resultSet.getString("list_type");
                        String ownerName = resultSet.getString("owner_name");
                        String ownerSurname = resultSet.getString("owner_surname");
                        System.out.printf("%d | %s | %s | %s %s\n", listId, listName, listType, ownerName, ownerSurname);
                    } while (resultSet.next());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
