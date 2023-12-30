package pl.prg.ba.Management;


import pl.prg.ba.Model.List;

import java.util.HashMap;

public class ListManagement {
    private static HashMap<Integer, List> lists = new HashMap<>();

    public static HashMap<Integer, List> getLists() {
        return lists;
    }

    public static void addList(List newList) {
        lists.put(newList.getId(), newList);
        System.out.println("New list with name - " + newList.getName() + ", created!");
    }
    public static boolean checkIfThereAreAnyLists() {
        return !ListManagement.getLists().isEmpty();
    }
    public static void deleteList(int listID) {
        lists.remove(listID);
    }
    public static List getListByID(int id) {
        return getLists().get(id);
    }
}
