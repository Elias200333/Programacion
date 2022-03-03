package tarea5;

import java.util.Scanner;

public class Ejercicio06 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres:");
		String texto = entrada.nextLine();
		
		System.out.println(
				texto.substring(texto.length()-1,texto.length())+
				
				texto.substring(1,texto.length()-1)+
				
				texto.substring(0,1)
		);
	}
}
