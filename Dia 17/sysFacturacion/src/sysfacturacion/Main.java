package sysfacturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Método para obtener la conexión a la base de datos
    private static Connection getConnection() {
        return MySQLConnection.getConnection();
    }

    // Método para obtener un cliente por nombre
    private static Cliente obtenerClientePorNombre(String nombre) {
        Connection connection = getConnection();
        Cliente cliente = null;
        try {
            String query = "SELECT * FROM Cliente WHERE Nombre = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("ID_Cliente");
                int tipoClienteId = resultSet.getInt("ID_TipoCliente");
                // Obtener el tipo de cliente
                String tipo = obtenerTipoClientePorId(tipoClienteId);
                cliente = new Cliente(id, nombre, tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    // Método para obtener el tipo de cliente por ID
    private static String obtenerTipoClientePorId(int id) {
        Connection connection = getConnection();
        String tipo = null;
        try {
            String query = "SELECT Nombre FROM TipoCliente WHERE ID_TipoCliente = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                tipo = resultSet.getString("Nombre");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipo;
    }

    // Método para obtener un producto por ID
    private static Producto obtenerProductoPorId(int id) {
        Connection connection = getConnection();
        Producto producto = null;
        try {
            String query = "SELECT * FROM Producto WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                producto = new Producto(id, nombre, precio, 0); // El tipo se establecerá en otro lugar
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    // Método para obtener todos los productos
    private static List<Producto> obtenerProductos() {
        Connection connection = getConnection();
        List<Producto> productos = new ArrayList<>();
        try {
            String query = "SELECT * FROM Producto";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                productos.add(new Producto(id, nombre, precio, 0)); // El tipo se establecerá en otro lugar
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    // Método para obtener todos los clientes
    private static List<Cliente> obtenerClientes() {
        Connection connection = getConnection();
        List<Cliente> clientes = new ArrayList<>();
        try {
            String query = "SELECT * FROM Cliente";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID_Cliente");
                String nombre = resultSet.getString("Nombre");
                int tipoClienteId = resultSet.getInt("ID_TipoCliente");
                // Obtener el tipo de cliente
                String tipo = obtenerTipoClientePorId(tipoClienteId);
                clientes.add(new Cliente(id, nombre, tipo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método para registrar una factura en la base de datos
    private static void registrarFacturaEnBaseDeDatos(Factura factura) {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false); // Hacer la transacción atómica

            // Insertar la factura
            String queryFactura = "INSERT INTO Factura (ID_Cliente, Fecha, ValorTotal, ValorConDescuento) VALUES (?, CURDATE(), ?, ?)";
            PreparedStatement statementFactura = connection.prepareStatement(queryFactura, PreparedStatement.RETURN_GENERATED_KEYS);
            statementFactura.setInt(1, factura.getCliente().getId());
            statementFactura.setDouble(2, factura.getValorTotal());
            statementFactura.setDouble(3, factura.getValorConDescuento());
            statementFactura.executeUpdate();

            // Obtener el ID generado para la factura
            ResultSet generatedKeys = statementFactura.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idFactura = generatedKeys.getInt(1);

                // Insertar los productos de la factura
                String queryFacturaProducto = "INSERT INTO FacturaProducto (ID_Factura, ID_Producto, Cantidad, Subtotal) VALUES (?, ?, ?, ?)";
                PreparedStatement statementFacturaProducto = connection.prepareStatement(queryFacturaProducto);
                for (FacturaProducto fp : factura.getProductos()) {
                    statementFacturaProducto.setInt(1, idFactura);
                    statementFacturaProducto.setInt(2, fp.getProducto().getId());
                    statementFacturaProducto.setInt(3, fp.getCantidad());
                    statementFacturaProducto.setDouble(4, fp.getSubtotal());
                    statementFacturaProducto.executeUpdate();
                }

                connection.commit(); // Confirmar la transacción
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para crear una nueva factura
    private static void nuevaFactura() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre del cliente:");
        String nombreCliente = scanner.nextLine();

        Cliente cliente = obtenerClientePorNombre(nombreCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Factura factura = new Factura(0, cliente); // ID ficticio para el ejemplo

        boolean agregarMasProductos = true;
        while (agregarMasProductos) {
            System.out.println("ID del producto:");
            int idProducto = scanner.nextInt();
            System.out.println("Cantidad:");
            int cantidad = scanner.nextInt();

            Producto producto = obtenerProductoPorId(idProducto);

            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            factura.agregarProducto(producto, cantidad);

            System.out.println("Producto agregado a la factura.");
            System.out.println("¿Desea agregar otro producto? (s/n):");
            scanner.nextLine(); // Consumir el salto de línea
            String respuesta = scanner.nextLine();
            agregarMasProductos = respuesta.equalsIgnoreCase("s");
        }

        factura.aplicarDescuento();
        registrarFacturaEnBaseDeDatos(factura);

        System.out.println("Factura registrada exitosamente.");
    }

    // Método para ver las facturas
    private static void verFacturas() {
        Connection connection = getConnection();
        try {
            String query = "SELECT * FROM Factura JOIN Cliente ON Factura.ID_Cliente = Cliente.ID_Cliente";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idFactura = resultSet.getInt("ID_Factura");
                String nombreCliente = resultSet.getString("Nombre");
                String fecha = resultSet.getString("Fecha");
                double valorTotal = resultSet.getDouble("ValorTotal");
                double valorConDescuento = resultSet.getDouble("ValorConDescuento");

                System.out.println("ID Factura: " + idFactura + ", Cliente: " + nombreCliente +
                        ", Fecha: " + fecha + ", Valor Total: $" + valorTotal +
                        ", Valor con Descuento: $" + valorConDescuento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para registrar un nuevo producto
    private static void registrarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("Nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("ID del tipo de producto (1 = fruta y 2 = verdura):");
        int tipo = scanner.nextInt();
        System.out.println("Precio del producto:");
        double precio = scanner.nextDouble();

        Connection connection = getConnection();
        try {
            String query = "INSERT INTO Producto (nombre, precio, tipo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setDouble(2, precio);
            statement.setInt(3, tipo);
            statement.executeUpdate();

            System.out.println("Producto registrado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para ver productos
    private static void verProductos() {
        List<Producto> productos = obtenerProductos();
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() +
                    ", Precio: $" + producto.getPrecio());
        }
    }

    // Método para registrar un nuevo cliente
    private static void registrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("ID del tipo de cliente (1 = concurrente y 2 =  nuevo):");
        int tipo = scanner.nextInt();

        Connection connection = getConnection();
        try {
            String query = "INSERT INTO Cliente (Nombre, ID_TipoCliente) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setInt(2, tipo);
            statement.executeUpdate();

            System.out.println("Cliente registrado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para ver clientes
    private static void verClientes() {
        List<Cliente> clientes = obtenerClientes();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() +
                    ", Tipo: " + cliente.getTipo());
        }
    }

    // Método para mostrar el menú principal
    private static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Menú Principal =====");
            System.out.println("1. Productos");
            System.out.println("2. Clientes");
            System.out.println("3. Facturas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    menuProductos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    menuFacturas();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para mostrar el menú de productos
    private static void menuProductos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Menú Productos =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Ver productos");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    verProductos();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para mostrar el menú de clientes
    private static void menuClientes() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Menú Clientes =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver clientes");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    verClientes();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para mostrar el menú de facturas
    private static void menuFacturas() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Menú Facturas =====");
            System.out.println("1. Nueva factura");
            System.out.println("2. Ver facturas");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    nuevaFactura();
                    break;
                case 2:
                    verFacturas();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void main(String[] args) {
        menuPrincipal();
    }
}
