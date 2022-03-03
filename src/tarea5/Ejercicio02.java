package tarea5;

import java.util.Scanner;

public class Ejercicio02 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el primer número:");
		double num1 = entrada.nextDouble();
		
		System.out.println("Introduce el segundo número:");
		double num2 = entrada.nextDouble();
		
		if (num1 <= 1 & num1 >= 0 & num2 <= 1 & num2 >= 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
