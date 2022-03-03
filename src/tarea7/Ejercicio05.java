package tarea7;

import java.util.Scanner;

public class Ejercicio05{
	public static void main(String[] args) {
		String [] tablaNormal = new String [2];
		String [] tablaCopiada = new String [2];
		
		tablaNormal[0] = "Estoy ";tablaNormal[1] = "copiado.";
		
		tablaCopiada = copyArray(tablaNormal, tablaCopiada);
		
		for (int i = 0; i < tablaCopiada.length; i++) {
			System.out.print(tablaCopiada[i]);
		}
	}
	
	private static String [] copyArray(String[] tabla, String[] tabla2) {
		for (int i = 0; i < tabla.length; i++) {
			tabla2[i] = tabla[i];
		}
		return tabla2;
	}
}
