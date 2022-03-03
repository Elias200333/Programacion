package tarea7;

import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("CREANDO TABLA");
		int [] a = new int [5];
		
		a[0] = 5; a[1] = 4; a[2] = 3; a[3] = 2; a[4] = 1;
		
		System.out.println(sum(a));
		
	}
	
	private static int sum(int [] tabla) {
		int resultado = 0;
		
		for (int i = 0; i < tabla.length; i++){
			resultado = resultado + tabla[i];
		}		
		return resultado;
	}
}