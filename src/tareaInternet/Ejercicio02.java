package tareaInternet;

public class Ejercicio02 {
	public static void main(String[] args) {
		System.out.println("CREANDO TABLA");
		int numero=0; // se van sumanod los numeros
		int vuelta=0;
		
		
		while (true) {
			if(vuelta%2 == 0) {
				numero += 2;
			} else {
				numero += 3;
			}
			
			if(numero > 1800) {
				break;
			}
			System.out.println(numero);
			vuelta++;
		}
	}
}
