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

        /*Rondas*/

        int portero = (int) (Math.random()*jugador.size());

        while (true){
            if (jugador.size() == 1) {
                break;
            }
            int player = portero + 1;
            if (player == jugador.size()){
                player = 0;
            }

            Jugador jugadorActual = jugador.get(player);
            Jugador porteroActual = jugador.get(portero);

            if (jugadorActual.getLvlPotencia() > porteroActual.getLvlPorteria()){
                porteroActual.setVidas(porteroActual.getVidas()-1);
                if (porteroActual.getVidas() == 0){
                    jugador.remove(portero);
                }
            }

            portero++;
        }

        Jugador ganador = jugador.get(0);

        System.out.println("Ganador: "+ganador.getNombre()+" con un total vidas de "+ganador.getVidas());
    }
}
