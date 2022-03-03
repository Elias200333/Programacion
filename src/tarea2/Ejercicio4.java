package tarea2;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		/*Con los scanner de entrada, recolectamos la información de cada data requerido, utilizando el primer
		 * numero para guardarlo en la variable "i", y el segundo guardarlo en la variable "limite". De esta
		 * manera, indicamos en el bucle que imprima la variable "i", y que repita el bucle tantas veces como
		 * la variable "limite" permita.*/
		
		System.out.println("Dame tu primer número");
		Scanner entrada = new Scanner(System.in);
		int i = entrada.nextInt();
		System.out.println("Dame tu segundo número");
		int limite = entrada.nextInt();
		while (i < limite) {
			System.out.println(i);
			i++;
		}
	}
}
