package pl.prg.ba.Model;

import jakarta.persistence.*;
import pl.prg.ba.Enums.List.ListType;
import pl.prg.ba.PostgreSQL.DatabaseConnection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "lists")
public class UserList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private ListType listType;
//    private ArrayList<Category> listCategories;
//    private HashMap<User, ListRole> listUsersWithRoles;

    public UserList(String name, ListType listType, User user) {
        this.id = null;
        this.name = name;
        this.listType = listType;
        //this.listCategories = new ArrayList<>();
        //this.listUsersWithRoles = new HashMap<>();
        //listUsersWithRoles.put(user, ListRole.OWNER);
    }

    public UserList(Integer id, String name, String listType) {
        this.id = id;
        this.name = name;
        this.listType = ListType.fromString(listType);
        //this.listCategories = new ArrayList<>();
        //this.listUsersWithRoles = new HashMap<>();
    }

    public UserList() {
        this.id = null;
        this.name = null;
        this.listType = null;
    }

    //    public void addUserAndHisRoleToTheList(User user, String userRole) {
//        this.listUsersWithRoles.put(user, ListRole.fromString(userRole));
//    }
    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public ListType getListType() {
        return listType;
    }

    //    public ListRole getUserRoleInTheList(User user) {
//        return this.listUsersWithRoles.get(user);
//    }
//    public HashMap<User, ListRole> getListOfUsersWithTheirRoles() {
//        return this.listUsersWithRoles;
//    }
//    public User getListOwner() {
//        for (Map.Entry<User, ListRole> entry : listUsersWithRoles.entrySet()) {
//            if (entry.getValue() == ListRole.OWNER) {
//                return entry.getKey();
//            }
//        }
//        return null;
//    }
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

   public void setName(String name) {
        this.name = name;
   }
   public void setListType(ListType listType) {
        this.listType = listType;
   }


}
