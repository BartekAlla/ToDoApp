package pl.prg.ba.Menu.UserRelated;

import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.Model.User;
import pl.prg.ba.ToDoApp;

public class AboutMe {
    public static void displayAboutMeForCurrentUser() {
        User currentUser = UserManagement.getUsers().get(ToDoApp.currentUserEmail);
        System.out.printf("ID: %d\n", currentUser.getId());
        System.out.printf("Name: %s\n", currentUser.getName());
        System.out.printf("Surname: %s\n", currentUser.getSurname());
        System.out.printf("Gender: %s\n", currentUser.getGender());
        System.out.printf("Age: %d\n", currentUser.getAge());
        System.out.printf("E-mail: %s\n", currentUser.getEmail());
    }
}
