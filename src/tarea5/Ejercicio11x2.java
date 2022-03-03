package tarea5;

import java.util.Scanner;

public class Ejercicio11x2 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres:");
		String texto = entrada.next();
		
		StringBuilder texto2 = new StringBuilder(texto);
		
		texto = texto2.reverse().toString();
		
		System.out.println(texto);
	}
}
