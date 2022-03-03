package tarea7;

public class Ejercicio06{
	public static void main(String[] args) {
		int [] tabla = new int [10];
		
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = i;
		}
		
		tabla = insertElement(tabla, 43, 2);
		
		System.out.println(tabla[2]);
	}
	/*

	 num= numero a insertar
	 
	 index = posicion en la tabla

	 */
	
	private static int [] insertElement(int[] tabla, int num, int index) {
		
		for (int i = tabla.length - 1; i > index ; i--) {
			tabla [i-1] = tabla[i];
		}
		
		tabla [index] = num;
		return tabla;
	}
}
