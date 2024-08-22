package sysfacturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://bjed4nserutqtdgyvch7-mysql.services.clever-cloud.com:3306/bjed4nserutqtdgyvch7";
    private static final String USER = "uyk0apndpokzzmc3";
    private static final String PASSWORD = "YlWprwyvS35xDsyI7sLa";

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con éxito");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada con éxito");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
