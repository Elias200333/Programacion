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

    private static ArrayList<String> informacionVideojuegos(String nombre){
        ArrayList<String> plataformas = new ArrayList<>();

        File file = new File(nombre);
        int contador = 0;
        try {
            Scanner f = new Scanner(file);

            while(f.hasNextLine()) {
                String lineaLeida = f.nextLine();

                int posiciones = 1;

                String[] palabras = lineaLeida.split(",");

                if (palabras[posiciones].contains("\"")){
                    while (true){
                        posiciones++;
                        if (palabras[posiciones].contains("\"")){
                            break;
                        }
                    }
                }

                posiciones++;

                String palabra = palabras[posiciones];

                boolean noExiste = true;

                for (int i = 0; i < plataformas.size(); i++){
                    if (plataformas.get(i).equals(palabra)){
                        noExiste = false;
                        break;
                    }
                }

                if (noExiste){
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

        return plataformas;
    }
}
