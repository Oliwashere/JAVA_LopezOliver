package ligabaloncesto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://bp45j8cowui6a1h1ho5z-mysql.services.clever-cloud.com:3306/bp45j8cowui6a1h1ho5z";
    private static final String USER = "uyqqorwizgjptylo";
    private static final String PASSWORD = "d1HXWkpPhhrkxiOLpVz2";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

