package examen3ev.ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        leerFichero("src/examen3ev/ejercicio1/HablanosDelDon.txt", "a");
    }

    /**
     * Pre: ---
     *
     * Post: el método leerFichero lee el documento de texto adjuntado, revisa linea por
     * linea y filtrando los caracteres especiales, añade a la base de datos los datos
     * según tienen los criterios del ejercicio.
     *
     * */

    public static void leerFichero(String nombre, String letra){
        MySQLAccess baseDatos = new MySQLAccess();
        File file = new File(nombre);
        try {
            Scanner f = new Scanner(file);
            /*
             * Recorremos el fichero linea por linea.
             */

            int contadorLineas = 1; // Indica la linea del documento
            while(f.hasNextLine()) {
                String linea = f.nextLine();

                /* Retiramos carácteres especiales. */

                linea = linea
                        .replaceAll(",", "")
                        .replaceAll("\\.","")
                        .replaceAll(";","")
                        .replaceAll("\\?", "")
                        .replaceAll("”","")
                        .replaceAll(":", "")
                        .replaceAll("\\¿", "");

                String[] palabras = linea.split(" ");

                for (String palabra : palabras){
                    if (palabra.substring(0,1).equalsIgnoreCase(letra) ||
                        palabra.substring(palabra.length()-1,palabra.length())
                            .equalsIgnoreCase(letra))
                    {
                        baseDatos.hacerSelect(letra, palabra, contadorLineas);
                    }
                }

                contadorLineas++;
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
