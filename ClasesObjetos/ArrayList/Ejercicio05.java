package ArrayList;

import java.util.ArrayList;

public class Ejercicio05 {
	public static void main(String[] args) {
		int indice = 2;
		ArrayList<String> colores = new ArrayList<String>();
		
		colores.add("Rojo"); colores.add("Naranja"); colores.add("Amarillo"); colores.add("Verde"); 
		colores.add("Azul"); colores.add("Morado"); colores.add("Rosa"); 
		
		colores.remove(indice);
		
		for(String color: colores) {
			System.out.println(color);
		}
	}
}