package sysfacturacion;

public enum Descuento {
    concurrente(0.1),
    nuevo(0.05);


    private double descuento;

    private Descuento(double descuento) {
        this.descuento = descuento;
    }

    public double getValorDescontado(double monto) {
        return this.descuento * monto;
    }
}
