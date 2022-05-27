package examen3ev.ejercicio4;

public class Main {
    public static void main(String[] args) {
        tablaMultiplicar(30);
    }

    /**
     * Pre: ---
     *
     * Post: El método tablaMultiplicar recibe el dato a multiplicar y de
     * manera recursiva llama a su método con los datos necesarios.
     *
     * */

    public static void tablaMultiplicar(int numero){
        tablaMultiplicar(numero,100);
    }

    /**
     * Pre: ---
     *
     * Post: El método tablaMultiplicar recibe el dato a multiplicar más
     * su otro factor, que de manera recursiva mostrará el resultado de
     * cada iteración.
     *
     * */

    public static void tablaMultiplicar(int numero, int multiplicador){
        if (multiplicador >= 0){
            tablaMultiplicar(numero, (multiplicador-2));
            System.out.println(numero+"x"+multiplicador+"="+(numero*multiplicador));
        }
    }
}
