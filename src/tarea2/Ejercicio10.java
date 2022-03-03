package tarea2;

import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
		/*En este algoritmo aplicamos el método Fibonacci*/
		int i = 0; //Indice
		Scanner entrada = new Scanner(System.in); //Entrada de datos
		int inicioFibonacci = entrada.nextInt(); //Guardado de datos
		int n1 = 0; //Primer sumando
		int n2 = 1; //Segundo sumando
		while (i < inicioFibonacci) {
			System.out.println(n1);//Imprime el primer sumando
			int suma = n2 + n1; //Creamos Variable interna para sumar sumandos
			n1 = n2; //Sustituimos el primer sumando por el segundo
			n2 = suma; //Sustituimos el segundo sumando por la variable suma
			i++;
		}
	}
}
