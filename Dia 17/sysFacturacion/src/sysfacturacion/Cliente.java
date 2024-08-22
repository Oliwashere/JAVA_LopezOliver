package sysfacturacion;

public class Cliente {
    private int id; // ID del cliente en la base de datos
    private String nombre;
    private String tipo;

    public Cliente(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getter para el ID del cliente
    public int getId() {
        return id;
    }

    // Getter para el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Getter para el tipo del cliente
    public String getTipo() {
        return tipo;
    }

    // Setter para el nombre del cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Setter para el tipo del cliente
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
