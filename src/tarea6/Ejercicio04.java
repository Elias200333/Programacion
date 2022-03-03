package tarea6;

import java.util.Scanner;

public class Ejercicio04 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres:");
		int numero = entrada.nextInt();
		
		for (int i = 1; i <= numero; i++) {
			for (int i2 = 1; i2 <= i; i2++) {
				System.out.print(i2);
			}
			for (int i2 = 1; i2 <= numero - i; i2++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
