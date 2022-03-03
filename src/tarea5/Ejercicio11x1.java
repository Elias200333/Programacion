package tarea5;

import java.util.Scanner;

public class Ejercicio11x1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres:");
		String texto = entrada.nextLine();
		System.out.println("");
		
		for (int i = 0; i < texto.length(); i++) {
			System.out.print(texto.substring(texto.length()-1-i, texto.length()-i));
		}
	}
}
