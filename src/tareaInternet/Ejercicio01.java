package tareaInternet;

import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CREANDO TABLA");
		int pares = 0;
		int paresVeces = 0;
		int impares = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Introduce el número ");
			int numero = entrada.nextInt();
			
			if (numero%2 == 0) {
				pares += numero;
				paresVeces++;
			} else {
				impares += numero;
			}
		}
		System.out.println("Promedio de pares: "+ pares/paresVeces);
		System.out.println("Total de impares: "+ impares);
	}
}