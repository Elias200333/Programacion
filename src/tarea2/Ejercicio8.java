package tarea2;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		/*En este ejercicio, creamos 2 variables llamadas "cajaGuardadoMas", donde guardaremos el numero m�s 
		 * grande, y la variable "cajaGuardadoMenos, donde guardaremmos el numero m�s peque�o. 
		 * 
		 * Despu�s solicitaremos en el bucle while el numero a escoger, y mediante una serie de "if" 
		 * comprobaremos si el n�mero elegido es m�s grande que la variable "cajaGuardadoMas". Si es el caso, 
		 * metemos el numero elegido en la variable dicha. 
		 * 
		 * En caso contrario, continuara hasta la condici�n en la que, si detecta que el indice "i", es igual 
		 * a 0, es decir, que es el primer ciclo del bucle while, haremos que directamente el numero elegido 
		 * se guarde en la variable "cajaGuardadoMenos". 
		 * 
		 * La ultima condici�n comprueba si el numero elegido es menor a "cajaGuardadoMenos", y en caso que lo
		 * sea insertamos el valor del numero elegido en la variable dicha.
		 * 
		 * Finalmente, al finalizar el bucle se muestra un print con el resultado de las variables 
		 * "cajaGuardadoMas" y "cajaGuardadoMenos".*/
		Scanner entrada = new Scanner(System.in);
		int cajaGuardadoMas = 0;
		int cajaGuardadoMenos = 0;
		int i = 0;
		System.out.println("Dame un total de 10 n�meros");
		while (i < 10) {
			int numeroElegido = entrada.nextInt();
			
			if (numeroElegido > cajaGuardadoMas) {
				cajaGuardadoMas = numeroElegido;
			}
			if (i == 0) {cajaGuardadoMenos = numeroElegido;cajaGuardadoMas = numeroElegido;}
			if (numeroElegido < cajaGuardadoMenos){
				cajaGuardadoMenos = numeroElegido;
			}
			System.out.println("Vale, el siguiente.");
			i++;
		}
		System.out.println("El n�mero m�s grande que me has dado es el " + cajaGuardadoMas + " y el m�s peque�o es el " + cajaGuardadoMenos);
	}
}
