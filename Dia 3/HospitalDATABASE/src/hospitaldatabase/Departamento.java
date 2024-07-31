package hospitaldatabase;

import java.sql.*;
import java.util.Scanner;

public class Departamento {
    public static void createDepartamento() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el nombre del departamento: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el ID del hospital al que pertenece: ");
            int idHospital = scanner.nextInt();

            String sql = "INSERT INTO Departamento (Nombre, ID_Hospital) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setInt(2, idHospital);
            stmt.executeUpdate();

            System.out.println("Departamento creado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readDepartamento() {
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Departamento";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID_Departamento");
                String nombre = rs.getString("Nombre");
                int idHospital = rs.getInt("ID_Hospital");

                System.out.printf("ID: %d, Nombre: %s, ID_Hospital: %d%n", id, nombre, idHospital);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDepartamento() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del departamento a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese el nuevo nombre del departamento: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el nuevo ID del hospital al que pertenece: ");
            int idHospital = scanner.nextInt();

            String sql = "UPDATE Departamento SET Nombre = ?, ID_Hospital = ? WHERE ID_Departamento = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setInt(2, idHospital);
            stmt.setInt(3, id);
            stmt.executeUpdate();

            System.out.println("Departamento actualizado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDepartamento() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del departamento a eliminar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Departamento WHERE ID_Departamento = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Departamento eliminado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
