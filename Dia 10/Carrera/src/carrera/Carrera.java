package carrera;

class Carrera {
    public static void main(String[] args) {
        Testigo testigo = new Testigo();

        Atleta atleta1 = new Atleta("Atleta 1", testigo);
        Atleta atleta2 = new Atleta("Atleta 2", testigo);
        Atleta atleta3 = new Atleta("Atleta 3", testigo);
        Atleta atleta4 = new Atleta("Atleta 4", testigo);

        atleta1.setNext(atleta2);
        atleta2.setNext(atleta3);
        atleta3.setNext(atleta4);

        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();
    }
}
