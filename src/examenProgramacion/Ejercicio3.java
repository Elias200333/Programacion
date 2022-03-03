package examenProgramacion;

import java.util.Scanner;

public class Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: El método maxFila recorre la tabla, ordenandola de mayor a menor, y muestra por pantalla 
	 * el primer dato de la tabla ordenada, es decir, el número mayor.
	 * 
	 * */
	
	public static void maxFila(int[][] tabla, int fila) {
		int filaVisual = fila;
		fila--;
		for (int i = 0; i < tabla[fila].length; i++) {
			for (int j = 0; j < tabla[fila].length; j++) {
				if (tabla[fila][i] > tabla[fila][j]) {
					int cambio = tabla[fila][i];
					tabla[fila][i] = tabla[fila][j];
					tabla[fila][j] = cambio;
				}
			}
		}
		
		System.out.println("\nEl salario más elevado de la fila "+filaVisual+" es: "+tabla[fila][0]);
	}
	
	
    public static void main(String[] args){
    	Scanner entrada = new Scanner(System.in);

    	int salarios[][] = { 
    			
    			{700, 900, 1300, 800, 790, 850} , 
    			{1000, 950, 1080, 1070, 1200, 1100} , 
    			{1300, 930, 1200, 1170, 1000, 1000} , 
    			{1500, 1950, 1880, 1978, 2200, 2100} , 
    			
    	};
    	
    	System.out.println("SALARIOS: \n");
    	for (int i = 0; i < salarios.length; i++) {
    		for (int j = 0; j < salarios[i].length;j++) {
    			System.out.print(salarios[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    	System.out.println("\nIntroduce la fila que desees ver el salario más alto: ");
    	
    	maxFila(salarios, entrada.nextInt());
    }
}
