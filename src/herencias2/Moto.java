package herencias2;

public class Moto implements Vehiculo {
	private int plazas;
	private String color;
	int velocidad= 0;
	
	public Moto(int plazas, String color) {
		super();
		this.plazas = plazas;
		this.color = color;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String frenar(int cuanto) {
		velocidad-=cuanto;
		return "La moto va frenando y va a " + velocidad + " KM/H";
		
	}
	@Override
	public String acelerar(int cuanto) {
		velocidad+=cuanto;
		return "La moto va acelerando y va a " + velocidad + " KM/H";
	}
	
	
	public String toString() {
		return  "Num_puertas: " + plazas + "\nColor: " + color;
		
	}
	
}
