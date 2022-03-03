package Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prueba2 {
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Introduce la ruta del archivo + nombre:");
		String ruta = entrada.nextLine();
		System.out.print("Introduce la ruta del archivo + nombre:");
		String palabra = entrada.next();
		lecturaDatos(ruta, palabra);
	}
	
	private static void lecturaDatos(String nombre, String palabra) {
		File file = new File(nombre);
		try {
			/*
			 * Se crea un objeto [Formatter] al que se asocia un fichero deno-
			 * minado [file].
			 */
			Scanner f = new Scanner(file);
			/*
			 * Recorremos el fichero linea por linea.
			 */
			
			int contador = 0;
			
			while(f.hasNextLine()) {				
				String lineaLeida = f.nextLine();
				
				System.out.println(lineaLeida);
				
				lineaLeida = lineaLeida.replaceAll(",","").replaceAll("\\.","");
				
				String[] linea = lineaLeida.split(" ");
				
				for (int i = 0; i < linea.length;i++) {
					 if(linea[i].equalsIgnoreCase(palabra)) {
						 contador++;
					 };
				}
				
			}
			
			System.out.println(contador);
			/*
			 * Se libera el fichero que estamos leyendo. 
			 */
			f.close();
		} catch (FileNotFoundException errorEnArchivo) {
			errorEnArchivo.printStackTrace();
		} 
	}
}
