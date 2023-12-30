package pl.prg.ba.Menu.MainMenu;

import pl.prg.ba.Enums.Menu.MainMenuOptions;
import pl.prg.ba.Management.ListManagement;
import pl.prg.ba.Menu.AccountRelated.SignIn;
import pl.prg.ba.Menu.AccountRelated.SignUp;
import pl.prg.ba.Menu.ListRelated.ListMenu;
import pl.prg.ba.Menu.ListRelated.ShowPublicLists;
import pl.prg.ba.Menu.UserRelated.ShowAllUsers;
import pl.prg.ba.PostgreSQL.DatabaseConnection;

public class MainMenuNavigation {
    public void navigate(MainMenuOptions action) {
        switch (action) {
            case SIGN_IN -> SignIn.userSignIn();
            case SIGN_UP -> SignUp.newUserSignUp();
            case SHOW_ALL_USERS -> ShowAllUsers.display();
            case SHOW_ALL_LISTS -> {
                if (ListManagement.checkIfThereAreAnyLists()) {
                    ShowPublicLists.display();
                    new ListMenu().display();
                } else {
                    System.out.println("There are no lists yet.");
                }
            }
            case EXIT -> {
                System.out.println("Have a good day!");
                DatabaseConnection.closeConnection();
                System.exit(0);
            }
        }
    }

}
