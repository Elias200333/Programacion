package tarea10;



import java.util.Scanner;

public class Ejercicio05{
	public static void main(String[] args) {
		String [] prueba = {
			"Antonia",
			"Zapato",
			"Que", 
			"Tal",
			"Pepe", 
		};
		
		for (int i=0; i< prueba.length; i++) { // leer tabla entera
			for (int j = 0; j < prueba.length;j++) { // leer tabla entera comparando desde cada celda
				if(prueba[i].compareTo(prueba[j]) > 0){ // Comprueba si su posición es inferior.
					
					String caja = prueba[i]; // caja temporal donde guardo temporalmente el dato
					prueba[i] = prueba[j]; // renombro el original con el coincidente con el compare to
					prueba[j] = caja; // renombro el valor compare to con el valor de caja
				}
			}
		}
		
		for (int i = 0; i < prueba.length; i++){
			System.out.println(prueba[i]); 
		}
	}
}
