package hospitaldatabase;

import java.sql.*;
import java.util.Scanner;

public class Hospital {
    public static void createHospital() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el nombre del hospital: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la dirección del hospital: ");
            String direccion = scanner.nextLine();

            String sql = "INSERT INTO Hospital (Nombre, Direccion) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.executeUpdate();

            System.out.println("Hospital creado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readHospital() {
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Hospital";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID_Hospital");
                String nombre = rs.getString("Nombre");
                String direccion = rs.getString("Direccion");

                System.out.printf("ID: %d, Nombre: %s, Dirección: %s%n", id, nombre, direccion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHospital() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del hospital a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese el nuevo nombre del hospital: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la nueva dirección del hospital: ");
            String direccion = scanner.nextLine();

            String sql = "UPDATE Hospital SET Nombre = ?, Direccion = ? WHERE ID_Hospital = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.setInt(3, id);
            stmt.executeUpdate();

            System.out.println("Hospital actualizado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteHospital() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del hospital a eliminar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Hospital WHERE ID_Hospital = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Hospital eliminado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
