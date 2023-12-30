package pl.prg.ba.Menu.ListRelated;

import pl.prg.ba.Enums.Menu.ListMenuOptions;
import pl.prg.ba.Menu.AccountRelated.SignIn;
import pl.prg.ba.ToDoApp;


public class ListMenuNavigation {
    public void navigate(ListMenuOptions action) {
        switch (action) {
            case SHOW_LIST -> System.out.println("Show list");
            case DELETE_LIST -> {
                DeleteList.deleteList();
                SignIn.userMenu.display();
            }
            case BACK -> {
                if (ToDoApp.currentUserEmail == null || ToDoApp.currentUserEmail.isEmpty()) {
                    ToDoApp.mainMenu.display();
                } else {
                    SignIn.userMenu.display();
                }

            }
        }
    }
}
