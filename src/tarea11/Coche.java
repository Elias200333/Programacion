package tarea11;

public class Coche{
	private String matricula;
	private String color;
	private int puertas;
	
	public Coche(String matricula, String color, int puertas) {
		this.setMatricula(matricula);
		this.setColor(color);
		this.setPuertas(puertas);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
}
