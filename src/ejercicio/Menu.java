package ejercicio;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Dame el primer numero: ");
		int x = entrada.nextInt();
		System.out.print("Dame el segundo numero: ");
		int y = entrada.nextInt();
		System.out.println(x + " + " + y + " = " + Operaciones.sumar(x, y));
		System.out.println(x + " - " + y + " = " + Operaciones.restar(x, y));
	}
}
