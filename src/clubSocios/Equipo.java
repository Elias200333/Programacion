package clubSocios;

public class Equipo {
	private String nombre;
	private String estadio;
	private int anoFundacion;
	private Jugador[] jugadores;
	private int puntos;
	private int ganados;
	private int perdidos;
	private int empatados;
 
	public Equipo(String nombre, String estadio, int anoFundacion, Jugador[] jugadores, int puntos, int ganados, int perdidos, int empatados) {
		this.nombre = nombre;
		this.estadio = estadio;
		this.anoFundacion = anoFundacion;
		this.jugadores = jugadores;
		this.puntos = puntos;
		this.ganados = ganados;
		this.perdidos = perdidos;
		this.empatados = empatados;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEstadio() {
		return estadio;
	}
	
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	
	public int getFundacion() {
		return anoFundacion;
	}
	
	public void setFundacion(int anoFundacion) {
		this.anoFundacion = anoFundacion;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}

	public int getEmpatados() {
		return empatados;
	}

	public void setEmpatados(int empatados) {
		this.empatados = empatados;
	}
	
	/**
	* Pre: ---
	 * Post: el método obtenerTotalGoles() devuelve el total de todos los goles de los jugadores
	 * del Equipo.
	 * 
	 * */
	
	public int obtenerTotalGoles() {
		int golesTotales = 0; // Se guardan los goles totales
		
		for (int i = 0; i < jugadores.length; i++) { // Se recorre la tabla de jugadores
			golesTotales += jugadores[i].getGoles(); // Se acumulan los goles de los jugadores en "golesTotales".
		}
		
		return golesTotales; // Devuelve el resultado.
	}
}