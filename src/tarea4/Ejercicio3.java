package tarea4;

public class Ejercicio3 {
	public static void main(String[] args) {
		/*En este caso, utilizamos el indice "i" para realizar una suma consecutiva, guardando cada resultado del
		 * bucle en la variable "resultado", de manera que al finalizar el bucle nos de como resultado la suma
		 * total de todos los numeros.*/
		int resultado = 0;
		
		for (int i = 50; i <= 100; i++) {
			resultado = resultado + i;
		}
		System.out.println("El resultado es "+resultado);
	}
}
