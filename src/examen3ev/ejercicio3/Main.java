package examen3ev.ejercicio3;

public class Main {
    public static void main(String[] args) {
        ListaSimple prueba = new ListaSimple();

        prueba.add(new Node(5));
        prueba.add(new Node(20));
        prueba.add(new Node(10));
        prueba.add(new Node(15));
        prueba.show();
        System.out.println("_________________");
        prueba.eliminarMayor();
        prueba.show();
    }
}
