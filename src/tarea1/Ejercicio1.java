package tarea1;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame un numero entero: ");
		
		int num = entrada.nextInt();
		System.out.println("La tabla de multiplicar del numero " + num + " es la siguiente:");
		System.out.println(num + "x 1 = "+num*1);
		System.out.println(num + "x 2 = "+num*2);
		System.out.println(num + "x 3 = "+num*3);
		System.out.println(num + "x 4 = "+num*4);
	}
}
