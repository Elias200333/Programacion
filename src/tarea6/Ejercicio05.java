package tarea6;

import java.util.Scanner;

public class Ejercicio05 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Indica el máximo numero a mostrar:");
		
		int nElegido = entrada.nextInt();
		
		System.out.println("Iniciando programa:");
		System.out.println("__________________________________________________");
		System.out.println();
		System.out.print("n         ");
		
		for (int i = 1; i <= 4; i++) {
			System.out.print("n^"+i+"       ");
		}
		
		System.out.println();
		
		for (int i = 1; i <= nElegido; i++) {
			System.out.print(espaciado(i));
			for (int i2 = 1; i2 <= 4; i2++) {
				int resultado = elevar(i, i2);
				System.out.print(espaciado(resultado));
			}
			System.out.println();
		}
	}
	
	private static int elevar(int numero, int elevacion) {
		int resultado = 1;
		for (int i = 0; i < elevacion; i++) {
			resultado = resultado * numero;
		}
		return resultado;
	}
	
	private static String espaciado(int dato) {
		String datoFinal = Integer.toString(dato);
		
		int longitud = datoFinal.length();
		
		String caja = "";
		
		for (int i = 0; i < 10-longitud; i++) {
			caja = caja + " ";
		}
		
		datoFinal = datoFinal + caja;
		
		return datoFinal;
	}
}
