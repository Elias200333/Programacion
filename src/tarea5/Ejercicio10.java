package tarea5;

import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el número a sumarse");
		String numero = entrada.next();
		System.out.println("_________________");
		System.out.println("");
		System.out.print(numero + " -> ");
		
		for (int i = 0; i < numero.length();i++) {
			if (i == numero.length()-1) {
				System.out.print(numero.substring(i,i+1) + " = "+sumar(numero));
			} else {
				System.out.print(numero.substring(i,i+1) + " + ");
			}
		}
	}
	
	private static int sumar(String numero) {
		int numeroCalculado = 0;
		for (int i = 0; i < numero.length(); i++) {
			numeroCalculado += Integer.parseInt(numero.substring(i, i+1));
		}
		
		return numeroCalculado;
	}
}
