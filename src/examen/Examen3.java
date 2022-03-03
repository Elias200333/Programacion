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

                String[] palabras = lineaLeida.split(",");

                boolean

                for (int i = 0; i < )
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
