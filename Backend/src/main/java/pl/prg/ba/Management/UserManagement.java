package pl.prg.ba.Management;

import pl.prg.ba.Model.User;

import java.util.HashMap;

public class UserManagement {
    private static HashMap<String, User> users = new HashMap<>();

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static void addUser(User newUser) {
        users.put(newUser.getEmail(), newUser);
        System.out.println("New account with name - " + newUser.getName() + ", created!");
    }

    public static User getUserByID(int userID) {
        for (User user : users.values()) {
            if (user.getId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

}
