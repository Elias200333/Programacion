package JuegoDeLaVida;

public class Tripleta {
	private int iteracion;
	private int celulasVivas;
	private int celulasNuevas;
	
	public Tripleta(int iteracion, int celulasVivas, int celulasNuevas) {
		this.iteracion = iteracion;
		this.celulasVivas = celulasVivas;
		this.celulasNuevas = celulasNuevas;
	}
	
	public int getIteracion() {
		return iteracion;
	}

	public void setIteracion(int iteracion) {
		this.iteracion = iteracion;
	}

	public int getCelulasVivas() {
		return celulasVivas;
	}

	public void setCelulasVivas(int celulasVivas) {
		this.celulasVivas = celulasVivas;
	}

	public int getCelulasNuevas() {
		return celulasNuevas;
	}

	public void setCelulasNuevas(int celulasNuevas) {
		this.celulasNuevas = celulasNuevas;
	}
}
