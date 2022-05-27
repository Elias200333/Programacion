package examen3ev.ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        leerFichero("src/examen3ev/ejercicio1/HablanosDelDon.txt");
    }

    public static void leerFichero(String nombre){
        File file = new File(nombre);
        try {
            /*
             * Se crea un objeto [Formatter] al que se asocia un fichero deno-
             * minado [file].
             */
            Scanner f = new Scanner(file);
            /*
             * Recorremos el fichero linea por linea.
             */

            while(f.hasNextLine()) {
                String linea = f.nextLine();
                linea = linea.replaceAll(",", "").replaceAll("\\.","")
                        .replaceAll("¿", "").replaceAll("\\?", "");
                String[] palabras = linea.split(" ");

                System.out.println(linea);
            }
            /*
             * Se libera el fichero que estamos leyendo.
             */
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
        }
    }
}
