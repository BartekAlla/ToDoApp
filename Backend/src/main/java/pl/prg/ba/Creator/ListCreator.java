package pl.prg.ba.Creator;


import pl.prg.ba.Enums.List.ListRole;
import pl.prg.ba.Enums.List.ListType;
import pl.prg.ba.Management.ListManagement;
import pl.prg.ba.Model.UserList;
import pl.prg.ba.Model.User;
import pl.prg.ba.PostgreSQL.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListCreator {
    public static void createNewList(String name, ListType listType, User user) {
        UserList newList = new UserList(name, listType, user);
        ListManagement.addList(newList);
        addListToDB(newList, user);
        newList.setId(UserList.getListIDByName(name));
        //user.addList(newList);
    }

    private static void addListToDB(UserList list, User user) {
        String sql = "INSERT INTO lists (name, type) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, list.getName());
            preparedStatement.setString(2, list.getListType().getListType());
            //int rowsAffected = preparedStatement.executeUpdate();
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("List created successfully.");
                addListUserConstraint(list, user);
            } else {
                System.out.println("Failed to create the list.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addListUserConstraint(UserList list, User user) {
        int listId = UserList.getListIDByName(list.getName());
        int userId = user.getUserIDByEmail(user.getEmail());
        String sql = "INSERT INTO users_lists (userid, listid, userrole) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, listId);
            preparedStatement.setString(3, ListRole.OWNER.getListRole());
            //int rowsAffected = preparedStatement.executeUpdate();
            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("List " + list.getName() + " successfully added to " + user.getName() + " " + user.getSurname() + ".");
            } else {
                System.out.println("Failed to create the list.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

