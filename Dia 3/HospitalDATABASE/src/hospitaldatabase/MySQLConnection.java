package hospitaldatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://brz6ud4b6zwlxg8vfkqh-mysql.services.clever-cloud.com:3306/brz6ud4b6zwlxg8vfkqh";
    private static final String USER = "unhcvxsckc0jtxs4";
    private static final String PASSWORD = "eIiSuFPUYjXqwgfBsEKb";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
