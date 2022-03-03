package tarea11;

import java.util.ArrayList;

public class Ejercicio01 {
	public static void main(String[] args) {
		ArrayList<Integer> prueba = new ArrayList<Integer>();
		
		for (int i = 1; i < 6000; i++) {
			prueba.add(i);
		}
		
		for (int i = 1; i < prueba.size(); i++) {
			System.out.println(prueba.get(i));
		}
		
		for (int eleccion: prueba) {
			System.out.println(eleccion);
		}
	}
}