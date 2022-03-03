package Titanic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce la ruta del archivo a analizar.");
		String ruta = entrada.nextLine();
		lecturaFicheroTitanic(ruta);
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método lecutaFicheroTitanic lee el archivo que recibe como parametro y muestra 
	 * el nº total de pasajeros, nº mujeres y hombres, así como el total de fallecidos por 
	 * género y su porcentaje.
	 * 
	 * */
	
	private static void lecturaFicheroTitanic(String ruta) {
		File file = new File(ruta);														// Localizar fichero
		
		try {
			Scanner f = new Scanner(file);													// Leer fichero
			
			/*
			  Variables para tener en constancia 
			     la información a recopilar
			*/
			
			int totalPasajeros = 0;
			int nHombres = 0;
			int nMujeres = 0;
			int nHombresFallecidos = 0;
			int nMujeresFallecidas = 0;
			boolean primeraLinea = true;
			
			while(f.hasNextLine()) {														// Mientras haya lineas que recorrer				
				boolean muerto = false;
				if (primeraLinea) {																// Si detecta que es la primera linea, se la salta
					primeraLinea = false;
				} else {
					String lineaLeida = f.nextLine();											// Recepciona la linea
					String[] linea = lineaLeida.split(",");										// La divide por comas
					for(int i = 0; i < linea.length; i++) {										// Recorre los datos de la linea
						if (i == 1) {															// Si detecta que es el parametro de supervivientes
							if (linea[i].equals("0")) {											// Si no es superviviente 
								muerto = true;
								
								/* Aumenta el contador tanto *
								 * a hombres como de mujeres */
								
								nMujeresFallecidas++;
								nHombresFallecidos++;
							}
						} else if (i == 5) {													// Si detecta que es el parametro de género
							if (linea[i].contains("female")) {									// Si el género es mujer
								nMujeres++;
								if (muerto) {													// Si detecta que ha fallecido, hace ver que una mujer fallecio
									nHombresFallecidos--;										// Por ello, resta el nº de fallecidos los hombres
								}
							} else {
								nHombres++;
								if (muerto) {													// Si detecta que ha fallecido, hace ver que un hobre fallecio
									nMujeresFallecidas--;										// Por ello, resta el nº de fallecidos las mujeres
								}
							}
						}
					}
					
					totalPasajeros++;														// Cada vuelta del bucle equivale a un pasajero
				}
			}
			
			/* Calcula el porcentaje de mujeres y hombres fallecidos en porcentaje */
			
			double porcentajeMujeresFallecidas = nMujeresFallecidas * 100 /nMujeres;
			double porcentajeHombresFallecidos = nHombresFallecidos * 100 /nHombres;
			
			/* Muestra la información */
			
			System.out.println("\nInformación del titanic");
			System.out.println("________________________\n");
			System.out.println("Numero total de pasajeros: "+totalPasajeros);
			System.out.println("Numero total de mujeres: "+nMujeres);
			System.out.println("Numero total de hombres: "+nHombres);
			System.out.println("Total de hombres fallecidos: "+nHombresFallecidos+", "+porcentajeHombresFallecidos+"%");
			System.out.println("Total de mujeres fallecidos: "+nMujeresFallecidas+", "+porcentajeMujeresFallecidas+"%");
			
			f.close();
		} catch (FileNotFoundException errorEnArchivo) {
			errorEnArchivo.printStackTrace();
		} 
	}
}
