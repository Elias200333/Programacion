package JuegoDeLaVida;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("EL JUEGO DE LA VIDA");
		Scanner entrada = new Scanner(System.in);
		
		boolean [][] plantilla = new boolean[0][0]; 											// Plantilla en caso de que el usuario elija una plantilla.
		
		int generaciones = comprobacion("¿De cuantas generaciones deseas disponer? ",1,40); 	// Uso de método comprobación para que devuelva un dato valido
		
		System.out.println("¿Deseas seleccionar alguna plantilla? y/n");
		
		if (entrada.next().contains("y")) { 													// si elige plantilla
			int eleccion = comprobacion("Existen 3 plantillas. ¿Cuál deseas elegir? \n"+plantillasVisual(), 1, 3);
			
			plantilla = plantillas(eleccion);												// creación de plantilla a partir de eleccion
			
			generacion(plantilla.length,plantilla[0].length,generaciones, plantilla); 		// ejecuta el método generacion
			
		} else { 																				// si no elige plantilla
			System.out.println("Introduce el espacio en el que desee visualizar el programa.");
			int m = comprobacion("Filas: ",1,40);
			int n = comprobacion("Columnas: ",1,40); 
			
			generacion(m,n,generaciones, plantilla); 											// ejecuta el método generacion
		}
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método generacion crea una generación en base a los parámetros que recibe, 
	 * y la muestra, además de mostrar su información recopilada al finalizar las mismas.
	 * */
	
	private static void generacion(int m, int n, int generaciones, boolean [][] plantilla) {
		ArrayList<Tripleta> tablaTripletas = new ArrayList<Tripleta>(); 	// Registra los datos
		
		boolean [][] tabla = new boolean[m][n]; 							// Crea tabla a partir de parámetros recibidos
		
		Scanner entrada = new Scanner(System.in);
		
		boolean manual = false; 											// guarda la elección manual para insertar celulas
		
		boolean noPlantilla = true; 										// guarda la elección de elección de plantilla
		
		int celulasNuevas = 0;
		int iterador = 0;
		int celulasVivas = 0;
		
		
		if (plantilla.length == 0) { 										// comprueba si ha llegado una plantilla vacia
			System.out.println("¿Deseas introducirlo manualmente? y/n");
			
			if (entrada.next().contains("y")) { 						// comprueba si el usuario desea introducirlas manualmente
				manual = true;
				System.out.println("Indica las celulas vivas o no indicando con:");
				System.out.println("v: viva\nm: muerta");
			}
		} else { 															// en caso de llegar una plantilla llena
			noPlantilla = false;
			tabla = plantilla;
		}
		
		for (int h = 0; h < generaciones + 1; h++) { 	// inicio generaciones
			iterador = h; 								// guardado de generacion
			int vivas = 0; 								// registra celulas vivas de cada generacion
			if (h == 0) { 								// comprueba si es la primera generacion
				if (noPlantilla) {						// comprueba si no hay plantilla
					for (int i = 0; i < m; i++) { 		// recorre filas
						for(int j = 0; j < n; j++) { 	// recorre celdas
							if (manual) { 				// comprueba si ha elegido manualmente
								if (entrada.next().contains("v")){
									tabla[i][j] = true;
								} else {
									tabla[i][j] = false;
								}
							} else {					// en caso de no elegir manual, se genera aleatoriamente
								int valor = (int) Math.floor(Math.random()*5)+1;
								
								if (valor == 1) {
									tabla[i][j] = true;
								} else {
									tabla[i][j] = false;
								}
							}
						}
					}
				}
			} else {									// Si no es la primera generacion, llama a la siguiente
				tabla = siguienteGeneracion(tabla);
				if (tabla.length == 0) { 				// si detecta una tabla vacia, significa sin supervivientes
					System.out.println("COLONIA EXTINGUIDA");
					break;
				}
			}
			System.out.println("Generacion "+h);	
			for (int i = 0; i < m; i++) {				// recorre filas
				for (int j = 0; j < n; j++) {			// recorre celdas
					if (tabla[i][j]) {					// si detecta una celula
						vivas++;
						System.out.print(" * ");
					} else {							// si no la detecta
						System.out.print("   ");
					}
				}
				System.out.println();
			}
			if (h == 0) { 								// si es la primera generacion, pone valor por defecto
				celulasNuevas = vivas;
			} else {									// si no es la primera, obtiene el dato de la generación anterior y lo resta con el actual
				celulasNuevas = vivas-tablaTripletas.get(h-1).getCelulasVivas();
			}
			
			celulasVivas = vivas;
			
			Tripleta actual = new Tripleta(iterador, celulasVivas, celulasNuevas);
			tablaTripletas.add(actual);
			
			System.out.println("_____________________________________________________________________");
		}
		
		System.out.println("Sobrevivientes: "+celulasVivas); 						// informacion supervivientes
		
		System.out.println("_____________________________________________________________________");
		System.out.println("INFORMACIÓN GENERACIONES:\n");
		
		for(int i = 0; i < tablaTripletas.size(); i++) {							// muestra por pantalla la informacion de cada generacion
			System.out.println("GENERACIÓN "+tablaTripletas.get(i).getIteracion()+
					" | Celulas vivas: "+tablaTripletas.get(i).getCelulasVivas()+
					" | Celulas nuevas respecto a la anterior: "+tablaTripletas.get(i).getCelulasNuevas());
		}
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: el método siguienteGeneracion genera el algoritmo de comprobación 
	 * de condiciones para dar como resultado una nueva generación y devuelve esta misma.
	 * */
	
	private static boolean[][] siguienteGeneracion(boolean[][] tabla){
		boolean[][] nuevaTabla = new boolean[tabla.length][tabla[0].length]; 	// nueva generacion
		
		boolean vivos = false; 													// booleana que indica extincion de la colonia	
		
		for (int i = 0; i < tabla.length; i++) {								// recorre filas
			for (int j = 0; j < tabla[i].length; j++) {							// recorre celdas
				int contador = 0;												// contador de celulas vivas
				
				/*Posiciones iniciales para cuadricula 3x3*/
				
				int posicionInicialI = 0;										
				int posicionInicialJ = 0;
				int posicionFinalI = 3;
				int posicionFinalJ = 3;
				
				if (i == 0) { 						// comprueba si esta al principio de las filas
					posicionInicialI = 1;
				} else if(i == tabla.length-1) {	// comprueba si esta al final de las filas
					posicionFinalI -= 1;
				}
				
				if (j == 0) { 						// comprueba si esta al principio de una celda
					posicionInicialJ = 1;
				} else if(j == tabla[0].length-1) {	// comprueba si esta al final de una celda
					posicionFinalJ -= 1;
				}
				
				if (tabla.length < 3) {				// comprueba si la longitud de las filas es menor al tamaño de cuadricula
					posicionInicialI = 1;
					posicionFinalI = tabla.length;
				}
				if (tabla[0].length < 3) {			// comprueva si la longitud de las celdas es menor al tamaño de cuadricula
					posicionInicialJ = 1;
					posicionFinalJ = tabla[0].length;
				}
				
				boolean[][] minitabla = new boolean[posicionFinalI][posicionFinalJ];	// Creacion cuadricula
				
				/*Segun su posicion, la comprobación de alrededores puede variar*/
				
				for (int ii = posicionInicialI; ii < posicionFinalI; ii++) {			// Recorre filas
					for (int jj = posicionInicialJ; jj < posicionFinalJ; jj++) {		// Recorre celdas
						minitabla[ii][jj] = tabla[ii-1+i][jj-1+j];						// rellena la cuadricula
						if (minitabla[ii][jj]) {										// comprueba si es una celula viva
							contador++;
						}
					}
				}
				
				if (tabla[i][j]) { 								// Comprueba si es una celula
					contador --;							// Descuenta a la misma celula
					vivos = true;							// No es colonia extinguida
					if (contador < 2 || contador > 3) {		// Comprueba si cumple condicion
						nuevaTabla[i][j] = false;
					} else {								// Si no se cumple
						nuevaTabla[i][j] = true;
					}
				} else {										// Si no es una celula
					if (contador == 3) {					// Comprueba si cumple condicion
						nuevaTabla[i][j] = true;
					} else {								// Si no se cumple
						nuevaTabla[i][j] = false;
					}	
				}
			}
		}

		if (vivos) {										// Comprueba si es una colonia viva
			return nuevaTabla;
		} else {											// Si no se cumple, es una colonia extinta
			boolean [][] tablaVacia = new boolean[0][0];
			return tablaVacia;
		}
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método comprobacion devuelve un dato proveniente de unos parametros que indican 
	 * la validación de un dato, así como su continua peticion hasta que los datos cumplan con lo indicado.
	 * 
	 * */

	private static int comprobacion(String solicitud, int minimo, int maximo) {
		Scanner entrada = new Scanner(System.in);
		int dato = 0;
		
		while (true) {
			System.out.print(solicitud);						// Solicita al usuario un mensaje recibido del parametro solicitud
			try {												// Intenta adaptar el dato según los parametros recibidos
				dato = Integer.parseInt(entrada.next());
				if (dato >= minimo && dato <= maximo) {		// Comprueba si esta en el rango
					return dato;						// Retorna el dato si cumple con los parametros recibidos
				} else {									// Si no lo esta, comunica dato invalido
					System.out.println("DATO INVALIDO");
				}
			}catch(Exception e) {								// Si da error al adaptar el dato, comunica dato invalido
				System.out.println("DATO INVALIDO");
			}
		}
	}
	
	/**
	 * Pre: ---
	 * 
	 * Post: El método plantillas devuelve unas plantillas predefinidas de colonias de celulas segun el parametro recibido.
	 * */
	
	private static boolean[][] plantillas(int eleccion){
		if (eleccion == 1) {								// Comprueba si es la eleccion
			boolean [][] plantilla = {
				{false, false, false, false},
				{false, true, true, false},
				{false, true, true, false},
				{false, false, false, false},
			};
			return plantilla;
		} else if (eleccion == 2){							// Si no lo es, comprueba si es esta
			boolean [][] plantilla = {
				{false, false, false, false, false},
				{false, false, false, false, false},
				{false, true, true, true, false},
				{false, false, false, false, false},
				{false, false, false, false, false},
			};
			return plantilla;
		} else {											// Si no lo es, devuelve esta plantilla
			boolean [][] plantilla = {
				{false, false, false, false, false, false},
				{false, true, true, false, false, false},
				{false, true, true, false, false, false},
				{false, false, false, true, true, false},
				{false, false, false, true, true, false},
				{false, false, false, false, false, false},
			};
			return plantilla;
		}
	}

	/**
	 * Pre: ---
	 * 
	 * Post: El método plantillasVisual devuelve un String mostrando 
	 * visualmente las plantillas existentes en el método plantillas.
	 * 
	 * */
	
	private static String plantillasVisual() {
		String caja = 
				"     1              2                 3        \n"+
				" ·  ·  ·  · | ·  ·  ·  ·  · | ·  ·  ·  ·  ·  · \n"+
				" ·  *  *  · | ·  ·  ·  ·  · | ·  *  *  ·  ·  · \n"+
				" ·  *  *  · | ·  *  *  *  · | ·  *  *  ·  ·  · \n"+
				" ·  ·  ·  · | ·  ·  ·  ·  · | ·  ·  ·  *  *  · \n"+
				"              ·  ·  ·  ·  · | ·  ·  ·  *  *  · \n"+
				"                            | ·  ·  ·  ·  ·  · \n";
		return caja;
	}
}