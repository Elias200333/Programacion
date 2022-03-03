package tarea10;

public class Ejercicio02 {
	public static void main(String[] args) {
		System.out.println("CREANDO TABLA");
		int [] a = new int [5];
		
		a[0] = 5; a[1] = 4; a[2] = 3; a[3] = 2; a[4] = 1;
		
		System.out.println(incrementarValores(a,5)[1]);
	}
	
	private static int [] incrementarValores(int [] tabla, int factor) {
		
		for (int i = 0; i < tabla.length; i++) {
			if (i > 0 && i < tabla.length-1) {
				tabla[i] = tabla[i]*factor;
			}
			
		}
		
		return tabla;
	}
}
