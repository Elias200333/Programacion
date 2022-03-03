package tarea8;

import java.util.Scanner;

public class Ejercicio05{
	public static void main(String[] args) {
		String [] tablaNormal = new String [5];
		
		tablaNormal[0] = "P"; tablaNormal[1] = "peperoni";
		tablaNormal[2] = "bla";tablaNormal[3] = "patata";
		tablaNormal[4] = "Estoy";
		
		mayorYmenor(tablaNormal);
	}
	
	private static void mayorYmenor(String[] tabla){
		int nMayor = tabla[0].length();
		int indiceMayor = 0;
		int nMenor = tabla[0].length();
		int indiceMenor = 0;
		
		for (int i = 1; i < tabla.length; i++) {
			if (tabla[i].length() > nMayor) {
				nMayor = tabla[i].length();
				indiceMayor = i;
			}
			if (tabla[i].length() < nMenor) {
				nMenor = tabla[i].length();
				indiceMenor = i;
			}
		}
		
		System.out.println("El texto más largo es: "+tabla[indiceMayor]);
		System.out.println("El texto más corto es: "+tabla[indiceMenor]);
	}
}
