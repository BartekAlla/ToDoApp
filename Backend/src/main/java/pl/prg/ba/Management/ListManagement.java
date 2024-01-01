package pl.prg.ba.Management;


import pl.prg.ba.Model.UserList;

import java.util.HashMap;

public class ListManagement {
    private static HashMap<Integer, UserList> lists = new HashMap<>();

    public static HashMap<Integer, UserList> getLists() {
        return lists;
    }

    public static void addList(UserList newList) {
        lists.put(newList.getId(), newList);
        System.out.println("New list with name - " + newList.getName() + ", created!");
    }
    public static boolean checkIfThereAreAnyLists() {
        return !ListManagement.getLists().isEmpty();
    }
    public static void deleteList(int listID) {
        lists.remove(listID);
    }
    public static UserList getListByID(int id) {
        return getLists().get(id);
    }
}
