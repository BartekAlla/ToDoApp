package pl.prg.ba.Menu.ListRelated;

import pl.prg.ba.Enums.Menu.ListMenuOptions;
import pl.prg.ba.Management.ListManagement;
import pl.prg.ba.ScannerHolder;
import java.util.EnumMap;


public class ListMenu {
    private static final int SHOW_LIST_OPTION = 1;
    private static final int DELETE_LIST_OPTION = 2;
    private static final int BACK_OPTION = 3;
    private final EnumMap<ListMenuOptions, Integer> listMenuOptions = new EnumMap<>(ListMenuOptions.class);


    public ListMenu() {
        listMenuOptions.put(ListMenuOptions.SHOW_LIST, SHOW_LIST_OPTION);
        listMenuOptions.put(ListMenuOptions.DELETE_LIST, DELETE_LIST_OPTION);
        listMenuOptions.put(ListMenuOptions.BACK, BACK_OPTION);

    }


    public void display() {
        while (true) {
            System.out.println("LIST MENU:");
            for (ListMenuOptions mainMenuOption : ListMenuOptions.values()) {
                System.out.printf("\t%d. %s\n", listMenuOptions.get(mainMenuOption), mainMenuOption.getListMenuOption());
            }
            System.out.print("Chose your option: ");
            if (ListManagement.checkIfThereAreAnyLists()) {
                new ListMenuNavigation().navigate(checkForListMenuOptionRelatedToUserChoice(getUserChoice()));
            } else {
                System.out.println("There are no lists yet.");
            }

        }

    }

    private int getUserChoice() {
        return ScannerHolder.scanner.nextInt();
    }

    private ListMenuOptions checkForListMenuOptionRelatedToUserChoice(int userChoice) {
        for (ListMenuOptions option : ListMenuOptions.values()) {
            if (listMenuOptions.get(option) == userChoice) {
                return option;
            }
        }
        return null;
    }
}
