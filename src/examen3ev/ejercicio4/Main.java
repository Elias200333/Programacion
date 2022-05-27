package examen3ev.ejercicio4;

public class Main {
    public static void main(String[] args) {
        tablaMultiplicar(30);
    }

    public static void tablaMultiplicar(int numero){
        tablaMultiplicar(numero,100);
    }

    public static void tablaMultiplicar(int numero, int multiplicador){
        if (multiplicador >= 0){
            tablaMultiplicar(numero, (multiplicador-2));
            System.out.println(numero+"x"+multiplicador+"="+(numero*multiplicador));
        }
    }
}
