package pruebas;

import java.util.ArrayList;
import java.util.Scanner;

public class Prueba1 {
	public static void main(String[] args) {
		ArrayList<Avenida> datosTotales = new ArrayList<Avenida>();
		Scanner entrada = new Scanner(System.in);
		
		int semaforos = Integer.parseInt(entrada.next());
		int vMaxima = Integer.parseInt(entrada.next());
		int [][] datos = new int[semaforos][3];
		
		for (int i = 0; i < semaforos; i++) {
			datos[i][0] = Integer.parseInt(entrada.next());
			datos[i][1] = Integer.parseInt(entrada.next());
			datos[i][2] = Integer.parseInt(entrada.next());
		}
		
		Avenida n1 = new Avenida(vMaxima, datos);
		
		System.out.println(n1.getVelocidadYTiempo());
	}
}
