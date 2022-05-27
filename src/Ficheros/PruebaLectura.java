package Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaLectura {

	
	/**
	 * Pre: [nombre] almacena la ruta + nombre del fichero a leer
	 * Post: lee el fichero cuyo path coincide con [nombre] y muestra por 
	 * 		pantalla el nombre de cada uno de los alumnos seguido de la
	 * 		media de sus 3 examenes.
	 */
	private static void calcularMedias(String nombre) {
		/*
		 * Creo el objeto [file] de tipo File para poder crear el objeto
		 * de tipo Scanner para leer el fichero.
		 */
		
		
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
			
			boolean primeraLinea = true;
			
			String [] nombreDatos;
			
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				
				String[] lineaSeparada = linea.split(";");
				
				if (primeraLinea) {
					nombreDatos = lineaSeparada;
					primeraLinea = false;
					for (int i = 0; i < lineaSeparada.length; i++) {
						System.out.print(lineaSeparada[i]+"-");
					}
				} 
			}
			/*
			 * Se libera el fichero que estamos leyendo. 
			 */
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		} 
	}
	
	/**
	 * Pre: ---
	 * Post: Ejecuta el programa Java que solicita al usuario el (path + nombre) de un fichero
	 * 		que ya existe en el sistema. Muestra por pantalla el n�mero de l�neas y el n�mero
	 * 		de caracteres de este.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/*
		 * Solicita al usuario el fichero mostrar la informaci�n
		 * de este por pantalla
		 */
		System.out.print("Dame la ruta + nombre del fichero ");
		String nombreFichero = entrada.nextLine();
		calcularMedias(nombreFichero);
	}
}
