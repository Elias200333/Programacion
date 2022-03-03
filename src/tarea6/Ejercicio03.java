package tarea6;

import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero:");
		int numero = entrada.nextInt();
		
		if (numero >= 3 && numero <= 10) {
			for (int i = numero; i > 0; i--) {
				System.out.println(numeroComillas(i));
			}
		}
	}
	
	private static String numeroComillas(int numero) {
		String caja = "";
		for (int i = 0; i < numero; i++) {
			caja = caja + "*";
		}
		return caja;
	}
}
