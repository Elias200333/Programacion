package tarea3;

import java.util.Scanner;

public class Ejercicio4 {
	/*
	 * �IMPLEMENTA TU PRIMER JUEGO! Realiza un programa Java que adivine
		el n�mero. El programa generar� un n�mero aleatorio entre 0 y 20
		(usando Math.random()) y luego ir� pidiendo n�meros al usuario
		indicando �mayor� o �menor� seg�n sea mayor o menor con respecto al
		n�mero generado aleatoriamente. El proceso termina cuando el usuario
		acierta, y deber� mostrar un mensaje de felicitaciones junto al n�mero de
		intentos que ha necesitado el usuario.
		*/
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); // Recoge la entrada del usuario
		mensajeInicio(); // Ejecuta m�todo con mensaje de inicio.
		String continuar = entrada.next(); // El void se pausa hasta que introduzca cualquier tecla y pulse intro.
		inicioJuego(); // Inicia el m�todo para iniciar el juego.
	}
	
	private static void mensajeInicio() { // M�todo de mensaje de inicio
		System.out.println("BIENVENIDO A ESTE JUEGO");
		System.out.println("_______________________"); 
		System.out.println("Instrucciones:"); 
		System.out.println("1. Se generar� un n�mero \n  aleatorio  entre el 0 y el 20, que tendr�s que adivinar.");
		System.out.println("");
		System.out.println("2. Si adivinas el n�mero \n  �GANAS! Se te ir� indicando \n si tu numero puesto es mayor o menor.");
		System.out.println("");
		System.out.println("3. Se te mostrar� la cantidad \n  de intentos que te ha costado");
		System.out.println("");
		System.out.println("Si lo has entendido, pulsa cualquier tecla e intro para continuar.");
	}
	
	private static int random() { // M�todo para generar un n�mero aleatorio.
		int numero = (int) Math.round(Math.random() * 20); // Genera un n�mero random entre el 0 y el 19 redondeado por funci�n round.
		return numero; // Retorna el n�mero
	}
	
	private static void inicioJuego() { // M�todo para iniciar el juego.
		Scanner entrada = new Scanner(System.in); // Recoge la entrada del usuario.
		int nAleatorio = random(); // Llama al m�todo random
		int contador = 0; // Creamos un contador para los intentos.
		
		System.out.println("Vale, ya se ha elegido el n�mero. \n\nAhora, intenta adivinarlo.");

		while (true) { // Iniciamos el bucle de intentos.
			int numero = entrada.nextInt(); // Guardamos la entrada del usuario.
			if (numero == nAleatorio) { // Comprobamos si ha acertado el n�mero.
				System.out.println("Enhorabuena. Has acertado el n�mero en "+contador+" intentos."); // Mensaje en caso de acertarlo.
				break; // Rompe el bucle.
			} else { 
				contador++; // Incrementa el contador en caso de fallar.
				if (numero < nAleatorio) { // Comprueba si el n�mero es m�s mayor que el aleatorio.
					System.out.println("Tu n�mero es m�s mayor que el n�mero elegido."); // Envia este mensaje en caso de ser m�s mayor.
				} else {
					System.out.println("Tu n�mero es m�s peque�o que el n�mero elegido."); // Envia este mensaje en caso de ser m�s peque�o.
				}
			}
		}
		String hola = "hoal";
		int longitud = hola.length();
		System.out.println(longitud);
	}
}
