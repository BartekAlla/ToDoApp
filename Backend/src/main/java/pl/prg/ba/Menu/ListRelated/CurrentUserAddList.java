package pl.prg.ba.Menu.ListRelated;


import pl.prg.ba.Creator.ListCreator;
import pl.prg.ba.Enums.List.ListType;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.ScannerHolder;
import pl.prg.ba.ToDoApp;


public class CurrentUserAddList {
    public static void newListAdd() {
        System.out.printf("\nCreating new list for user - %s %s!\n",
                UserManagement.getUsers().get(ToDoApp.currentUserEmail).getName(),
                UserManagement.getUsers().get(ToDoApp.currentUserEmail).getSurname());
        System.out.println("Please provide data below.");
        System.out.print("List name: ");
        String listName = ScannerHolder.scanner.next();
        System.out.println("Would you like to make your list public or private?");
        System.out.print("1 - Public, 2 - Private: ");
        ListCreator.createNewList(listName, letUserChoseListType(), UserManagement.getUsers().get(ToDoApp.currentUserEmail));
    }
    private static ListType letUserChoseListType() {
        if (getUserInput() == 1) {
            return ListType.PUBLIC;
        } else {
            return ListType.PRIVATE;
        }

    }

    private static int getUserInput() {
        return ScannerHolder.scanner.nextInt();
    }
}
