package ArrayList;

import java.util.ArrayList;

public class Ejercicio09 {
	public static void main(String[] args) {
		int n = 2;
		int m = 6;
		ArrayList<String> colores = new ArrayList<String>();
		
		colores.add("Rojo"); colores.add("Naranja"); colores.add("Amarillo"); colores.add("Verde"); 
		colores.add("Azul"); colores.add("Morado"); colores.add("Rosa");
		
		for (int i = 0; i <= m-n; i++) {
			colores.remove(n);
		}
		
		for(String color: colores) {
			System.out.println(color);
		}
	}
}