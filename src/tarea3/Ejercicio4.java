package tarea3;

import java.util.Scanner;

public class Ejercicio4 {
	/*
	 * ¡IMPLEMENTA TU PRIMER JUEGO! Realiza un programa Java que adivine
		el número. El programa generará un número aleatorio entre 0 y 20
		(usando Math.random()) y luego irá pidiendo números al usuario
		indicando “mayor” o “menor” según sea mayor o menor con respecto al
		número generado aleatoriamente. El proceso termina cuando el usuario
		acierta, y deberá mostrar un mensaje de felicitaciones junto al número de
		intentos que ha necesitado el usuario.
		*/
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); // Recoge la entrada del usuario
		mensajeInicio(); // Ejecuta método con mensaje de inicio.
		String continuar = entrada.next(); // El void se pausa hasta que introduzca cualquier tecla y pulse intro.
		inicioJuego(); // Inicia el método para iniciar el juego.
	}
	
	private static void mensajeInicio() { // Método de mensaje de inicio
		System.out.println("BIENVENIDO A ESTE JUEGO");
		System.out.println("_______________________"); 
		System.out.println("Instrucciones:"); 
		System.out.println("1. Se generará un número \n  aleatorio  entre el 0 y el 20, que tendrás que adivinar.");
		System.out.println("");
		System.out.println("2. Si adivinas el número \n  ¡GANAS! Se te irá indicando \n si tu numero puesto es mayor o menor.");
		System.out.println("");
		System.out.println("3. Se te mostrará la cantidad \n  de intentos que te ha costado");
		System.out.println("");
		System.out.println("Si lo has entendido, pulsa cualquier tecla e intro para continuar.");
	}
	
	private static int random() { // Método para generar un número aleatorio.
		int numero = (int) Math.round(Math.random() * 20); // Genera un número random entre el 0 y el 19 redondeado por función round.
		return numero; // Retorna el número
	}
	
	private static void inicioJuego() { // Método para iniciar el juego.
		Scanner entrada = new Scanner(System.in); // Recoge la entrada del usuario.
		int nAleatorio = random(); // Llama al método random
		int contador = 0; // Creamos un contador para los intentos.
		
		System.out.println("Vale, ya se ha elegido el número. \n\nAhora, intenta adivinarlo.");

		while (true) { // Iniciamos el bucle de intentos.
			int numero = entrada.nextInt(); // Guardamos la entrada del usuario.
			if (numero == nAleatorio) { // Comprobamos si ha acertado el número.
				System.out.println("Enhorabuena. Has acertado el número en "+contador+" intentos."); // Mensaje en caso de acertarlo.
				break; // Rompe el bucle.
			} else { 
				contador++; // Incrementa el contador en caso de fallar.
				if (numero < nAleatorio) { // Comprueba si el número es más mayor que el aleatorio.
					System.out.println("Tu número es más mayor que el número elegido."); // Envia este mensaje en caso de ser más mayor.
				} else {
					System.out.println("Tu número es más pequeño que el número elegido."); // Envia este mensaje en caso de ser más pequeño.
				}
			}
		}
		String hola = "hoal";
		int longitud = hola.length();
		System.out.println(longitud);
	}
}
