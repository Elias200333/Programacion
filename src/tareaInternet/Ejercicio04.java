package tareaInternet;

import java.util.Scanner;

public class Ejercicio04 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CREANDO TABLA");
		int [][] numeros = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
		};
		
		for (int fila = 0; fila < numeros.length; fila++) {
			for (int celda = 0; celda < numeros[fila].length; celda++) {
				System.out.print(numeros[fila][celda] + " ");
			}
			System.out.println();
		}
		
		System.out.println("__________________");
		
		for (int fila = 0; fila < numeros.length; fila++) {
			for (int celda = 0; celda < numeros[fila].length; celda++) {
				System.out.print("Introduce el nuevo dato de la celda "+celda+", de la fila "+fila+": ");
				numeros[fila][celda] = entrada.nextInt();
			}
			System.out.println();
		}
		
		System.out.println("____________________");
		
		for (int fila = 0; fila < numeros.length; fila++) {
			for (int celda = 0; celda < numeros[fila].length; celda++) {
				System.out.print(numeros[fila][celda] + " ");
			}
			System.out.println();
		}
	}
}
