package tarea2;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		/*
		 * Despues de crear una variable llamada "numeroElegido", creo un sistema de prints que indica la tabla
		 * de multiplicar. Seguidamente en el while, imprimimos el numero elegido y el indice concatenados en 
		 * un conjunto de strings que simulan una operación, cuyo resultado sea la multiplicacion de dichas 
		 * variables. 
		 * */
		System.out.println("Dame tu número");
		Scanner entrada = new Scanner(System.in);
		int numeroElegido = entrada.nextInt();
		int i = 0;
		System.out.println("Tabla de multiplicar del numero "+numeroElegido);
		System.out.println("____________________________________");
		while (i <= 10) {
			System.out.println(numeroElegido+" x "+i+" = "+numeroElegido*i);
			i++;
		}
	}
}
