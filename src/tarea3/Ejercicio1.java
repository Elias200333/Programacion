package tarea3;

import java.util.Scanner;

public class Ejercicio1 {
	/*
	 * 	POST: Implementa un programa Java que lea un n�mero real (decimales) y
		muestre su cuadrado. Repetir el proceso hasta que se introduzca un
		n�mero negativo.
		*/
	
	public static void main(String[] args) { 
		while (true) { // Inicio del bucle infinito hasta acceder a break.
			System.out.println("Introduce el n�mero que desees elevar al cuadrado \n\nNota: No se aceptan numeros negativos.");
			Scanner entrada = new Scanner(System.in); // Introduce la entrada
			double numero = entrada.nextDouble(); // Convierte la entrada a un double
			if (numero > 0) { // Verifica si es negativo
				System.out.println("Tu cuadrado es "+cuadrado(numero)); // Ejecuta el m�todo en caso de ser positivo
			} else {
				System.out.println("Lo siento, no se aceptan n�meros negativos"); // Da mensaje de error en caso de ser negativo
				break; // Rompe el bucle
			}
		}
	}
	private static double cuadrado(double nElegido) { // M�todo para elevar al cuadrado cualquier parametro double
		nElegido = nElegido * nElegido; // Multiplica el numero por si mismo para elevar al cuadrado.
		return nElegido; // Retorna el resultado.
	}
}
