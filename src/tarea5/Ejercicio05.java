package tarea5;

import java.util.Scanner;

public class Ejercicio05 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce una cadena de caracteres:");
		String texto = entrada.next();
		
		String cajaTexto = "";
		
		String comprobanteTexto = "aaa";
		
		int grupoLetras = comprobanteTexto.length();
		
		int nCaracteres = texto.length();
		
		int contador = 0;
		
		for (int i = grupoLetras; i <= nCaracteres; i++) {
			cajaTexto = texto.substring(i-grupoLetras,i);
			if (cajaTexto.contains(comprobanteTexto)) {
				contador++;
			}
		}
		
		System.out.println("He encontrado "+contador+" cadenas de '"+comprobanteTexto+"'.");
	}
}
