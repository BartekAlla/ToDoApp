package pl.prg.ba.Model;

import pl.prg.ba.Enums.List.ListRole;
import pl.prg.ba.Enums.List.ListType;
import pl.prg.ba.Management.UserManagement;
import pl.prg.ba.PostgreSQL.DatabaseConnection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class List {
    private Integer id;
    private String name;
    private ListType listType;
    private ArrayList<Category> listCategories;
    private HashMap<User, ListRole> listUsersWithRoles;

    public List(String name, ListType listType, User user) {
        this.id = null;
        this.name = name;
        this.listType = listType;
        this.listCategories = new ArrayList<>();
        this.listUsersWithRoles = new HashMap<>();
        listUsersWithRoles.put(user, ListRole.OWNER);
    }
    public List(Integer id, String name, String listType) {
        this.id = id;
        this.name = name;
        this.listType = ListType.fromString(listType);
        this.listCategories = new ArrayList<>();
        this.listUsersWithRoles = new HashMap<>();
    }
    public void addUserAndHisRoleToTheList(User user, String userRole) {
        this.listUsersWithRoles.put(user, ListRole.fromString(userRole));
    }
    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public ListType getListType() {
        return listType;
    }
    public ListRole getUserRoleInTheList(User user) {
        return this.listUsersWithRoles.get(user);
    }
    public HashMap<User, ListRole> getListOfUsersWithTheirRoles() {
        return this.listUsersWithRoles;
    }
    public User getListOwner() {
        for (Map.Entry<User, ListRole> entry : listUsersWithRoles.entrySet()) {
            if (entry.getValue() == ListRole.OWNER) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static int getListIDByName(String name) {
        String sql = "SELECT id FROM lists WHERE name = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
