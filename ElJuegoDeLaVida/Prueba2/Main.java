package Prueba2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("EL JUEGO DE LA VIDA");
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el espacio en el que desee visualizar el programa.");
		
		System.out.print("Filas: ");
		int m = entrada.nextInt();
		System.out.print("Columnas: ");
		int n = entrada.nextInt();
		System.out.print("¿De cuantas generaciones deseas disponer? ");
		int generaciones = entrada.nextInt();
		
		generacion(m,n,generaciones);
	}
	
	public static void generacion(int m, int n, int generaciones) {
boolean [][] tabla = new boolean[m][n];
		
		Scanner entrada = new Scanner(System.in);
		
		boolean manual = false;
		
		System.out.println("¿Deseas introducirlo manualmente? y/n");
		
		if (entrada.next().contains("y")) {
			manual = true;
			System.out.println("Indica las celulas vivas o no indicando con:");
			System.out.println("v: viva\nm: muerta");
		}
		
		for (int h = 0; h < generaciones; h++) {
			System.out.println(tabla.length);
			if (h == 0) {
				for (int i = 0; i < m; i++) {
					for(int j = 0; j < n; j++) {
						if (manual) {
							if (entrada.next().contains("v")){
								tabla[i][j] = true;
							} else {
								tabla[i][j] = false;
							}
						} else {
							int valor = (int) Math.floor(Math.random()*5)+1;
							
							if (valor == 1) {
								tabla[i][j] = true;
							} else {
								tabla[i][j] = false;
							}
						}
					}
				}
			} else {
				tabla = siguienteGeneracion(tabla);
				if (tabla.length == 0) {
					break;
				}
			}
			System.out.println("Generacion "+h);
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (tabla[i][j]) {
						System.out.print(" * ");
					} else {
						System.out.print(" · ");
					}
				}
				System.out.println();
			}
			System.out.println("______________________________________");
		}
	}
	
	public static boolean[][] siguienteGeneracion(boolean[][] tabla){
		boolean[][] nuevaTabla = new boolean[tabla.length][tabla[0].length];
		
		boolean muertos = true;
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				int contador = 0;
				
				int posicionInicialI = 0;
				int posicionInicialJ = 0;
				int posicionFinalI = 3;
				int posicionFinalJ = 3;
				
				if (i == 0) {
					posicionInicialI = 1;
				} else if(i == tabla.length-1) {
					posicionFinalI -= 1;
				}
				
				if (j == 0) {
					posicionInicialJ = 1;
				} else if(j == tabla[0].length-1) {
					posicionFinalJ -= 1;
				}
				
				
				boolean[][] minitabla = new boolean[posicionFinalI][posicionFinalJ];
				
				System.out.println("Se ha hecho un cuadro de "+posicionFinalI+" filas y "+posicionFinalJ+" columnas alrededor de la celula:");
				
				for (int ii = posicionInicialI; ii < posicionFinalI; ii++) {
					for (int jj = posicionInicialJ; jj < posicionFinalJ; jj++) {
						if(tabla[ii-1+i][jj-1+j]) {
							System.out.print(" * ");
						} else {
							System.out.print(" · ");
						}
						
						minitabla[ii][jj] = tabla[ii-1+i][jj-1+j];
					}
					System.out.println();
				}
				
				for (int ii = posicionInicialI; ii < posicionFinalI; ii++) {
					for (int jj = posicionInicialJ; jj < posicionFinalJ; jj++) {
						if (minitabla[ii][jj]) {
							contador++;
						}
					}
				}
				
				if (tabla[i][j]) {
					contador --;
					muertos = false;
					System.out.println("Entre en verdadero en la fila "+i+"de la columna "+j+". Se contaron "+contador+" celulas vivas");
					if (contador < 2 || contador > 3) {
						System.out.println("Cambio a celula muerta");
						nuevaTabla[i][j] = false;
					}
				} else {
					System.out.println("Entre en falso en la fila "+i+"de la columna "+j);
					if (contador == 3) {
						nuevaTabla[i][j] = true;
						System.out.println("Cambio a celula viva");
					}	
				}
			}
		}
		

		if (muertos) {
			boolean [][] tablaVacia = new boolean[0][0];
			return tablaVacia;
		} else {
			return nuevaTabla;
		}
	}
}
