package ArrayList;

import java.util.ArrayList;

public class Ejercicio01 {
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		
		colores.add("Rojo"); colores.add("Naranja"); colores.add("Amarillo"); colores.add("Verde"); 
		colores.add("Azul"); colores.add("Morado"); colores.add("Rosa"); 
		
		for(String color: colores) {
			System.out.println(color);
		}
	}
}