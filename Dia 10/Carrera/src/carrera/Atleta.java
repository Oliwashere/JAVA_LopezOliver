package carrera;

class Atleta extends Thread {
    private String nombre;
    private Testigo testigo;
    private Atleta next;

    public Atleta(String nombre, Testigo testigo) {
        this.nombre = nombre;
        this.testigo = testigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNext(Atleta next) {
        this.next = next;
    }

    public Atleta getNext() {
        return next;
    }

    @Override
    public void run() {
        testigo.tomar(this);
        try {
            long tiempoCarrera = (long) (9000 + Math.random() * 2000);
            Thread.sleep(tiempoCarrera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testigo.soltar();
    }
}