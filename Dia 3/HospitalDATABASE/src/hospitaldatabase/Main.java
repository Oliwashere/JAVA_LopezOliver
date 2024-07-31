package hospitaldatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("==========");
            System.out.println("Menú principal");
            System.out.println("==========");
            System.out.println("1. Hospital");
            System.out.println("2. Pabellón");
            System.out.println("3. Departamento");
            System.out.println("4. Doctor");
            System.out.println("5. Paciente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    hospitalMenu();
                    break;
                case 2:
                    pabellonMenu();
                    break;
                case 3:
                    departamentoMenu();
                    break;
                case 4:
                    doctorMenu();
                    break;
                case 5:
                    pacienteMenu();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void hospitalMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==========");
            System.out.println("Menú Hospital");
            System.out.println("==========");
            System.out.println("1. Crear Hospital");
            System.out.println("2. Leer Hospital");
            System.out.println("3. Actualizar Hospital");
            System.out.println("4. Eliminar Hospital");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Hospital.createHospital();
                    break;
                case 2:
                    Hospital.readHospital();
                    break;
                case 3:
                    Hospital.updateHospital();
                    break;
                case 4:
                    Hospital.deleteHospital();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void pabellonMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==========");
            System.out.println("Menú Pabellón");
            System.out.println("==========");
            System.out.println("1. Crear Pabellón");
            System.out.println("2. Leer Pabellón");
            System.out.println("3. Actualizar Pabellón");
            System.out.println("4. Eliminar Pabellón");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Pabellon.createPabellon();
                    break;
                case 2:
                    Pabellon.readPabellon();
                    break;
                case 3:
                    Pabellon.updatePabellon();
                    break;
                case 4:
                    Pabellon.deletePabellon();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void departamentoMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==========");
            System.out.println("Menú Departamento");
            System.out.println("==========");
            System.out.println("1. Crear Departamento");
            System.out.println("2. Leer Departamento");
            System.out.println("3. Actualizar Departamento");
            System.out.println("4. Eliminar Departamento");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Departamento.createDepartamento();
                    break;
                case 2:
                    Departamento.readDepartamento();
                    break;
                case 3:
                    Departamento.updateDepartamento();
                    break;
                case 4:
                    Departamento.deleteDepartamento();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void doctorMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==========");
            System.out.println("Menú Doctor");
            System.out.println("==========");
            System.out.println("1. Crear Doctor");
            System.out.println("2. Leer Doctor");
            System.out.println("3. Actualizar Doctor");
            System.out.println("4. Eliminar Doctor");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Doctor.createDoctor();
                    break;
                case 2:
                    Doctor.readDoctor();
                    break;
                case 3:
                    Doctor.updateDoctor();
                    break;
                case 4:
                    Doctor.deleteDoctor();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void pacienteMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("==========");
            System.out.println("Menú Paciente");
            System.out.println("==========");
            System.out.println("1. Crear Paciente");
            System.out.println("2. Leer Paciente");
            System.out.println("3. Actualizar Paciente");
            System.out.println("4. Eliminar Paciente");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Paciente.createPaciente();
                    break;
                case 2:
                    Paciente.readPaciente();
                    break;
                case 3:
                    Paciente.updatePaciente();
                    break;
                case 4:
                    Paciente.deletePaciente();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
