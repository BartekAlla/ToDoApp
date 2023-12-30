package pl.prg.ba.Menu.ListRelated;


import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.PostgreSQL.DatabaseConnection;
import pl.prg.ba.ToDoApp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrentUserShowLists {
    public static void showCurrentUserLists() {
        String sql = "SELECT" +
                "    l.id AS list_id," +
                "    l.name AS list_name," +
                "    l.type AS list_type," +
                "    ul.userrole AS user_role " +
                "FROM" +
                "    users_lists ul," +
                "    lists l," +
                "    users u " +
                "WHERE" +
                "    ul.listID = l.id" +
                "    AND ul.userID = u.id" +
                "    AND u.email = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, ToDoApp.currentUserEmail);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Your lists:");
                if (!resultSet.next()) {
                    System.out.println("You are not a member of any list!");
                } else {
                    System.out.println("List ID | List name | List type | Your role in the list");
                    do {
                        int listId = resultSet.getInt("list_id");
                        String listName = resultSet.getString("list_name");
                        String listType = resultSet.getString("list_type");
                        String userRole = resultSet.getString("user_role");
                        System.out.printf("%d | %s | %s | %s\n", listId, listName, listType, userRole);
                    } while (resultSet.next());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ShowPublicLists.display();
//        if (UserManagement.getUsers().get(ToDoApp.currentUserEmail).getUserLists().isEmpty()) {
//            System.out.println("You are not a member of any list!");
//        } else {
//            System.out.println("Your lists: ");
//            System.out.println("List ID | List name | List type | Your role in the list");
//            UserManagement.getUsers().get(ToDoApp.currentUserEmail).getUserLists().forEach((list) -> {
//                System.out.printf("%d. %s | %s | %s\n", list.getId(), list.getName(), list.getListType(), list.getUserRoleInTheList(UserManagement.getUsers().get(ToDoApp.currentUserEmail)));
//            });
//        }
//        ShowPublicLists.display();
    }
}
