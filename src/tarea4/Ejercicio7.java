package tarea4;

import java.util.Scanner;

public class Ejercicio7 {
	public static void main(String[] args) {
		/*
		 * Despues de crear una variable llamada "numeroElegido", creo un sistema de prints que indica la tabla
		 * de multiplicar. Seguidamente en el for, imprimimos el numero elegido y el indice concatenados en 
		 * un conjunto de strings que simulan una operación, cuyo resultado sea la multiplicacion de dichas 
		 * variables. 
		 * */
		System.out.println("Dame tu número");
		Scanner entrada = new Scanner(System.in);
		int numeroElegido = entrada.nextInt();
		System.out.println("Tabla de multiplicar del numero "+numeroElegido);
		System.out.println("____________________________________");
		
		for (int i = 0; i <= 10; i++) {
			System.out.println(numeroElegido+" x "+i+" = "+numeroElegido*i);
		}
	}
}
