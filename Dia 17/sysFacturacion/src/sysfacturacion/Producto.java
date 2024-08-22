package sysfacturacion;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int tipo; // ID del tipo de producto

    public Producto(int id, String nombre, double precio, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo=" + tipo + "]";
    }
}
