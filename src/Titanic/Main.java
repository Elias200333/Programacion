package Titanic;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo a analizar.");
        String ruta = entrada.nextLine();
        lecturaFicheroTitanic(ruta);
    }

    /**
     * Pre: ---
     *
     * Post: El método lecutaFicheroTitanic lee el archivo que recibe como parametro y muestra
     * el nº total de pasajeros, nº mujeres y hombres, así como el total de fallecidos y su
     * porcentaje.
     *
     * */

    private static void lecturaFicheroTitanic(String ruta) {
        System.out.println(ruta);
        File file = new File(ruta);
        try {

            System.out.println(file.exists());


            try (Scanner f = new Scanner(file)) {

                int totalPasajeros = 0;
                int nHombres = 0;
                int nMujeres = 0;
                int nHombresFallecidos = 0;
                int nMujeresFallecidas = 0;
                boolean primeraLinea = true;

                while (f.hasNextLine()) {
                    if (primeraLinea) {
                        primeraLinea = false;
                    } else {
                        String lineaLeida = f.nextLine();
                        String[] linea = lineaLeida.split(";");
                        for (int i = 0; i < linea.length; i++) {
                            if (i == 1) {
                                if (linea[i].equals("0")) {
                                    nMujeresFallecidas++;
                                    nHombresFallecidos++;
                                }
                            } else if (i == 4) {
                                if (linea[i].equals("female")) {
                                    nMujeres++;
                                    nHombresFallecidos--;
                                } else {
                                    nHombres++;
                                    nMujeresFallecidas--;
                                }
                            }
                        }
                        totalPasajeros++;
                    }
                }


                System.out.println("Información del titanic");
                System.out.println("________________________\n");
                System.out.println("Numero total de pasajeros: " + totalPasajeros);
                System.out.println("Numero total de mujeres: " + nMujeres);
                System.out.println("Numero total de hombres: " + nMujeres);

                f.close();
            }
        } catch (FileNotFoundException errorEnArchivo) {
            errorEnArchivo.printStackTrace();
        }
    }
}
