package hospitaldatabase;

import java.sql.*;
import java.util.Scanner;

public class Doctor {
    public static void createDoctor() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del personal asociado: ");
            int idPersonal = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese el tipo de doctor (Asociado/Junior): ");
            String tipoDoctor = scanner.nextLine();

            String sql = "INSERT INTO Doctor (ID_Personal, Tipo_Doctor) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPersonal);
            stmt.setString(2, tipoDoctor);
            stmt.executeUpdate();

            System.out.println("Doctor creado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readDoctor() {
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Doctor";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID_Doctor");
                int idPersonal = rs.getInt("ID_Personal");
                String tipoDoctor = rs.getString("Tipo_Doctor");

                System.out.printf("ID: %d, ID_Personal: %d, Tipo: %s%n", id, idPersonal, tipoDoctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDoctor() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del doctor a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese el nuevo ID del personal asociado: ");
            int idPersonal = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese el nuevo tipo de doctor (Asociado/Junior): ");
            String tipoDoctor = scanner.nextLine();

            String sql = "UPDATE Doctor SET ID_Personal = ?, Tipo_Doctor = ? WHERE ID_Doctor = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPersonal);
            stmt.setString(2, tipoDoctor);
            stmt.setInt(3, id);
            stmt.executeUpdate();

            System.out.println("Doctor actualizado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDoctor() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del doctor a eliminar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Doctor WHERE ID_Doctor = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Doctor eliminado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
