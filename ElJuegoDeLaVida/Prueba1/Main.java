package Prueba1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("EL JUEGO DE LA VIDA");
		Scanner entrada = new Scanner(System.in);
		
		int m = 10;
		int n = 10;
		int generaciones = 3;
		
		boolean [][] tabla = new boolean[m][n]; 
		
		for (int h = 0; h < generaciones; h++) {
			for (int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					
					if (h == 0) {
						int valor = (int) Math.floor(Math.random()*5)+1;
						
						if (valor == 1) {
							tabla[i][j] = true;
						} else {
							tabla[i][j] = false;
						}
					}
					
					if (tabla[i][j]) {
						System.out.print(" * ");
					} else {
						System.out.print(" · ");
					}
				}
				System.out.println();
			}
			System.out.println("______________________________________");
			tabla = siguienteGeneracion(tabla);
		}
	}
	
	public static boolean[][] siguienteGeneracion(boolean[][] tabla){
		for (int i = 1; i < tabla.length-1; i++) {
			for (int j = 1; j < tabla[i].length-1; j++) {
				int contador = 0;
				
				boolean[][] minitabla = new boolean[3][3];
				
				for (int ii = 0; ii < minitabla.length; ii++) {
					for (int jj = 0; jj < minitabla[ii].length; jj++) {
						minitabla[ii][jj] = tabla[ii-1+i][jj-1+j];
					}
				}
				
				for (int ii = 0; ii < minitabla.length; ii++) {
					for (int jj = 0; jj < minitabla[ii].length; jj++) {
						if (ii != 1 && jj != 1) {
							if (minitabla[ii][jj]) {
								contador++;
							}
						}
					}
				}
				if (tabla[i][j]) {
					if (contador < 2 || contador > 3) {
						tabla[i][j] = false;
					}
				} else {
					if (contador == 3) {
						tabla[i][j] = true;
					}	
				}
			}
		}
		
		return tabla;
	}
}
