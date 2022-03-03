package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Examen2 {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero: ");
        String ruta = entrada.nextLine();
        System.out.println("Introduce el nº mínimo: ");
        int numero = entrada.nextInt();
        int nPalabras = palabrasmasLargasQue(ruta, numero);
        System.out.println("Hay un total de "+nPalabras+
                " palabras a partir de la longitud "+numero);
    }

    private static int palabrasmasLargasQue(String nombre, int numero){
        File file = new File(nombre);
        int contador = 0;
        try {
            Scanner f = new Scanner(file);

            while(f.hasNextLine()) {
                String lineaLeida = f.nextLine();

                String parentesisI = "\\(";
                String parentesisF = "\\)";

                lineaLeida = lineaLeida.replaceAll(",","")
                        .replaceAll("\\.","")
                        .replaceAll(",","")
                        .replaceAll(parentesisI,"")
                        .replaceAll(parentesisF,"")
                        .replaceAll("\"","")
                        .replaceAll(":","");

                String[] palabras = lineaLeida.split(" ");

                for (int i = 0; i < palabras.length; i++){
                    if (palabras[i].length() >= numero){
                        contador++;
                    }
                }
            }
            /*
             * Se libera el fichero que estamos leyendo.
             */
            f.close();

        } catch (FileNotFoundException errorEnArchivo) {
            errorEnArchivo.printStackTrace();
        }
        return contador;
    }
}
