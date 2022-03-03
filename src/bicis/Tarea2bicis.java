package bicis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Tarea2bicis{
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ruta donde se encuentra: src/bicis/datos");
		System.out.println("Escriba el nombre de un fichero del sistema Bizi: ");
		ficheros(entrada.nextLine());
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método ficheros recorre un archivo csv del sistema Bizi que contabiliza
	 * y muestra por pantalla la cantidad de traslados y de uso circular de las bicis,
	 * así como el total del conjunto.*/
	
	private static void ficheros(String ruta) {
		File file = new File(ruta);														// Localizar fichero
		boolean primeraLinea = true;													// Primera linea
		
		try {
			Scanner f = new Scanner(file);												// Leer fichero
			int contadorTotal = 0;
			int contadorCircular = 0;
			int contadorTraslado = 0;
			
			while(f.hasNextLine()) {													// Mientras haya lineas que recorrer
				if (primeraLinea) {														// Si es la primera linea
					String nulo = f.nextLine();											// Salta de linea
					primeraLinea = false;												// Ya no es la primera linea
				} else {
					String linea = f.nextLine();										// Extrae la linea
					String[] lineaSeparada = linea.split(";");							// La divide por ';'
					String retiroEstacion = "";											// Guardado de comprobación
					
					for (int i = 0; i < lineaSeparada.length; i++) {					// Recorre los campos
						if(i == 2) {													// Si es el campo de RetiroEstacion
							retiroEstacion = lineaSeparada[i];							// Lo guarda para futura comprobación
							
						}else if (i == 4) {												// Si es el campo AnclajeEstacion
							if (lineaSeparada[i].equals(retiroEstacion)) {				// Comprueba si ha habido un uso circular
								contadorCircular++;
							}
						}
					}
					contadorTotal++;
				}
			}
			
			contadorTraslado = contadorTotal-contadorCircular;							// Calcula el traslado con la diferenci
			
			System.out.println("Numero de usos como traslado: "+contadorTraslado);
			System.out.println("Numero de usos circulares: "+contadorCircular);
			System.out.println("Numero total de usos: "+ contadorTotal);
		} catch (FileNotFoundException errorEnArchivo) {
			errorEnArchivo.printStackTrace();
		}
	}
}
