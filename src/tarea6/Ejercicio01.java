package tarea6;

import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean comprobar = true;
		
		System.out.println("Introduce un numero");
		int numero = entrada.nextInt();
		
		if(numero == 0) {
			System.out.println("cero");
		}else if(numero == 1) {
			System.out.println("uno");
		}else if(numero == 2) {
			System.out.println("dos");
		}else if(numero == 3) {
			System.out.println("tres");
		}else if(numero == 4) {
			System.out.println("cuatro");
		}else if(numero == 5) {
			System.out.println("cinco");
		}else if(numero == 6) {
			System.out.println("seis");
		}else if(numero == 7) {
			System.out.println("siete");
		}else if(numero == 8) {
			System.out.println("ocho");
		}else if(numero == 9) {
			System.out.println("nueve");	
		} else {
			System.out.println("OTROS");
		}
	}
}