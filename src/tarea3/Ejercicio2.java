package tarea3;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		/*
		 * 	Implementa un programa Java que lea un número real (decimales) e
			indique si es positivo o negativo. El proceso se repetirá hasta que se
			introduzca un 0.
			*/
		while (true) { // Inicio del bucle infinito hasta acceder a break.
			System.out.println("Introduce un número"); 
			Scanner entrada = new Scanner(System.in); // Recoge la entrada del usuario
			double numero = entrada.nextDouble(); // Guarda el dato en una variable double
			if (numero == 0) { // Verifica si es cero
				System.out.println("Lo siento, introdujistes el 0"); // Mensaje en caso de que salga 0
				break; // Rompe el bucle
			} else {
				System.out.println("Tu número es "+positivoNegativo(numero)); // Muestra el resultado concatenado con un método.
			}
		}
	}
	
	private static String positivoNegativo(double nElegido) { // Metodo que comprueba si es positivo o negativo.
		if (nElegido < 0) { // Comprueba si es negativo
			return "negativo"; // Devuelve negativo
		}
		return "positivo"; // Devuelve positivo
	}
}
