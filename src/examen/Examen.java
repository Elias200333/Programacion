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

    /**
     * Pre: ---
     *
     * Post: El método elRapido crea una tabla de jugadores con datos aleatorios,
     * y crea un sistema de rondas que, a medida que vayan perdiendo jugadores,
     * si pierden sus vidas son eliminados. Hasta que finalmente solo queda un
     * ganador.
     *
     * (Nota, para evitar mucha espera, y con propositos de pruebas, máximo 4
     * jugadores.)
     * */
    private static void elRapido(int jugadores){
        /* Creación de jugadores */

        ArrayList<Jugador> jugador = new ArrayList<Jugador>();

        for (int i = 0; i < jugadores; i++){
            String nombre = "Jugador "+i;
            int dorsal = i;
            int lvlPotencia = (int) (Math.random()*10+1);
            int lvlPorteria = (int) (Math.random()*5+1); // Tienen menos rango para evitar partidas infinitas
            Jugador caja = new Jugador(nombre, dorsal, lvlPotencia, lvlPorteria);
            jugador.add(caja);
        }

        /*Rondas*/

        int portero = (int) (Math.random()*jugador.size());

        int partido = 1;

        while (true){
            System.out.println("Ronda "+partido);
            if (jugador.size() == 1) { // Si solo queda un jugador
                break;
            }
            int player = portero + 1;
            if (player >= jugador.size()){ // Si el player supera el tamaño de la tabla
                player = 0;
            }
            if (portero >= jugador.size()){ // Si el portero supera el tamaño de la tabla
                portero = 0;
            }

            Jugador jugadorActual = jugador.get(player);
            Jugador porteroActual = jugador.get(portero);

            System.out.println("Jugador: "+jugadorActual.getNombre());
            System.out.println("Portero: "+porteroActual.getNombre());
            System.out.println("--------------------");

            int potencia = jugadorActual.getLvlPotencia();
            int porteria = porteroActual.getLvlPorteria();

            if (potencia > porteria){
                porteroActual.setVidas(porteroActual.getVidas()-1); // Reduce su vida
                System.out.println("Al jugador "+porteroActual.getNombre()+" le han marcado un gol.");
                if (porteroActual.getVidas() == 0){ // Si lo detecta sin vidas
                    System.out.println(porteroActual.getNombre()+" ha sido eliminado");
                    jugador.remove(portero);
                }
            } else {
                System.out.println("Al jugador "+porteroActual.getNombre()+" no le han marcado un gol.");
            }
            System.out.println("Tiro: "+potencia+", Porteria: "+porteria);
            System.out.println("__________________________________________________________________________");
            portero++;
            partido++;
        }

        Jugador ganador = jugador.get(0); // Obtener ganador

        System.out.println("Ganador: "+ganador.getNombre()+" con un total vidas de "+ganador.getVidas());
    }
}
