package ArrayList;

import java.util.ArrayList;

public class Ejercicio06 {
	public static void main(String[] args) {
		int indice = 2;
		ArrayList<String> colores = new ArrayList<String>();
		
		colores.add("Rojo"); colores.add("Naranja"); colores.add("Amarillo"); colores.add("Verde"); 
		colores.add("Azul"); colores.add("Morado"); colores.add("Rosa"); 
		
		ArrayList<String> colores2 = new ArrayList<String>();
		
		for(int i = 0; i < colores.size();i++) {
			colores2.add(colores.get(i));
		}
		
		for(String color2: colores2) {
			System.out.println(color2);
		}
	}
}