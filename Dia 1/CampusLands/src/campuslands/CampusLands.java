/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campuslands;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusLands {

    // Clase Camper
    public static class Camper {
        String id;
        String nombres;
        String apellidos;
        String direccion;
        String acudiente;
        String telefonoCelular;
        String telefonoFijo;
        String estado;
        String riesgo;

        public Camper(String id, String nombres, String apellidos, String direccion, String acudiente,
                      String telefonoCelular, String telefonoFijo, String estado, String riesgo) {
            this.id = id;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.direccion = direccion;
            this.acudiente = acudiente;
            this.telefonoCelular = telefonoCelular;
            this.telefonoFijo = telefonoFijo;
            this.estado = estado;
            this.riesgo = riesgo;
        }
    }

    // Clase Ruta
    public static class Ruta {
        String nombre;
        List<String> modulos;

        public Ruta(String nombre, List<String> modulos) {
            this.nombre = nombre;
            this.modulos = modulos;
        }
    }

    // Clase AreaEntrenamiento
    public static class AreaEntrenamiento {
        String nombre;
        int capacidadMaxima;
        List<Camper> campers = new ArrayList<>();

        public AreaEntrenamiento(String nombre, int capacidadMaxima) {
            this.nombre = nombre;
            this.capacidadMaxima = capacidadMaxima;
        }

        public boolean agregarCamper(Camper camper) {
            if (campers.size() < capacidadMaxima) {
                campers.add(camper);
                return true;
            }
            return false;
        }
    }

    // Clase Trainer
    public static class Trainer {
        String id;
        String nombre;
        List<Ruta> rutas = new ArrayList<>();

        public Trainer(String id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public void agregarRuta(Ruta ruta) {
            rutas.add(ruta);
        }
    }

    // Clase Modulo
    public static class Modulo {
        String nombre;
        String fechaInicio;
        String fechaFinalizacion;
        Camper camper;
        double notaTeorica;
        double notaPractica;
        double quizes;

        public Modulo(String nombre, String fechaInicio, String fechaFinalizacion, Camper camper,
                      double notaTeorica, double notaPractica, double quizes) {
            this.nombre = nombre;
            this.fechaInicio = fechaInicio;
            this.fechaFinalizacion = fechaFinalizacion;
            this.camper = camper;
            this.notaTeorica = notaTeorica;
            this.notaPractica = notaPractica;
            this.quizes = quizes;
        }

        public double calcularNotaFinal() {
            return (notaTeorica * 0.3) + (notaPractica * 0.6) + (quizes * 0.1);
        }
    }

    // Clase Matricula
    public static class Matricula {
        Camper camper;
        Trainer trainer;
        Ruta ruta;
        String fechaInicio;
        String fechaFinalizacion;
        String salon;

        public Matricula(Camper camper, Trainer trainer, Ruta ruta, String fechaInicio, String fechaFinalizacion, String salon) {
            this.camper = camper;
            this.trainer = trainer;
            this.ruta = ruta;
            this.fechaInicio = fechaInicio;
            this.fechaFinalizacion = fechaFinalizacion;
            this.salon = salon;
        }
    }

    // Clase Reporte
    public static class Reporte {
        public void listarCampersInscritos(List<Camper> campers) {
            System.out.println("Campers en estado 'Inscrito':");
            for (Camper camper : campers) {
                if ("Inscrito".equals(camper.estado)) {
                    System.out.println(camper.nombres + " " + camper.apellidos);
                }
            }
        }

        public void listarCampersAprobados(List<Camper> campers) {
            System.out.println("Campers en estado 'Aprobado':");
            for (Camper camper : campers) {
                if ("Aprobado".equals(camper.estado)) {
                    System.out.println(camper.nombres + " " + camper.apellidos);
                }
            }
        }

        public void listarTrainers(List<Trainer> trainers) {
            System.out.println("Trainers en CampusLands:");
            for (Trainer trainer : trainers) {
                System.out.println(trainer.nombre);
            }
        }

        public void listarCampersBajoRendimiento(List<Camper> campers, List<Modulo> modulos) {
            System.out.println("Campers con bajo rendimiento:");
            for (Modulo modulo : modulos) {
                if (modulo.calcularNotaFinal() < 60) {
                    System.out.println(modulo.camper.nombres + " " + modulo.camper.apellidos);
                }
            }
        }

        public void listarCampersYTrainersEnRuta(List<Camper> campers, List<Trainer> trainers) {
            System.out.println("Campers y Trainers en rutas de entrenamiento:");
            for (Camper camper : campers) {
                System.out.println("Camper: " + camper.nombres + " " + camper.apellidos);
            }
            for (Trainer trainer : trainers) {
                System.out.println("Trainer: " + trainer.nombre);
            }
        }

        public void listarResultadosModulos(List<Modulo> modulos) {
            System.out.println("Resultados de módulos:");
            for (Modulo modulo : modulos) {
                System.out.println("Camper: " + modulo.camper.nombres + " " + modulo.camper.apellidos + 
                                   ", Módulo: " + modulo.nombre + 
                                   ", Nota Final: " + modulo.calcularNotaFinal());
            }
        }
    }

    // Menú Principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Camper> campers = new ArrayList<>();
        List<Ruta> rutas = new ArrayList<>();
        List<AreaEntrenamiento> areas = new ArrayList<>();
        List<Trainer> trainers = new ArrayList<>();
        List<Modulo> modulos = new ArrayList<>();
        List<Matricula> matriculas = new ArrayList<>();
        Reporte reporte = new Reporte();

        // Crear rutas de entrenamiento
        rutas.add(new Ruta("NodeJS", List.of("Fundamentos de programación", "Programación Web")));
        rutas.add(new Ruta("Java", List.of("Programación formal", "Bases de datos")));
        rutas.add(new Ruta("NetCore", List.of("Backend")));

        // Crear áreas de entrenamiento
        areas.add(new AreaEntrenamiento("Área 1", 33));
        areas.add(new AreaEntrenamiento("Área 2", 33));
        areas.add(new AreaEntrenamiento("Área 3", 33));

        boolean exit = false;

        while (!exit) {
            System.out.println("CampusLands ERP");
            System.out.println("1. Menú Coordinador");
            System.out.println("2. Menú Trainer");
            System.out.println("3. Menú Reportes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (choice) {
                case 1:
                    menuCoordinador(scanner, campers, rutas, areas, trainers, modulos, matriculas);
                    break;
                case 2:
                    menuTrainer(scanner, trainers, rutas);
                    break;
                case 3:
                    menuReportes(scanner, reporte, campers, trainers, modulos);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    // Menú Coordinador
    public static void menuCoordinador(Scanner scanner, List<Camper> campers, List<Ruta> rutas, List<AreaEntrenamiento> areas,
                                       List<Trainer> trainers, List<Modulo> modulos, List<Matricula> matriculas) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menú Coordinador");
            System.out.println("1. CRUD para campers");
            System.out.println("2. Registrar notas");
            System.out.println("3. Asignar rutas");
            System.out.println("4. Ver trainers");
            System.out.println("5. Ver reportes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (choice) {
                case 1:
                    crudCampers(scanner, campers);
                    break;
                case 2:
                    registrarNotas(scanner, campers, modulos);
                    break;
                case 3:
                    asignarRutas(scanner, campers, rutas, areas, matriculas);
                    break;
                case 4:
                    verTrainers(trainers);
                    break;
                case 5:
                    // Aquí puedes llamar a las funcionalidades de reportes si lo deseas
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Funciones del menú Coordinador
    public static void crudCampers(Scanner scanner, List<Camper> campers) {
        System.out.println("CRUD para campers");
        // Aquí puedes agregar, editar o eliminar campers
    }

    public static void registrarNotas(Scanner scanner, List<Camper> campers, List<Modulo> modulos) {
        System.out.println("Registrar notas");
        System.out.print("Ingrese ID del camper: ");
        String idCamper = scanner.nextLine();
        Camper camper = campers.stream().filter(c -> c.id.equals(idCamper)).findFirst().orElse(null);

        if (camper != null) {
            System.out.print("Ingrese nota teórica: ");
            double notaTeorica = scanner.nextDouble();
            System.out.print("Ingrese nota práctica: ");
            double notaPractica = scanner.nextDouble();
            System.out.print("Ingrese nota de quizes: ");
            double quizes = scanner.nextDouble();
            scanner.nextLine(); // Consumir nueva línea

            Modulo modulo = new Modulo("Módulo 1", "2024-07-01", "2024-07-31", camper, notaTeorica, notaPractica, quizes);
            modulos.add(modulo);

            double notaFinal = modulo.calcularNotaFinal();
            if (notaFinal >= 60) {
                camper.estado = "Aprobado";
            }
        } else {
            System.out.println("Camper no encontrado.");
        }
    }

    public static void asignarRutas(Scanner scanner, List<Camper> campers, List<Ruta> rutas, List<AreaEntrenamiento> areas,
                                    List<Matricula> matriculas) {
        System.out.println("Asignar rutas");
        // Aquí puedes asignar rutas a los campers aprobados
    }

    public static void verTrainers(List<Trainer> trainers) {
        System.out.println("Ver trainers");
        for (Trainer trainer : trainers) {
            System.out.println(trainer.nombre);
        }
    }

    // Menú Trainer
    public static void menuTrainer(Scanner scanner, List<Trainer> trainers, List<Ruta> rutas) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menú Trainer");
            System.out.println("1. Ver rutas");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (choice) {
                case 1:
                    verRutas(rutas);
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Funciones del menú Trainer
    public static void verRutas(List<Ruta> rutas) {
        System.out.println("Ver rutas");
        for (Ruta ruta : rutas) {
            System.out.println("Ruta: " + ruta.nombre);
            for (String modulo : ruta.modulos) {
                System.out.println("  Módulo: " + modulo);
            }
        }
    }

    // Menú Reportes
    public static void menuReportes(Scanner scanner, Reporte reporte, List<Camper> campers, List<Trainer> trainers,
                                    List<Modulo> modulos) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menú Reportes");
            System.out.println("1. Listar campers inscritos");
            System.out.println("2. Listar campers aprobados");
            System.out.println("3. Listar trainers");
            System.out.println("4. Listar campers con bajo rendimiento");
            System.out.println("5. Listar campers y trainers en rutas de entrenamiento");
            System.out.println("6. Mostrar resultados de módulos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (choice) {
                case 1:
                    reporte.listarCampersInscritos(campers);
                    break;
                case 2:
                    reporte.listarCampersAprobados(campers);
                    break;
                case 3:
                    reporte.listarTrainers(trainers);
                    break;
                case 4:
                    reporte.listarCampersBajoRendimiento(campers, modulos);
                    break;
                case 5:
                    reporte.listarCampersYTrainersEnRuta(campers, trainers);
                    break;
                case 6:
                    reporte.listarResultadosModulos(modulos);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
