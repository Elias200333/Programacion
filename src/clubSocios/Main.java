package clubSocios;

import java.util.Scanner;

public class Main {
	
	/**
	 * Pre: ---
	 * Post: el método main crea una liga con el método "creacionLiga()", ofrece un menú
	 * con el método mensaje de bienvenida y ejecuta el método que selecciona el usuario 
	 * y el que pasa por el grupo de if().
	 *  
	 * */

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		Liga clubSocios = creacionLiga(); // Crea una liga con este método.
		
		boolean bucle = true; // Booleana que indica el fin del bucle de inserción de opciones.
		
		String eleccion = ""; // Guarda elección del usuario.
		
		while(bucle) { // Ejecuta el bucle hasta que el usuario haya introducido datos validos.
			mensajeBienvenida(); // Método que muestra menu de opciones.
			System.out.println();
			eleccion = entrada.next(); // Guarda el dato en la variable creada anteriormente
			bucle = comprobarNumero(eleccion); // Comprueba si el dato introducido es valido.
		}
		
		// En este conjunto de if() comprueba el método a ejecutar.
		
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
	 * Post: Este método muestra un mensaje de bienvenida al usuario, junto con todas las
	 * opciones que puede ejecutar.
	 *  
	 * */
	
	public static void mensajeBienvenida() {
		System.out.println("Hola y bienvenido al CLUB DE SOCIOS.\n\n¿Qué deseas hacer? ESCRIBE UNO DE LOS SIGUIENTES NÚMEROS\n");
		System.out.println("1. Visualizar clasificación ordenada por puntos.");
		System.out.println("2. Visualizar los 5 máximos goleadores.");
		System.out.println("3. Visualizar los 5 jugadores con más expulsiones.");
		System.out.println("4. Obtener los 3 equipos más goleadores.\n");
	}
	
	/**
	 * Pre: ---
	 * Post: el método comprobarNumero() comprueba si el dato que recibe es un dato numeri-
	 * co entre el 1 y el 4.
	 *  
	 * */
	
	public static boolean comprobarNumero(String dato) {
		try {
			if (Integer.parseInt(dato) > 0 && Integer.parseInt(dato) < 5) {return false;} // Comprueba si el dato convertido a número se encuentra entre el 1 y el 4 incluidos.
			System.out.println("El numero introducido no está en el rango establecido\n"); // En caso de no ser un numero entre ese rango, se mostrará el siguiente print.
			return true;
		} catch(Exception e) {
			System.out.println("El dato introducido no es un número\n");
			return true; // retorna en caso de error en conversión.
		}
	}

	/**
	 * Pre: ---
	 * Post: el método random devuelve un número entre el 1 y el número que se encuentre en 
	 * nElegido.
	 *  
	 * */
	
	public static int random() {
		int nElegido = 10000; // Dato donde elegir el número máximo
		return (int) Math.floor(Math.random()*nElegido)+1; // Devuelve el número aleatorio
	}
	
	/**
	 * Pre: ---
	 * Post: el método creacionLiga() devuelve un objeto tipo Liga, donde se generan todos 
	 * sus datos.
	 *  
	 * */
	
	public static Liga creacionLiga() {
		Equipo [] agrupacion = new Equipo[15]; // Crea una tabla de 15 Equipos
		
		for (int i = 0; i < agrupacion.length; i++) { // Se va recorriendo cada valor del Equipo
			agrupacion[i] = creacionEquipo(i*11); // En cada valor de equipo se llama al método creacionEquipo, donde se envia el indice de la tabla multiplicada
												 //  por el número de jugadores que tendrá, con el propósito de que cada jugador tendrá su propio indice.
		}
		
		Liga liga =  new Liga("Club de socios", agrupacion); // Creación de la Liga con los parámetros requeridos.
		
		return liga;
	}
	
	/**
	 * Pre: ---
	 * Post: el método crearEquipo() devuelve un Equipo conformado por 11 Jugadores.
	 *  
	 * */
	
	public static Equipo creacionEquipo(int indiceJugador) {

		Jugador[] jugadores = new Jugador[11]; // Creación de tabla de Jugadores
		
		for (int i = 0; i < jugadores.length; i++) { // Recorremos la tabla de jugadores
			indiceJugador++; // Aumentamos el indice para iniciar en un valor superior al recibido. Ej. Si llega 0, el indice es 1.
			jugadores[i] = creacionJugador(indiceJugador); // Llamamos al método creaciónJugador() enviándole como parámetro el indice del Jugador que poseerá.
		}
		
		// Creación del equipo con los parametros requeridos, y utilizando los métodos random() para generar números aleatorios.
		
		Equipo equipo = new Equipo("Equipo "+indiceJugador, "Estadio "+random(), 2000, jugadores, random(), random(), random(), random()); 

		return equipo;
	}

	/**
	 * Pre: ---
	 * Post: el método crearJugador() devuelve un Jugador con los parámetros aleatorios en su mayoría.
	 *  
	 * */
	
	public static Jugador creacionJugador(int indiceJugador) {
		Jugador jugador = new Jugador("Jugador "+indiceJugador, indiceJugador, 
										random(), random(), random()); // utiliza los métodos random() para generar números aleatorios.
		return jugador;
	}
}
