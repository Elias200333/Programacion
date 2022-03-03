package Prueba.copy;

import java.io.File;
import java.util.Scanner;

/**
 * Esta clase presenta un programa de prueba que ilustra cómo trabjar con ficheros haciendo
 * uso de los recursos que ofrece la clase java.io.File
 * 
 * @Author: Álvaro Juan Ciriaco
 */

public class Menu {
	
	/**
	 * Pre: ---
	 * Post: Si existe un fichero cuyo nombre es igual al asociado al objeto [f], entonces
	 * 		 informa por pantalla de los atributos y principales características del fichero.
	 * 		 En caso contrario no produce ningún resultado.
	 */
	public static void mostrarInformacion(File f) {
		if(f.isFile()) {
			System.out.println();
			System.out.println(" ---------------------");
			System.out.println("| INFORMACIÓN DE FILE |");
			System.out.println(" ---------------------");
			System.out.println("| Nombre del fichero:                             " + f.getName());
			System.out.println("| Ruta relativa del directorio del fichero:       " + f.getParent());
			System.out.println("| Nombre del fichero (ruta relativa):             " + f.getPath());
			System.out.println("| Nombre del fichero (ruta absoluta):             " + f.getAbsolutePath());
			System.out.println("| Tamaño del fichero (en bytes):                  " + f.length());
			System.out.println("| Puede ser leído:                                " + f.canRead());
			System.out.println("| Puede ser escrito:                              " + f.canWrite());
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Muestra por pantalla el menu de la aplicación.
	 */
	public static void mostrarMenu() {
		System.out.println("Selecciona una opción: ");
		System.out.println("  1) Crear File usando ruta");
		System.out.println("  2) Crear File usando ruta + nombre");
		System.out.print("Opción seleccionada (0 para finalizar): ");
	}
	
	/**
	 * Pre: ---
	 * Post: Presenta información por pantalla del fichero [nombre] ubicado en [ruta], le cambia
	 * 		 su nombre y, finalmente, lo elimina.
	 */
	public static void main(String[] args) {
		/*
		 * Crea objeto de clase [Scanner] y presenta por pantalla el menu de la aplicación.
		 */
		Scanner entrada = new Scanner(System.in);
		mostrarMenu();
		int opcion = entrada.nextInt();
		
		while(opcion != 0) {
			/*
			 * Si el usuario selecciona la opción 1 el objeto [File] se crea llamando
			 * a su constructor public File(String ruta_y_nombre), si selecciona la opción
			 * 2 el objeto [File] se crea llamando al constructor public File(String ruta, nombre).
			 */
			File f;
			
			if(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
				if(opcion == 1) {
					System.out.print("Escriba la ruta para File: ");
					String rutaFinal = entrada.next();
					f = new File(rutaFinal);
				} else if(opcion == 2){
					System.out.print("Escriba la ruta para File (sin nombre): ");
					String ruta = entrada.next();
					System.out.print("Escriba el nombre para File: ");
					String nombre = entrada.next();
					f = new File(ruta, nombre);
				} else if(opcion == 3){
					System.out.print("Escriba la ruta para File (con nombre): ");
					String ruta = entrada.next();
					System.out.print("Escriba el nuevo nombre para File: ");
					String nombre = entrada.next();
					f = new File(ruta);
					File f2 = new File(nombre);
					
				} else {
					System.out.print("Escriba la ruta para File (sin nombre): ");
					String ruta = entrada.next();
					System.out.print("Escriba el nombre para File: ");
					String nombre = entrada.next();
					f = new File(ruta, nombre);
				}
				/*
				 * Muestra información relevante del fichero
				 */
				mostrarInformacion(f);
			} else {
				System.out.println("¡Opción incorrecta. Indique un número válido!");
			}
			/*
			 * Separación estética para la aplicación.
			 */
			System.out.println();
			System.out.println("==================================================");
			System.out.println();
			/*
			 * Presenta por pantalla el menu y pregunta al usuario por una nueva opción.
			 * Esto se repite hasta que el usuario selecciona la opción 0 (finalizar).
			 */
			mostrarMenu();
			opcion = entrada.nextInt();
		}
	}
}
