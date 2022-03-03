package modoHistoria;

import java.util.Scanner;

public class JUEGO {
	public static void main(String[] args) {
		
		String jugador = introduccion();
		
		int nivel = nivel(jugador);
		
		System.out.println("El jugador " + jugador + " ha elegido el nivel "+ nivel + ".");
	}
	
	private static String introduccion() {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Bienvenido a este modo historia.");
		System.out.println("Por favor, introduce tu nombre de jugador:");
		
		String jugador = entrada.next();
		
		System.out.println("Bienvenido, " + jugador + ". Este es un modo historia de la vida.");
		System.out.println();
		System.out.println("Este juego consiste en una serie de preguntas en el que deberás coger el mejor camino.");
		System.out.println("Deberas escoger el mejor camino para seguir adelante.");
		System.out.println("Si estás listo, escribe '0' y pulsa enter para continuar");
		
		while (true) {
			int confirmacion = entrada.nextInt();
			if ( confirmacion == 0){
				return jugador;
			}else {
				System.out.println("Introduce '0' para continuar.");
			}
		}		
	}
	
	private static int nivel(String jugador) {
		Scanner entrada = new Scanner(System.in);
		
		int nivel = 0;
		
		while (true) {
			System.out.println("De acuerdo, " + jugador + ". Selecciona el nivel que desees:");
			System.out.println("1. " + jugador + " cruzando la calle.");
			System.out.println("2. " + jugador + " estando en clases.");
			System.out.println("3. " + jugador + " estando en casa.");
			System.out.println("4. " + jugador + " intentando dormir.");
			
			nivel = entrada.nextInt();
			
			if (nivel >= 1 && nivel <= 4) {
				return nivel;
			}
			else {
				System.out.println("Tienes que poner un numero de los de arriba.");
			}
		}
	}
}