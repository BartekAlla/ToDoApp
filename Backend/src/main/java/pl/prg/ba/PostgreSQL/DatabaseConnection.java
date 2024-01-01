package pl.prg.ba.PostgreSQL;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            initializeConnection();
        }
        return connection;
    }

    private static void initializeConnection() {
        String url = "jdbc:postgresql://localhost:5432/ToDoApp";
        String user = "postgres";
        String password = "superuser";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            //executeSqlFromFile("Backend/src/main/java/pl/prg/ba/PostgreSQL/SQLFiles/users.sql");
            //executeSqlFromFile("Backend/src/main/java/pl/prg/ba/PostgreSQL/SQLFiles/lists.sql");
            //executeSqlFromFile("Backend/src/main/java/pl/prg/ba/PostgreSQL/SQLFiles/users_lists.sql");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void executeSqlFromFile(String filePath) {
        try {
            String sql = new String(Files.readAllBytes(Paths.get(filePath)));
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
