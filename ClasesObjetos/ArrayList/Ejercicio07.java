package ArrayList;

import java.util.ArrayList;

public class Ejercicio07 {
	public static void main(String[] args) {
		int indice = 2;
		ArrayList<String> colores = new ArrayList<String>();
		
		colores.add("Rojo"); colores.add("Naranja"); colores.add("Amarillo"); colores.add("Verde"); 
		colores.add("Azul"); colores.add("Morado"); colores.add("Rosa");
		
		ArrayList<String> caja = new ArrayList<String>();
		
		for (int i = colores.size()-1; i >= 0; i--) {
			caja.add(colores.get(i));
		}
		
		colores = caja;
		
		for(String color: colores) {
			System.out.println(color);
		}
	}
}