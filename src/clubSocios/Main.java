package clubSocios;

import java.util.Scanner;

public class Main {
	
	/**
	 * Pre: ---
	 * Post: el m�todo main crea una liga con el m�todo "creacionLiga()", ofrece un men�
	 * con el m�todo mensaje de bienvenida y ejecuta el m�todo que selecciona el usuario 
	 * y el que pasa por el grupo de if().
	 *  
	 * */

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		Liga clubSocios = creacionLiga(); // Crea una liga con este m�todo.
		
		boolean bucle = true; // Booleana que indica el fin del bucle de inserci�n de opciones.
		
		String eleccion = ""; // Guarda elecci�n del usuario.
		
		while(bucle) { // Ejecuta el bucle hasta que el usuario haya introducido datos validos.
			mensajeBienvenida(); // M�todo que muestra menu de opciones.
			System.out.println();
			eleccion = entrada.next(); // Guarda el dato en la variable creada anteriormente
			bucle = comprobarNumero(eleccion); // Comprueba si el dato introducido es valido.
		}
		
		// En este conjunto de if() comprueba el m�todo a ejecutar.
		
		if (eleccion.equals("1")) {
			clubSocios.visualizarClasificacionPuntos();
		} else if (eleccion.equals("2")) {
			clubSocios.visualizarMaximosGoleadores();
		} else if (eleccion.equals("3")) {
			clubSocios.visualizarMasExpulsiones();
		} else {
			clubSocios.visualizarEquiposMasGoleadores();
		}
		
	}
	
	/**
	 * Pre: ---
	 * Post: Este m�todo muestra un mensaje de bienvenida al usuario, junto con todas las
	 * opciones que puede ejecutar.
	 *  
	 * */
	
	public static void mensajeBienvenida() {
		System.out.println("Hola y bienvenido al CLUB DE SOCIOS.\n\n�Qu� deseas hacer? ESCRIBE UNO DE LOS SIGUIENTES N�MEROS\n");
		System.out.println("1. Visualizar clasificaci�n ordenada por puntos.");
		System.out.println("2. Visualizar los 5 m�ximos goleadores.");
		System.out.println("3. Visualizar los 5 jugadores con m�s expulsiones.");
		System.out.println("4. Obtener los 3 equipos m�s goleadores.\n");
	}
	
	/**
	 * Pre: ---
	 * Post: el m�todo comprobarNumero() comprueba si el dato que recibe es un dato numeri-
	 * co entre el 1 y el 4.
	 *  
	 * */
	
	public static boolean comprobarNumero(String dato) {
		try {
			if (Integer.parseInt(dato) > 0 && Integer.parseInt(dato) < 5) {return false;} // Comprueba si el dato convertido a n�mero se encuentra entre el 1 y el 4 incluidos.
			System.out.println("El numero introducido no est� en el rango establecido\n"); // En caso de no ser un numero entre ese rango, se mostrar� el siguiente print.
			return true;
		} catch(Exception e) {
			System.out.println("El dato introducido no es un n�mero\n");
			return true; // retorna en caso de error en conversi�n.
		}
	}

	/**
	 * Pre: ---
	 * Post: el m�todo random devuelve un n�mero entre el 1 y el n�mero que se encuentre en 
	 * nElegido.
	 *  
	 * */
	
	public static int random() {
		int nElegido = 10000; // Dato donde elegir el n�mero m�ximo
		return (int) Math.floor(Math.random()*nElegido)+1; // Devuelve el n�mero aleatorio
	}
	
	/**
	 * Pre: ---
	 * Post: el m�todo creacionLiga() devuelve un objeto tipo Liga, donde se generan todos 
	 * sus datos.
	 *  
	 * */
	
	public static Liga creacionLiga() {
		Equipo [] agrupacion = new Equipo[15]; // Crea una tabla de 15 Equipos
		
		for (int i = 0; i < agrupacion.length; i++) { // Se va recorriendo cada valor del Equipo
			agrupacion[i] = creacionEquipo(i*11); // En cada valor de equipo se llama al m�todo creacionEquipo, donde se envia el indice de la tabla multiplicada
												 //  por el n�mero de jugadores que tendr�, con el prop�sito de que cada jugador tendr� su propio indice.
		}
		
		Liga liga =  new Liga("Club de socios", agrupacion); // Creaci�n de la Liga con los par�metros requeridos.
		
		return liga;
	}
	
	/**
	 * Pre: ---
	 * Post: el m�todo crearEquipo() devuelve un Equipo conformado por 11 Jugadores.
	 *  
	 * */
	
	public static Equipo creacionEquipo(int indiceJugador) {

		Jugador[] jugadores = new Jugador[11]; // Creaci�n de tabla de Jugadores
		
		for (int i = 0; i < jugadores.length; i++) { // Recorremos la tabla de jugadores
			indiceJugador++; // Aumentamos el indice para iniciar en un valor superior al recibido. Ej. Si llega 0, el indice es 1.
			jugadores[i] = creacionJugador(indiceJugador); // Llamamos al m�todo creaci�nJugador() envi�ndole como par�metro el indice del Jugador que poseer�.
		}
		
		// Creaci�n del equipo con los parametros requeridos, y utilizando los m�todos random() para generar n�meros aleatorios.
		
		Equipo equipo = new Equipo("Equipo "+indiceJugador, "Estadio "+random(), 2000, jugadores, random(), random(), random(), random()); 

		return equipo;
	}

	/**
	 * Pre: ---
	 * Post: el m�todo crearJugador() devuelve un Jugador con los par�metros aleatorios en su mayor�a.
	 *  
	 * */
	
	public static Jugador creacionJugador(int indiceJugador) {
		Jugador jugador = new Jugador("Jugador "+indiceJugador, indiceJugador, 
										random(), random(), random()); // utiliza los m�todos random() para generar n�meros aleatorios.
		return jugador;
	}
}
