package tarea6;

public class Ejercicio02 {
	public static void main(String[] args) {
		System.out.println("Bucle numeros:");
		
		for (int i = 1; i <= 110; i++) {
			if (i % 11 == 0) {
				System.out.println("");
			}
			if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
				if (i % 3 == 0) {
					if (i % 5 == 0) {
						System.out.print(" CozaLoza");
					} else {
						System.out.print(" Coza");
					}
				}
				if (i % 5 == 0) {System.out.print(" Loza");}
				if (i % 7 == 0) {System.out.print(" Woza");}
			} else {
				System.out.print(" "+i);
			}
		}
	}
}
