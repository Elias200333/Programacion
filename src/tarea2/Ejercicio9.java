package tarea2;

import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args) {
		/*En este ejercicio, creamos 2 variables llamadas "cajaGuardadoMas", donde guardaremos el numero de
		 * enteros positivos, la variable "cajaGuardadoMenos, donde guardaremos el numero de enteros
		 * negativos y la variable "contadorCeros", donde guardaremos el numero de 0 puestos. 
		 * 
		 * Después solicitaremos en el bucle while el numero a escoger, y mediante una serie de "if" 
		 * comprobaremos si el número elegido es mayor que 0. Si es el caso, damos incremento a la variable 
		 * "cajaGuardadoMas".
		 * 
		 * En caso contrario, continuara hasta la condición en la que, si detecta que el numero es igual 
		 * a 0, damos incremento a la variable "contadorCeros".
		 * 
		 * La ultima condición comprueba si el numero elegido es menor a 0,  damos incremento a la 
		 * variable "cajaGuardadoMenos".
		 * 
		 * Finalmente, al finalizar el bucle se muestra un print con el resultado de las variables 
		 * "cajaGuardadoMas", "cajaGuardadoMenos" y "contadorCeros".*/
		int cajaGuardadoMas = 0;
		int cajaGuardadoMenos = 0;
		int contadorCeros = 0;
		int i = 0;
		System.out.println("Dame un total de 10 números");
		while (i < 10) {
			Scanner entrada = new Scanner(System.in);
			int numeroElegido = entrada.nextInt();
			
			if (numeroElegido > 0) {
				cajaGuardadoMas++;
			}
			if (numeroElegido == 0) {contadorCeros = contadorCeros + 1;}
			if (numeroElegido < 0){
				cajaGuardadoMenos++;
			}
			i++;
			System.out.println("Llevas "+i+"intentos");
		}
		System.out.println("Has puesto "+cajaGuardadoMas+" numeros positivos,  "+cajaGuardadoMenos+" números negativos y un total de "+contadorCeros+" ceros.");
	}
}
