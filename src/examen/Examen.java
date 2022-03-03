package examen;

import java.util.ArrayList;
import java.util.Scanner;

public class Examen {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el número de jugadores:");
        int jugadores = entrada.nextInt();
        elRapido(jugadores);
    }

    private static void elRapido(int jugadores){
        /* Creación de jugadores */

        ArrayList<Jugador> jugador = new ArrayList<Jugador>();

        for (int i = 0; i < jugadores; i++){
            String nombre = "Jugador "+i;
            int dorsal = i;
            int lvlPotencia = (int) (Math.random()*10+1);
            int lvlPorteria = (int) (Math.random()*10+1);
            Jugador caja = new Jugador(nombre, dorsal, lvlPotencia, lvlPorteria);
            jugador.add(caja);
        }


    }
}
