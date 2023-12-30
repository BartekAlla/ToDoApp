package pl.prg.ba.Menu.MainMenu;

import pl.prg.ba.Enums.Menu.MainMenuOptions;
import pl.prg.ba.ScannerHolder;
import pl.prg.ba.ToDoApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EnumMap;

public class MainMenu {
    private static final int SIGN_IN_OPTION = 1;
    private static final int SIGN_UP_OPTION = 2;

    private static final int SHOW_ALL_USERS_OPTION = 3;
    private static final int SHOW_ALL_LISTS_OPTION = 4;
    private static final int EXIT_OPTION = 5;
    private final EnumMap<MainMenuOptions, Integer> mainMenuOptionsMap = new EnumMap<>(MainMenuOptions.class);

    /**
     * Default constructor for the MainMenu
     */
    public MainMenu() {
        mainMenuOptionsMap.put(MainMenuOptions.SIGN_IN, SIGN_IN_OPTION);
        mainMenuOptionsMap.put(MainMenuOptions.SIGN_UP, SIGN_UP_OPTION);
        mainMenuOptionsMap.put(MainMenuOptions.SHOW_ALL_USERS, SHOW_ALL_USERS_OPTION);
        mainMenuOptionsMap.put(MainMenuOptions.SHOW_ALL_LISTS, SHOW_ALL_LISTS_OPTION);
        mainMenuOptionsMap.put(MainMenuOptions.EXIT, EXIT_OPTION);
    }

    /**
     * Method to display MainMenu
     */
    public void display() {
        while (true) {
            System.out.println("MAIN MENU:");
            for (MainMenuOptions mainMenuOption : MainMenuOptions.values()) {
                System.out.printf("\t%d. %s\n", mainMenuOptionsMap.get(mainMenuOption), mainMenuOption.getMainMenuOption());
            }
            System.out.print("Chose your option: ");
            new MainMenuNavigation().navigate(checkForMainMenuOptionRelatedToUserChoice(getUserChoice()));
        }

    }

    private int getUserChoice() {
        return ScannerHolder.scanner.nextInt();
    }

    private MainMenuOptions checkForMainMenuOptionRelatedToUserChoice(int userChoice) {
        for (MainMenuOptions option : MainMenuOptions.values()) {
            if (mainMenuOptionsMap.get(option) == userChoice) {
                return option;
            }
        }
        return null;
    }
}
