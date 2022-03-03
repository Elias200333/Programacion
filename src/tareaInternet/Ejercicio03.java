package tareaInternet;

import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("introduce la matricula del alumno quiere hacer: ");
		String matricula = entrada.next();
		
		int [] notas = new int [5];
		int promedio = 0;
		
		for (int i = 0; i < notas.length;i++) {
			int vuelta = i+1;
			System.out.print("Introduce la nota de la asignatura "+ vuelta +": ");
			notas[i] = entrada.nextInt();
			promedio += notas[i];
		}
		promedio = promedio/notas.length;
		System.out.println();
		System.out.print(matricula + ": ");
		System.out.print(promedio + "promedio, ");
		
	}
}
