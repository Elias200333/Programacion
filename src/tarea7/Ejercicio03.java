package tarea7;

import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		String [] texto = new String [5];
		texto[0] = "hola";texto[1] = "pepe";texto[2] = "adios";texto[3] = "meme";texto[4] = "Elias";
		
		System.out.println(contains(texto, "Elias"));
	}
	
	private static boolean contains(String[] tabla, String cadena) {
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] == cadena) {
				return true;
			}
		} return false;
	}
}
