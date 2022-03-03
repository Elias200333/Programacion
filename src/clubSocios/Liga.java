package clubSocios;

public class Liga {
	private String nombre;
	private Equipo[] clasificacion;
 
	public Liga(String nombre, Equipo[] clasificacion) {
		this.setNombre(nombre);
		this.setClasificacion(clasificacion);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo[] getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Equipo[] clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	/**
	 * Pre: ---
	 * Post: el método visualizarClasificacionPuntos() muestra por pantalla el nombre, puntos, partidos ganados, 
	 * perdidos, empatados y goles a favor de cada uno de los equipos, ordenados de mayor a menor según su pun-
	 * tuación.
	 *  
	 * */
	
	public void visualizarClasificacionPuntos() {
		Equipo [] ordenacion = clasificacion; // Crea una tabla de Equipos a partir de los actuales que está destinada a su ordenación.
		
		for (int i = 0; i < ordenacion.length; i++) { // Recorre la tabla de "ordenacion".
			for (int j = 0; j < ordenacion.length; j++) { // Recorre la tabla de "ordenacion" en base al recorrido del for() anterior.
				
				// Esta lógica organiza los datos del equipo de mayor a menor.
				
				if (ordenacion[i].getPuntos() > ordenacion[j].getPuntos()) { // Comprueba si los puntos del equipo son mayores a los del resto, según la posicion del 1º for(), es decir, la "i".
					Equipo caja = ordenacion[i]; // En caso de serlo, guarda el Equipo "i" en una caja para conservar temporalmente los datos.
					ordenacion[i] = ordenacion[j]; // Se sobreescribe el primer dato del Equipo "i" con el dato coincidente del Equipo "j".
					ordenacion[j] = caja; // Se sobreescribe el dato coincidente del Equipo "j" con el dato guardado en la caja.
				}
			}
		}
		
		// En este punto, la tabla "ordenacion" ya está ordenada. Así que ya se podrá mostrar por pantalla.
		
		for (int i = 0; i < ordenacion.length; i++) { // Recorre la tabla "ordenacion".
			System.out.println(ordenacion[i].getNombre()+"\n");
			System.out.println("Puntos: "+ordenacion[i].getPuntos());
			System.out.println("Partidos ganados: "+ordenacion[i].getGanados());
			System.out.println("Partidos perdidos: "+ordenacion[i].getPerdidos());
			System.out.println("Partidos empatados: "+ordenacion[i].getEmpatados());
			System.out.println("Goles a favor: "+ordenacion[i].obtenerTotalGoles()+"\n");
		}
		
	}

	/**
	 * Pre: ---
	 * Post: el método visualizarMaximosGoleadores() muestra por pantalla el nombre de los jugadores y sus goles, 
	 * ordenados de mayor a menor por sus goles.
	 *  
	 * */
	
	public void visualizarMaximosGoleadores() {
		Jugador [] top = new Jugador [clasificacion.length]; // Crea una tabla de Jugadores donde se irá colocando el mejor goleador de cada equipo.
		
		for (int i = 0; i < clasificacion.length; i++) { // Recorre la tabla de "clasificacion".
			
			Jugador [] jugadores = clasificacion[i].getJugadores(); // Se guardará los jugadores de un equipo de manera externa.
			
			for (int j = 0; j < jugadores.length; j++) { // Recorre la tabla de "jugadores".
				for (int k = 0; k < jugadores.length; k++) { // Recorre la tabla de "jugadores" en base al recorrido del for() anterior.
					
					// Esta lógica organiza los datos del jugador de mayor a menor.
					
					if (jugadores[j].getGoles() > jugadores[k].getGoles()) { // Comprueba si los goles del jugador son mayores a los del resto, según la posicion del 1º for(), es decir, la "i".
						Jugador caja = jugadores[j]; // En caso de serlo, guarda el Jugador "i" en una caja para conservar temporalmente los datos.
						jugadores[j] = jugadores[k]; // Se sobreescribe el primer dato del Jugador "i" con el dato coincidente del Jugador "j".
						jugadores[k] = caja; // Se sobreescribe el dato coincidente del Equipo "j" con el dato guardado en la caja.
					}
				}
			}
			top[i] = jugadores[0]; // La tabla "top" se irá rellenando con el mejor jugador de cada equipo.
		}
		
		// En este punto, la tabla "top" tiene los mejores goles de jugador de cada equipo, pero no están ordenadas
		
		for (int i = 0; i < top.length; i++) { // Recorre la tabla "top".
			for (int j = 0; j < top.length; j++) { // Recorre la tabla "top" en base al recorrido del for() anterior.
				
				// Esta lógica organiza los datos del jugador de mayor a menor.
				
 				if (top[i].getGoles() > top[j].getGoles()) { // Comprueba si los goles del jugador son mayores a los del resto, según la posicion del 1º for(), es decir, la "i".
					Jugador caja = top[i]; // En caso de serlo, guarda el Jugador "i" en una caja para conservar temporalmente los datos.
					top[i] = top[j]; // Se sobreescribe el primer dato del Jugador "i" con el dato coincidente del Jugador "j".
					top[j] = caja; // Se sobreescribe el dato coincidente del Equipo "j" con el dato guardado en la caja.
				}
			}
		}
		
		System.out.println();
		
		// En este punto tenemos la tabla "top" ordenada de mayor a menor cantidad de goles, ahora solo queda mostrar el top 5.
		
		for (int i = 0; i < 5; i++) { // Recorre los 5 primeros datos de la tabla.
			System.out.println("Nombre: "+top[i].getNombre());
			System.out.println("Goles: "+top[i].getGoles());
			System.out.println();
		}
	}
	
	/**
	 * Pre: ---
	 * Post: el método visualizarMasExpulsiones() muestra por pantalla el top 5 de jugadores con más expulsiones 
	 * con el nombre de los jugadores y sus expulsiones, ordenados de mayor a menor.
	 *  
	 * */
	
	public void visualizarMasExpulsiones() {
		Jugador [] top = new Jugador [clasificacion.length]; // Crea una tabla de Jugadores donde se irá colocando el que tenga más tarjetas rojas de cada equipo.
		
		for (int i = 0; i < clasificacion.length; i++) { // Recorre la tabla de "clasificacion".
			
			Jugador [] jugadores = clasificacion[i].getJugadores(); // Se guardará los jugadores de un equipo de manera externa.
			
			for (int j = 0; j < jugadores.length; j++) { // Recorre la tabla de "jugadores".
				for (int k = 0; k < jugadores.length; k++) { // Recorre la tabla de "jugadores" en base al recorrido del for() anterior.
					
					// Esta lógica organiza los datos del jugador de mayor a menor.
					
					if (jugadores[j].getTarjetasRojas() > jugadores[k].getTarjetasRojas()) { // Comprueba si las tarjetas rojas del jugador son mayores a los del resto, según la posicion del 1º for(), es decir, la "i".
						Jugador caja = jugadores[j]; // En caso de serlo, guarda el Jugador "i" en una caja para conservar temporalmente los datos.
						jugadores[j] = jugadores[k]; // Se sobreescribe el primer dato del Jugador "i" con el dato coincidente del Jugador "j".
						jugadores[k] = caja; // Se sobreescribe el dato coincidente del Equipo "j" con el dato guardado en la caja.
					}
				}
			}
			top[i] = jugadores[0]; // La tabla "top" se irá rellenando con el jugador con más tarjetas rojas de cada equipo.
		}
		
		// En este punto, la tabla "top" tiene los jugadores con más tarjetas rojas de cada equipo, pero no están ordenadas
		
		for (int i = 0; i < top.length; i++) { // Recorre la tabla "top".
			for (int j = 0; j < top.length; j++) { // Recorre la tabla "top" en base al recorrido del for() anterior.
				
				// Esta lógica organiza los datos del jugador de mayor a menor.
				
 				if (top[i].getTarjetasRojas() > top[j].getTarjetasRojas()) { // Comprueba si las tarjetas rojas del jugador son mayores a los del resto, según la posicion del 1º for(), es decir, la "i".
					Jugador caja = top[i]; // En caso de serlo, guarda el Jugador "i" en una caja para conservar temporalmente los datos.
					top[i] = top[j]; // Se sobreescribe el primer dato del Jugador "i" con el dato coincidente del Jugador "j".
					top[j] = caja; // Se sobreescribe el dato coincidente del Equipo "j" con el dato guardado en la caja.
				}
			}
		}
		
		System.out.println();
		
		// En este punto teneoms la tabla "top" ordenada de mayor a menor cantidad de expulsiones, ahora solo queda mostrar el top 5.
		
		for (int i = 0; i < 5; i++) { // Recorre los 5 primeros datos de la tabla.
			System.out.println("Nombre: "+top[i].getNombre());
			System.out.println("Expulsiones: "+top[i].getTarjetasRojas());
			System.out.println();
		}
	}
	
	/**
	 * Pre: ---
	 * Post: el método visualizarEquiposMasGoleadores() muestra por pantalla el top 3 de equipos con más goles con 
	 * el nombre de los equipos y sus goles a favor, ordenados de mayor a menor.
	 *  
	 * */
	
	public void visualizarEquiposMasGoleadores() {
		Equipo [] top = clasificacion; // Crea una tabla de Equipos a partir de los actuales que está destinada a su ordenación.
		
		for (int i = 0; i < top.length; i++) { // Recorre la tabla de "top".
			for (int j = 0; j < top.length; j++) { // Recorre la tabla de "top" en base al recorrido del for() anterior.
				
				// Esta lógica organiza los datos del equipo de mayor a menor.
				
				if (top[i].obtenerTotalGoles() > top[j].obtenerTotalGoles()) { // Comprueba si los goles totales del equipo son mayores a los del resto, según la posicion del 1º for(), es decir, la "i".
					Equipo caja = top[i]; // En caso de serlo, guarda el Equipo "i" en una caja para conservar temporalmente los datos.
					top[i] = top[j]; // Se sobreescribe el primer dato del Equipo "i" con el dato coincidente del Equipo "j".
					top[j] = caja;  // Se sobreescribe el dato coincidente del Equipo "j" con el dato guardado en la caja.
				}
			}
		}
		
		// En este punto tenemos la tabla "top" ordenada de mayor a menor cantidad de goles, ahora solo queda mostrar el top 3.
		
		System.out.println();
		
		for (int i = 0; i < 3; i++) { // Recorre los 3 primeros datos de la tabla.
			System.out.println("Equipo: "+top[i].getNombre());
			System.out.println("Total Goles: "+top[i].obtenerTotalGoles());
			System.out.println();
		}
	}
}
