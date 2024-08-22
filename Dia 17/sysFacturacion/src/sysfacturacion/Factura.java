package sysfacturacion;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<FacturaProducto> productos;
    private double valorTotal;
    private double valorConDescuento;

    public Factura(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.valorTotal = 0.0;
        this.valorConDescuento = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        double subtotal = producto.getPrecio() * cantidad;
        this.productos.add(new FacturaProducto(producto, cantidad, subtotal));
        this.valorTotal += subtotal;
    }

    public double calcularDescuento() {
        double descuento = 0.0;
        if (this.valorTotal > 50000) {
            // Suponiendo que la clase Cliente tiene un método getTipo() que devuelve un tipo de cliente.
            if (cliente.getTipo().equals("Concurrente")) {
                descuento = valorTotal * 0.10; // 10% de descuento
            } else if (cliente.getTipo().equals("Nuevo")) {
                descuento = valorTotal * 0.05; // 5% de descuento
            }
        }
        return descuento;
    }

    public void aplicarDescuento() {
        this.valorConDescuento = this.valorTotal - calcularDescuento();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<FacturaProducto> getProductos() {
        return productos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorConDescuento() {
        return valorConDescuento;
    }
}
