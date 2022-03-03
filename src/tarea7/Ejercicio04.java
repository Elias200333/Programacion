package tarea7;

import java.util.Scanner;

public class Ejercicio04 {
	public static void main(String[] args) {
		String [] texto = new String [5];
		texto[0] = "hola"; texto[1] = "pepe"; texto[2] = "adios"; texto[3] = "meme"; texto[4] = "Elias";
		
		System.out.println(contains(texto, "pepe"));
	}
	
	private static int contains(String[] tabla, String cadena) {
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] == cadena) {
				return i;
			}
		} return -1;
	}
}
