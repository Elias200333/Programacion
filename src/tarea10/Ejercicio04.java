package tarea10;

public class Ejercicio04 {
	public static void main(String[] args) {
		System.out.println("CREANDO TABLA");
		String [] a = new String [5];
		
		a[0] = "pepe"; a[1] = "pepa"; a[2] = "hola"; a[3] = "adios"; a[4] = "gozada";
		
		System.out.println(copiarTabla(a)[0]);
	}
	
	private static String [] copiarTabla(String [] tabla) {
		String [] tablaCopia = new String[tabla.length];
		for (int i = 0; i < tabla.length; i++) {
			tablaCopia[i] = tabla[tabla.length - 1 - i];
		}
		return tablaCopia;
	}
}
