package carrera;

class Testigo {
    private boolean enMano;
    private Atleta atletaActual;

    public synchronized void tomar(Atleta atleta) {
        while (enMano || (atletaActual != null && atletaActual != atleta)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        enMano = true;
        atletaActual = atleta;
        System.out.println(atleta.getNombre() + " agarró el testigo y se puso a correr con los ojos cerrados (se va a caer).");
    }

    public synchronized void soltar() {
        enMano = false;
        System.out.println(atletaActual.getNombre() + " se tropezó con una piedra (Mero tonto) y dejó caer el testigo.");
        atletaActual = atletaActual.getNext();
        notifyAll();
    }
}