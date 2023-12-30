package pl.prg.ba.Menu.UserRelated;

import pl.prg.ba.Enums.Menu.UserMenuOptions;
import pl.prg.ba.Management.ListManagement;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.Menu.ListRelated.CurrentUserAddList;
import pl.prg.ba.Menu.ListRelated.CurrentUserShowLists;
import pl.prg.ba.Menu.ListRelated.ListMenu;
import pl.prg.ba.ToDoApp;

public class UserMenuNavigation {
    public void navigate(UserMenuOptions action) {
        switch (action) {
            case SHOW_LISTS -> {
                CurrentUserShowLists.showCurrentUserLists();
                if (ListManagement.checkIfThereAreAnyLists()) {
                    new ListMenu().display();
                }
            }
            case ADD_LIST -> CurrentUserAddList.newListAdd();
            case ABOUT_ME -> AboutMe.displayAboutMeForCurrentUser();
            case LOGOUT -> {
                System.out.printf("Goodbye, %s!\n", UserManagement.getUsers().get(ToDoApp.currentUserEmail).getName());
                ToDoApp.currentUserEmail = "";
                ToDoApp.mainMenu.display();
            }
        }
    }
}
