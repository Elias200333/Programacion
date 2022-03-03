package tarea11;

import java.util.ArrayList;

public class Ejercicio2 {
	public static void main(String[] args) {
		ArrayList<Coche> coches = new ArrayList<Coche>();

		Coche caja = new Coche("0001MMM", "Azul", 3);
		coches.add(caja);
		
		caja = new Coche("1000MMM", "Verde", 4);
		coches.add(caja);

		caja = new Coche("0100MMM", "Gris", 1);
		coches.add(caja);
		
		caja = new Coche("0010MMM", "Rojo", 4);
		coches.add(caja);
		
		for (Coche coche: coches) {
			if (coche.getPuertas() == 4 && coche.getColor().equals("Rojo")) {
				System.out.println(coche.getMatricula());
				System.out.println(coche.getColor());
				System.out.println(coche.getPuertas());
			}
		}
	}
}