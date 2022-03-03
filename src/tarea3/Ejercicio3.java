package tarea3;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		int contador = 0;
		/*
		 * 	Implementa un programa Java que lea números hasta que se teclee uno
			negativo. Al final debe mostrar cuántos números se han introducido.
			*/
		while (true) { // Inicio del bucle infinito hasta acceder a break.
			System.out.println("Introduce un número"); 
			Scanner entrada = new Scanner(System.in); // Recoge la entrada del usuario
			double numero = entrada.nextDouble(); // Guarda el dato en una variable double
			if (contador(numero)) { // En una condicion if, llama a funcion boleana.
				contador++; // En caso positivo, se incrementará en 1
			}else {
				System.out.println("Fin del bucle. Has introducido "+contador+" números positivos."); // En caso negativo, salta mensaje.
				break; // Rompe el bucle
			}
		}
	}
	
	private static boolean contador(double nElegido) { // Método que comprueba si es positivo o negativo.
		if (nElegido < 0) { // Comprueba si es negativo
			return false; // Devuelve false en caso de ser negativo.
		}
		return true; // Devuelve true en caso de ser positivo.
	}
}
