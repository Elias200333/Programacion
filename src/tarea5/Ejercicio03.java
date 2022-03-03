package tarea5;

import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de carácteres:");
		String texto = entrada.next();
		
		int contador= 0;
		
		for (int i = 0; i < texto.length()-3; i++) {
			System.out.println("entro");
			System.out.println(i);
			String cadena = texto.substring(i, i+3);
			System.out.println(cadena);
		}
	}
}
