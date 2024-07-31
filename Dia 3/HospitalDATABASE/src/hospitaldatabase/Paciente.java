package hospitaldatabase;

import java.sql.*;
import java.util.Scanner;

public class Paciente {
    public static void createPaciente() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID de la persona: ");
            int idPersona = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
            String fechaNacimiento = scanner.nextLine();

            System.out.print("Ingrese la fecha de ingreso (YYYY-MM-DD): ");
            String fechaIngreso = scanner.nextLine();

            System.out.print("Ingrese el ID del pabellón asignado: ");
            int idPabellon = scanner.nextInt();

            String sql = "INSERT INTO Paciente (ID_Persona, Fecha_Nacimiento, Fecha_Ingreso, ID_Pabellon) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPersona);
            stmt.setDate(2, Date.valueOf(fechaNacimiento));
            stmt.setDate(3, Date.valueOf(fechaIngreso));
            stmt.setInt(4, idPabellon);
            stmt.executeUpdate();

            System.out.println("Paciente creado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readPaciente() {
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT * FROM Paciente";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID_Paciente");
                int idPersona = rs.getInt("ID_Persona");
                Date fechaNacimiento = rs.getDate("Fecha_Nacimiento");
                Date fechaIngreso = rs.getDate("Fecha_Ingreso");
                int idPabellon = rs.getInt("ID_Pabellon");

                System.out.printf("ID: %d, ID_Persona: %d, Fecha_Nacimiento: %s, Fecha_Ingreso: %s, ID_Pabellon: %d%n",
                        id, idPersona, fechaNacimiento, fechaIngreso, idPabellon);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePaciente() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del paciente a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese el nuevo ID de la persona: ");
            int idPersona = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
            String fechaNacimiento = scanner.nextLine();

            System.out.print("Ingrese la nueva fecha de ingreso (YYYY-MM-DD): ");
            String fechaIngreso = scanner.nextLine();

            System.out.print("Ingrese el nuevo ID del pabellón asignado: ");
            int idPabellon = scanner.nextInt();

            String sql = "UPDATE Paciente SET ID_Persona = ?, Fecha_Nacimiento = ?, Fecha_Ingreso = ?, ID_Pabellon = ? WHERE ID_Paciente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPersona);
            stmt.setDate(2, Date.valueOf(fechaNacimiento));
            stmt.setDate(3, Date.valueOf(fechaIngreso));
            stmt.setInt(4, idPabellon);
            stmt.setInt(5, id);
            stmt.executeUpdate();

            System.out.println("Paciente actualizado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePaciente() {
        try (Connection conn = MySQLConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el ID del paciente a eliminar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM Paciente WHERE ID_Paciente = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Paciente eliminado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
