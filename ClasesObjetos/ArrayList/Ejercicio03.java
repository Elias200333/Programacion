package ArrayList;

import java.util.ArrayList;

public class Ejercicio03 {
	public static void main(String[] args) {
		int indice = 5;
		ArrayList<String> colores = new ArrayList<String>();
		
		colores.add("Rojo"); colores.add("Naranja"); colores.add("Amarillo"); colores.add("Verde"); 
		colores.add("Azul"); colores.add("Morado"); colores.add("Rosa"); 
		
		System.out.println(colores.get(indice)); 
	}
}