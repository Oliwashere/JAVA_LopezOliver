package sysfacturacion;

public class FacturaProducto {
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public FacturaProducto(Producto producto, int cantidad, double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return "FacturaProducto{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
