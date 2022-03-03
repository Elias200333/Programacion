package bicis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Tarea1bicis{
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		String rutaEntrada = "src/bicis/usos-16.csv";
		String rutaSalida = "src/bicis/datos";
		ficheros(rutaEntrada, rutaSalida, 10);
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método ficheros crea un archivo csv en la ruta de salida recibida, 
	 * transcribiendo los datos de la ruta de entrada tantas lineas como cantidad
	 * reciba.
	 * 
	 * */
	
	private static void ficheros(String rutaEntrada, String rutaSalida, int cantidad) {
		File file = new File(rutaEntrada);														// Localizar fichero
		File fileSalida = new File(rutaSalida, "pruebas-"+cantidad+".csv");						// Creacion de archivo
		try {
			Formatter salida = new Formatter(fileSalida);										// Escritura de fichero
			
			try {
				Scanner f = new Scanner(file);													// Leer fichero
				int contador = 0;
				
				while(f.hasNextLine() && contador < cantidad) {								// Mientras haya lineas que recorrer y el contador no supere la cantidad
					salida.format(f.nextLine()+"\n");										// Transcripción de lineas
					contador++;
				}
				
				salida.flush();																// Escritura de la transcripción
				if (cantidad == 10) {														// Si detecta que se ha realizado con 10 lineas
					ficheros("src/bicis/usos-17.csv", "src/bicis/datos", 2000);				// Activa de nuevo el método cambiando la cantidad
				} else {
					System.out.println("Archivos de prueba creados correctamente");			// Mensaje respuesta final
				}
			} catch (FileNotFoundException errorEnArchivo) {
				errorEnArchivo.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
