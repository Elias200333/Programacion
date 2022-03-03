package examenProgramacion;

import java.util.Scanner;

public class Ejercicio1 {
	
	/**
	 * Pre: ---
	 * Post: el método mejores ordena la tabla enviada de mayor a menor. Una vez realizado,
	 * imprime por pantalla tantos primeros numeros como eleccion haya puesto el usuario, y estos,
	 * al estar ordenados, los muestra de mayor a menor.
	 * 
	 * */
	
	public static void mejores(int[] tabla, int eleccion) {
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if (tabla[i] > tabla[j]) {
					int cambio = tabla[i];
					tabla[i] = tabla[j];
					tabla[j] = cambio;
				}
			}
		}
		
		System.out.print("Mostrando ");
		
		if (eleccion == 1) {
			System.out.println("el mejor número:");
		} else {
			System.out.println("los mejores "+eleccion+" números:");
		}
		
		System.out.println("____________________");
		
		for (int i = 0; i < eleccion; i++) {
			System.out.println(tabla[i]);
		}
	}
	
    public static void main(String[] args){
    	Scanner entrada = new Scanner(System.in);
    	
        int [] tabla = {10, 40, 100, 1, -3, 20, 50};
        int nElegido = 0;
        
        System.out.println("TABLA:");
        for (int i = 0; i < tabla.length; i++) {
        	System.out.print(tabla[i]+" ");
        }
        System.out.println("\n");
        
        while (true) {
        	System.out.println("Introduce la cantidad de números a escala que deseas mostrar: ");
        	nElegido = entrada.nextInt();
        	
        	if (nElegido > 0) {
        		break;
        	} else {
        		System.out.println("Lo siento, el número introducido \nes negativo o es 0, y no podemos operar así.");
        		System.out.println();
        	}
        }
        System.out.println();
        
        mejores(tabla, nElegido);
    }
}
