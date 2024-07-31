package hospitaldatabase;

import java.sql.*;
import java.util.Scanner;

public class Pabellon {
    public static void createPabellon() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el nombre del pabellón: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la capacidad del pabellón: ");
            int capacidad = scanner.nextInt();

            System.out.print("Ingrese el ID del hospital al que pertenece: ");
            int idHospital = scanner.nextInt();

            String sql = "INSERT INTO Pabellon (Nombre, Capacidad, ID_Hospital) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setInt(2, capacidad);
            stmt.setInt(3, idHospital);
            stmt.executeUpdate();

            System.out.println("Pabellón creado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readPabellon() {
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Pabellon";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID_Pabellon");
                String nombre = rs.getString("Nombre");
                int capacidad = rs.getInt("Capacidad");
                int idHospital = rs.getInt("ID_Hospital");

                System.out.printf("ID: %d, Nombre: %s, Capacidad: %d, ID_Hospital: %d%n", id, nombre, capacidad, idHospital);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePabellon() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del pabellón a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese el nuevo nombre del pabellón: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la nueva capacidad del pabellón: ");
            int capacidad = scanner.nextInt();

            System.out.print("Ingrese el nuevo ID del hospital al que pertenece: ");
            int idHospital = scanner.nextInt();

            String sql = "UPDATE Pabellon SET Nombre = ?, Capacidad = ?, ID_Hospital = ? WHERE ID_Pabellon = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setInt(2, capacidad);
            stmt.setInt(3, idHospital);
            stmt.setInt(4, id);
            stmt.executeUpdate();

            System.out.println("Pabellón actualizado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePabellon() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del pabellón a eliminar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Pabellon WHERE ID_Pabellon = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Pabellón eliminado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
