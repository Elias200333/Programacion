package tarea7;

public class Ejercicio02 {
	public static void main(String[] args) {
		System.out.println("CREANDO TABLA");
		double [] a = new double [5];
		
		a[0] = 5; a[1] = 4; a[2] = 3; a[3] = 2; a[4] = 1;
		
		System.out.println(average(a));
	}
	
	private static double average(double [] tabla) {
		double resultado = 0;
		
		for (int i = 0; i < tabla.length; i++) {
			resultado = resultado + tabla[i];
		}
		
		resultado = resultado / tabla.length;
		
		return resultado;
	}
}
