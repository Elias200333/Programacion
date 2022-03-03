package herencias2;

public  class Coche1 implements Vehiculo {
	private int plazas;
	private String color;
	int velocidad = 0;
	
	public Coche1 (int plazas, String color) {
		this.plazas= plazas;
		this.color= color;
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
	public String frenar(int cuanto ) {
		velocidad-=cuanto;
		return "El coche va frenando y va a " + velocidad + " KM/H";
	}

	@Override
	public String acelerar(int cuanto) {
		
		velocidad+=cuanto;
		return "El coche va acelerando y va a " + velocidad + " KM/H";
		
	}
	@Override
	public String toString() {
		return  "Num_puertas: " + plazas + "\nColor: " + color;
		
	}

}
