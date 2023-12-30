package pl.prg.ba.Menu.UserRelated;

import pl.prg.ba.Enums.Menu.UserMenuOptions;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.ScannerHolder;
import pl.prg.ba.ToDoApp;
import java.util.EnumMap;

public class UserMenu {
    private static final int SHOW_LISTS_OPTION = 1;
    private static final int ADD_LIST_OPTION = 2;
    private static final int ABOUT_ME_OPTION = 3;
    private static final int LOGOUT_OPTION = 4;
    private final EnumMap<UserMenuOptions, Integer> userMenuOptionsMap = new EnumMap<>(UserMenuOptions.class);


    public UserMenu() {
        userMenuOptionsMap.put(UserMenuOptions.SHOW_LISTS, SHOW_LISTS_OPTION);
        userMenuOptionsMap.put(UserMenuOptions.ADD_LIST, ADD_LIST_OPTION);
        userMenuOptionsMap.put(UserMenuOptions.ABOUT_ME, ABOUT_ME_OPTION);
        userMenuOptionsMap.put(UserMenuOptions.LOGOUT, LOGOUT_OPTION);
    }


    public void display() {
        while (true) {
            System.out.printf("Welcome %s!\n", UserManagement.getUsers().get(ToDoApp.currentUserEmail).getName());
            System.out.println("USER MENU:");
            for (UserMenuOptions userMenuOption : UserMenuOptions.values()) {
                System.out.printf("\t%d. %s\n", userMenuOptionsMap.get(userMenuOption), userMenuOption.getUserMenuOption());
            }
            System.out.print("Chose your option: ");
            new UserMenuNavigation().navigate(checkForUserMenuOptionRelatedToUserChoice(getUserChoice()));
        }

    }

    private int getUserChoice() {
        return ScannerHolder.scanner.nextInt();
    }

    private UserMenuOptions checkForUserMenuOptionRelatedToUserChoice(int userChoice) {
        for (UserMenuOptions option : UserMenuOptions.values()) {
            if (userMenuOptionsMap.get(option) == userChoice) {
                return option;
            }
        }
        return null;
    }
}
