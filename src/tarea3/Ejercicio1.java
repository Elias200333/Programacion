package tarea3;

import java.util.Scanner;

public class Ejercicio1 {
	/*
	 * 	POST: Implementa un programa Java que lea un número real (decimales) y
		muestre su cuadrado. Repetir el proceso hasta que se introduzca un
		número negativo.
		*/
	
	public static void main(String[] args) { 
		while (true) { // Inicio del bucle infinito hasta acceder a break.
			System.out.println("Introduce el número que desees elevar al cuadrado \n\nNota: No se aceptan numeros negativos.");
			Scanner entrada = new Scanner(System.in); // Introduce la entrada
			double numero = entrada.nextDouble(); // Convierte la entrada a un double
			if (numero > 0) { // Verifica si es negativo
				System.out.println("Tu cuadrado es "+cuadrado(numero)); // Ejecuta el método en caso de ser positivo
			} else {
				System.out.println("Lo siento, no se aceptan números negativos"); // Da mensaje de error en caso de ser negativo
				break; // Rompe el bucle
			}
		}
	}
	private static double cuadrado(double nElegido) { // Método para elevar al cuadrado cualquier parametro double
		nElegido = nElegido * nElegido; // Multiplica el numero por si mismo para elevar al cuadrado.
		return nElegido; // Retorna el resultado.
	}
}
