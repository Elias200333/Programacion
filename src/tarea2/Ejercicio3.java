package tarea2;

public class Ejercicio3 {
	public static void main(String[] args) {
		/*En este caso, utilizamos el indice "i" para realizar una suma consecutiva, guardando cada resultado del
		 * bucle en la variable "resultado", de manera que al finalizar el bucle nos de como resultado la suma
		 * total de todos los numeros.*/
		int i = 50;
		int resultado = 0;
		
		while (i <= 100) {
			resultado = resultado + i;
			i++;
		}
		System.out.println("El resultado es "+resultado);
	}
}
