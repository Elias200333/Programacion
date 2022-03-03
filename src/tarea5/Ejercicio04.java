package tarea5;

import java.util.Scanner;

public class Ejercicio04 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres:");
		String texto = entrada.next();
		int textoNumero = texto.length();
		
		System.out.println(textoNumero);
		
		
	}
}
