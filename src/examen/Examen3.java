package examen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Examen3 {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero: ");
        String ruta = entrada.nextLine();
        ArrayList<String> plataformas = informacionVideojuegos(ruta);
        System.out.println("Se encuentran las siguientes plataformas:");
        System.out.println("_________________________________________");
        for (int i = 0; i < plataformas.size(); i++){
            System.out.println(plataformas.get(i));
        }
    }

    /**
     * Pre: ---
     *
     * Post: El método informacionVideojuegos devuelve un ArrayList con
     * una lista de strings que indican la variedad de plataformas que
     * ha detectado.*/

    private static ArrayList<String> informacionVideojuegos(String nombre){
        ArrayList<String> plataformas = new ArrayList<>();

        File file = new File(nombre);
        try {
            Scanner f = new Scanner(file);

            while(f.hasNextLine()) {
                String lineaLeida = f.nextLine();

                int posiciones = 1; // Detecta a partir del nombre en caso de que haya comillas

                String[] palabras = lineaLeida.split(",");

                if (palabras[posiciones].contains("\"")){ // Si detecta comillas
                    /*Con este algoritmo, calculamos donde acaba el atributo con comillas*/
                    while (true){
                        posiciones++;
                        if (palabras[posiciones].contains("\"")){
                            break;
                        }
                    }
                }

                posiciones++; // A raiz del campo anterior, nos situamos en plataforma

                String palabra = palabras[posiciones];

                boolean noExiste = true;

                for (int i = 0; i < plataformas.size(); i++){
                    if (plataformas.get(i).equals(palabra)){ // Comprueba si existe
                        noExiste = false;
                        break;
                    }
                }

                if (noExiste){ // Si no existe, lo añade al Arraylist
                    plataformas.add(palabras[2]);
                }
            }
            /*
             * Se libera el fichero que estamos leyendo.
             */
            f.close();

        } catch (FileNotFoundException errorEnArchivo) {
            errorEnArchivo.printStackTrace();
        }

        return plataformas; // Devuelve la lista
    }
}
