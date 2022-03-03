package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private static int[] realizarPartida(String entrada) {
		int [] partida = {0,0};
		
		String raqueta = "PIC";
		String pared = "POC";
		String punto = "PONG!";
		
		String[] partido = entrada.split(" ");
		
		boolean jugador1 = true;
		
		for (int i = 1; i < partido.length; i++){
			if (raqueta.equalsIgnoreCase(partido[i])){
				jugador1 = !jugador1;
			} else if (punto.equalsIgnoreCase(partido[i])) {
				if (jugador1) {
					
				}
			}
		}
		
		return partida;
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ArrayList<int []> partidas = new ArrayList<int []>();
		
		while (true) {
			System.out.println("Introduce la sucesión de la partida:");
			String entradaTotal = entrada.nextLine();
			if (entradaTotal.equals("0")) {
				break;
			}
			int [] partida = realizarPartida(entradaTotal);
			partidas.add(partida);
		}
		
		
		/*
		 * 4 PIC POC PIC PONG!
		 * 9 PIC POC PONG! PONG! PIC PIC PIC POC PONG!
		 * 0
		 */
	}
}
