package tarea2;

public class Ejercicio5 {
	public static void main(String[] args) {
		/*En este caso, como queremos obtener numeros pares hasta el 100, la mejor manera de obtener numeros 
		 * pares es multiplicando cualquier numero entre 2, de manera que el limite del while es la mitad de 
		 * 100, para que el indice multiplicado por 2 resulte en todos los numeros pares entre el 1 y el 100*/
		int i = 0;
		while (i <= 50) {
			System.out.println(i*2);
			i++;
		}
	}
}
