package tarea8;

import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CREANDO TABLA");
		int [] a = new int [5];
		
		a[0] = 5; a[1] = 2; a[2] = 3; a[3] = 2; a[4] = 4;
		
		calcularModa(a);
		
	}
	
	private static void calcularModa(int [] tabla) {
		int repeticiones = 1;
		
		int numeroModa = 0;
		
		boolean error = true;
		
		for (int i = 0; i < tabla.length; i++){
			int veces = 0;
			for (int j = 0; j < tabla.length; j++) {
				if (tabla[i] == tabla[j]) {
					veces++;
				}
			}
			if (veces > repeticiones) {
				repeticiones = veces;
				numeroModa = tabla[i];
				error = false;
			}
 		}
		if (error) {
			System.out.println("Error, no se ha encontrado el número de moda");
		} else {
			System.out.println("El primer numero de moda encontrado es el " + numeroModa);
		}
	}
}