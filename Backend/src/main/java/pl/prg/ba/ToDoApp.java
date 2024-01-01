package pl.prg.ba;

import pl.prg.ba.Management.ListManagement;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.Menu.MainMenu.MainMenu;
import pl.prg.ba.Model.UserList;
import pl.prg.ba.Model.User;
import pl.prg.ba.PostgreSQL.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToDoApp {
    public static String currentUserEmail;
    public static MainMenu mainMenu;

    public void run() {
        DatabaseConnection.getConnection();
        initObjects();
        System.out.println("\nWELCOME TO TODO APP!");
        mainMenu = new MainMenu();
        mainMenu.display();
    }

    private void initObjects() {
        initCurrentUser();
        //initUsers();
        initLists();
        //initUserListConnections();
    }

    private void initCurrentUser() {
        currentUserEmail = "";
    }


//    private void initUsers() {
//        String sql = "SELECT * FROM users";
//        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("id");
//                    String name = resultSet.getString("name");
//                    String surname = resultSet.getString("surname");
//                    String gender = resultSet.getString("gender");
//                    int age = resultSet.getInt("age");
//                    String email = resultSet.getString("email");
//                    String password = resultSet.getString("password");
//                    UserManagement.addUser(new User(id, name, surname, gender, age, email, password));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private void initLists() {
        String sql = "SELECT * FROM lists";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String type = resultSet.getString("list_type");
                    ListManagement.addList(new UserList(id, name, type));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private void initUserListConnections() {
//        String sql = "SELECT * FROM users_lists";
//        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    int userID = resultSet.getInt("userid");
//                    int listID = resultSet.getInt("listid");
//                    String userRole = resultSet.getString("userrole");
//                    //addListWithProvidedIDToUserLists(userID, listID);
//                    addUserWithHisRoleToList(listID, userID, userRole);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    private void addUserWithHisRoleToList(int listID, int userID, String userRole) {
//        ListManagement.getListByID(listID)
//                .addUserAndHisRoleToTheList(UserManagement.getUserByID(userID), userRole);
//
//    }

//    private void addListWithProvidedIDToUserLists(int userID, int listID) {
//        UserManagement.getUserByID(userID).addListToUser(ListManagement.getListByID(listID));
//    }
}
