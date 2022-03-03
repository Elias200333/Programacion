package tarea5;

import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean comprobar = true;
		
		System.out.println("Introduce un numero");
		int numeroAnterior = entrada.nextInt();
		
		for (int i = 0; i < 3; i++){
			System.out.println("Introduce un numero");
			int nElegido = entrada.nextInt();
			if (numeroAnterior != nElegido) {
				comprobar = false;
			}
		}
		
		if (comprobar) {
			System.out.println("Igual");
		}
		int numero = 0;
		numero = numero + 1;
	}
}
