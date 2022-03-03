package bicis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarea3bicis{
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ruta donde se encuentra: src/bicis/datos");
		System.out.print("Escriba el nombre de un fichero del sistema Bizi: ");
		String ruta = entrada.nextLine();
		System.out.print("\nNumero usuarios distintos: ");
		int distintos = entrada.nextInt();
		ficheros(ruta, distintos);
	}
	
	/**
	 * Pre:---
	 * 
	 * Post: El método ficheros realiza la lectura de un archivo csv, con la intención de recopilar los 
	 * datos necesarios indicados en el ejercicio y mostrarlos por pantalla.
	 * 
	 * */
	
	private static void ficheros(String ruta, int distintos) {
		File file = new File(ruta);														// Localizar fichero
		boolean primeraLinea = true;													// Afirma si se encuentra en la primera linea
		ArrayList<UsuarioBici> tablaUsuario = new ArrayList<UsuarioBici>();				// Usuarios
		
		try {
			Scanner f = new Scanner(file);													// Leer fichero
			
			int contador = 0;
			while(f.hasNextLine()) {														// Mientras haya lineas que recorrer
				if (primeraLinea) {															// Si es la primera linea
					String nulo = f.nextLine();
					primeraLinea = false;
				} else if (contador >= distintos) {											// Si no lo es, comprueba si superó la contidad de distintos
					break;
				} else {
					String linea = f.nextLine();											// Lectura linea
					String[] lineaSeparada = linea.split(";");								// Separación atributos
					String retiroEstacion = "";												// Guardado de comprobacion
					int posicion = 0;														// Guardado del index
					
					for (int i = 0; i < lineaSeparada.length; i++) {							// Recorre los atributos
						if(i == 0) {															// Si detecta que es el campo IDUsuario
							
							posicion = existeUsuario(tablaUsuario, lineaSeparada[i]);				// Devuelve el index en el que se encuentra si existe
							
							if (posicion < 0) {														// Comprueba si no existe el usuario
								contador++;															// Cuenta como usuario distinto
								
								UsuarioBici persona = new UsuarioBici(lineaSeparada[i]);			// Crea un UsuarioBici donde manda como único parametro la id
								posicion = tablaUsuario.size();										// Coge el tamaño de la tabla, ya que será su próxima posición.
								tablaUsuario.add(persona);											// Añade el usuario a la tabla
								
							}
						}else if (i == 2) {														// Si detecta que es el campo de RetiroEstacion
							retiroEstacion = lineaSeparada[i];									// Lo guarda en variable de próxima comprobación
							
						}else if (i == 4) {														// Si detecta que es el campo de AnclajeEstacion
							if (lineaSeparada[i].equals(retiroEstacion)) {						// Si detecta que ha habido un uso circular
								
								int anteriorCircular = tablaUsuario.get(posicion).getCircular();	// Toma el campo anterior de usos circulares del usuario
								anteriorCircular++;													// Lo incrementa
								tablaUsuario.get(posicion).setCircular(anteriorCircular);			// Lo establece como nuevo campo
								
							} else {															// Si no lo detecta, es que ha sido un traslado
								
								int anteriorTraslados = tablaUsuario.get(posicion).getTraslados();	// Toma el campo anterior de traslados del usuario
								anteriorTraslados++;												// Lo incrementa
								tablaUsuario.get(posicion).setTraslados(anteriorTraslados);			// Lo establece como nuevo campo
							}
							int anteriorTotal = tablaUsuario.get(posicion).getTotal();			// Ahora, incrementa el total de usos, por lo que toma su campo anterior
							anteriorTotal++;													// Lo incrementa
							tablaUsuario.get(posicion).setTotal(anteriorTotal);					// Lo establece como nuevo campo
						}
					}
				}
			}
			
		} catch (FileNotFoundException errorEnArchivo) {
			errorEnArchivo.printStackTrace();
		}
		
		tablaUsuario = ordenar(tablaUsuario);											// Ordena la tabla de usuarios
		System.out.println("IDUsuario|Circulares|Traslado|Total");
		for(int i = 0; i < 15; i++) {									// Recorre la tabla mostrando los datos por pantalla
			System.out.println(tablaUsuario.get(i).getUsuario()+
			"          "+tablaUsuario.get(i).getCircular()+
			"          "+tablaUsuario.get(i).getTraslados()+
			"      "+tablaUsuario.get(i).getTotal());
		}
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método existeUsuario recorre una tabla de tipo UsuarioBici comprobando si existe el usuario
	 * adjuntado por parametro.
	 * 
	 * */
	
	private static int existeUsuario(ArrayList<UsuarioBici> tabla, String usuario) {
		for(int i = 0; i < tabla.size(); i++) {										// Recorre la tabla
			if(tabla.get(i).getUsuario().equals(usuario)) {							// Comprueba si el parametro coincide con el usuario
				return i;															// Retorna su indice en caso de coincidir
			}
		}
		return -1;																	// Retorna -1 en caso de no encontrarlo
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método ordenar consiste en devolver una tabla de tipo UsuarioBici ordenada según la cantidad total 
	 * de usos 
	 * 
	 * */
	
	private static ArrayList<UsuarioBici> ordenar(ArrayList<UsuarioBici> tabla){
		for(int i = 0; i < tabla.size(); i++) { 									// Recorre la tabla
			for(int j = 0; j < tabla.size(); j++) {									// Recorre la tabla a partir del dato de la tabla
				if (tabla.get(i).getTotal() > tabla.get(j).getTotal()) {			// Comprueba si el dato es superior al subdato
					/*Con este concepto, intercambian de posiciones*/
					
					UsuarioBici caja = tabla.get(i);
					tabla.set(i, tabla.get(j));
					tabla.set(j, caja);
				}
			}
		}
		return tabla; 																// Devuelve la tabla ordenada
	}
}
