package pl.prg.ba.Menu.ListRelated;

import pl.prg.ba.Management.ListManagement;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.PostgreSQL.DatabaseConnection;
import pl.prg.ba.ScannerHolder;
import pl.prg.ba.ToDoApp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteList {
    public static void deleteList(){
        if (ToDoApp.currentUserEmail == null || ToDoApp.currentUserEmail.isEmpty()){
            System.out.println("You must be logged in to delete lists.");
            ToDoApp.mainMenu.display();
        } else {
            System.out.print("Chose ID of a list to be deleted:");
            int userChoice = ScannerHolder.scanner.nextInt();
//            if (checkIfCurrentUserIsOwnerOfTheListToBeDeleted(userChoice)) {
//                ListManagement.deleteList(userChoice);
//                //UserManagement.getUsers().get(ToDoApp.currentUserEmail).deleteList(userChoice);
//                deleteListRecordFromDB(userChoice);
//            } else {
//                System.out.println("You are not the owner of this list.");
//            }

        }
    }

    private static void deleteListRecordFromDB(int userChoice) {
        deleteUserListConstraintFromDB(userChoice);
    }

    private static void deleteUserListConstraintFromDB(int userChoice) {
        String sql = "DELETE FROM users_lists WHERE listid = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, userChoice);
            if (preparedStatement.executeUpdate() > 0) {
                deleteListFromDB(userChoice);
            } else {
                System.out.println("Failed to delete the list.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteListFromDB(int userChoice) {
        String sql = "DELETE FROM lists WHERE id = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, userChoice);

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("List deleted successfully.");
            } else {
                System.out.println("Failed to delete the list.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private static boolean checkIfCurrentUserIsOwnerOfTheListToBeDeleted(int userChoice) {
//        return ListManagement.getLists().get(userChoice).getListOwner().getEmail().equals(ToDoApp.currentUserEmail);
//    }
}
