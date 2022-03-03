package tarea10;


public class Ejercicio03 {
	public static void main(String[] args) {
		System.out.println("CREANDO TABLA");
		int [] a = new int [5];
		
		a[0] = 5; a[1] = 4; a[2] = 3; a[3] = 2; a[4] = 0;
		
		estadisticasTabla(a);
	}
	
	private static void estadisticasTabla(int [] tabla) {
		int positivos = 0;
		int negativos = 0;
		int nCeros = 0;
		int nPares = 0;
		int nImpares = 0;
		
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] > 0) {
				positivos++;
			} else if (tabla[i] < 0) {
				negativos++;
			} else {
				nCeros++;
			}
			
			if (tabla[i] % 2 == 0) {
				nPares++;
			} else {
				nImpares++;
			}
		}
		
		System.out.println("RESULTADOS:");
		System.out.println("NÚMERO DE POSITIVOS -> "+positivos);
		System.out.println("NÚMERO DE NEGATIVOS -> "+negativos);
		System.out.println("NÚMERO DE CEROS -> "+nCeros);
		System.out.println("NÚMERO DE PARES -> "+nPares);
		System.out.println("NÚMERO DE IMPARES -> "+nImpares);
		
	}
}
