package tarea5;

import java.util.Scanner;

public class Ejercicio08 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el primer numero para el incio del random");
		int numero1 = entrada.nextInt();
		System.out.println("Introduce el primer numero para el incio del random");
		int numero2 = entrada.nextInt();
		
		System.out.println("Generando numero aleatorio:");
		System.out.println(Math.floor((Math.random()*numero2)+numero1));
	}
}
