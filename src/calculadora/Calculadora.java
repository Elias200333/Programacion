package calculadora;

import java.util.Scanner;

public class Calculadora {
	/* Pre: --
	 * 
	 * Post: Esta clase est� dedicada a realizar 
	 * operaciones num�ricas, basicamente una 
	 * calculadora con comprobantes para evitar errores.
	 * */
	
	public static void main(String[] args) {
   		boolean finBucle = false;
		while(true) {
			Scanner entrada = new Scanner(System.in);	//Recibimos los datos de consola
			int opcion; // Creamos variable int para las opciones.
			double numero1; // Creamos variable double que albergar� el primer n�mero.
			double numero2;	// Creamos variable double que albergar� el segundo n�mero.
			
			// Los siguientes prints son para informar al usuario sobre sus posibles opciones.
			
			System.out.println("�Bienvenidos a mi primera calculadora!");
			System.out.println("______________________________________");
			System.out.println("1.-Sumar");
			System.out.println("2.-Restar");
			System.out.println("3.-Multiplicar");
			System.out.println("4.-Dividir");
			System.out.println("5.-FIN");
			System.out.println("______________________________________");
			System.out.println("�Qu� acci�n deseas realizar?");
			
			
			while (true) { // Iniciamos un bucle que no cesar� hasta que introduzca correctamente los datos.
				try { // Comprobante para enviar catch en caso de error.
			        opcion = Integer.parseInt(entrada.next()); // Verifica si es un valor Int
			        if (opcion < 1 || opcion > 4) { // Comprueba si se encuentra entre las 4 opciones indicadas.
			        	if (opcion == 5) { //Comprueba si elige finalizar el bucle
			        		finBucle = true; // Cambia booleana para finalizar bucle.
			        		break;
			        	} else {
			        		System.out.println("Lo siento, tu n�mero no se encuentra en el rango establecido.");
			        	}
						// Mensaje en caso de error.
					} else {
						break; // Salida del bucle en caso de datos correctos.
					}
			    }catch(NumberFormatException e) {
			        System.out.println("Casi cuela, pero solo acepto n�meros enteros ;)");
			        // Mensaje de error en caso de no cumplir con el comprobante Int.
			    }
			}
			if (finBucle) { // Comprueba si selecciono finalizar bucle
				break; // Sale del bucle
			}
			System.out.println("Introduce el primer numero:");
			while (true) { // Iniciamos un bucle que no cesar� hasta que introduzca correctamente los datos.
				String caja = entrada.next(); // Creamos variable string para albergar dato de entrada.
				boolean comprobante = comprobacion(caja); //Enviamos a metodo comprobacion el dato de entrada
				
				if (comprobante) { // Si el resultado de comprobaci�n es true, continua guardando los datos.
					numero1 = Double.parseDouble(caja); // Guardo dato de caja como un double en variable.
					break; // Rompo bucle.
				} else { // En caso contrario, significa que no es un n�mero, y devuelve mensaje de error.
					System.out.println("Casi cuela, pero solo acepto n�meros ;)");
					System.out.println("Si has llegado a colocar alguna coma, tendr�s que sustituirlo por un punto");
				}
			}
			System.out.println("Introduce el segundo numero:");
			while (true) { // Iniciamos un bucle que no cesar� hasta que introduzca correctamente los datos.
				String caja = entrada.next(); // Creamos variable string para albergar dato de entrada.
				boolean comprobante = comprobacion(caja); //Enviamos a metodo comprobacion el dato de entrada
				
				if (comprobante) { // Si el resultado de comprobaci�n es true, continua guardando los datos.
					numero2 = Double.parseDouble(caja); // Guardo dato de caja como un double en variable.
					break; // Rompo bucle.
				} else { // En caso contrario, significa que no es un n�mero, y devuelve mensaje de error.
					System.out.println("Casi cuela, pero solo acepto n�meros ;)");
				}
			}
			if (opcion == 1) { // Dependiendo de la opci�n elegida antes, se desviar� a un m�todo a operar.
				System.out.println("Tu resultado es "+metodo1(numero1, numero2));  //Sumar
			}else if (opcion == 2) {
				System.out.println("Tu resultado es "+metodo2(numero1, numero2));  //Restar
			}else if (opcion == 3) {
				System.out.println("Tu resultado es "+metodo3(numero1, numero2));  //Multiplicar
			}else if (opcion == 4) {
				System.out.println("Tu resultado es "+metodo4(numero1, numero2));  //Dividir
			}
		}
	}
	
	/**
	 * Pre: comprobacion
	 * Post: Este m�todo comprueba en un [try,catch] si un dato introducido en entrada es double.
	 * Retorna true si es correcto, y en caso contrario, retorna false.
	 */
	private static boolean comprobacion(String comprobante) { // M�todo para comprobar si un dato es double.
		try {
	        Double.parseDouble(comprobante); //Comprobamos si la variable recibida es un double.
	        return true; // Retorna booleana true en caso de que se haya ejecutado.
	    } catch(NumberFormatException e) {
	        return false; // Retorna booleana false en caso de error.
	    }
	}
	
	/**
	 * Pre: metodo1
	 * Post: Este m�todo realiza una operaci�n aritmetica en forma de suma.
	 */
	private static double metodo1(double dato1, double dato2) { // M�todo que realiza y devuelve una suma.
		return dato1+dato2;
	}
	
	/**
	 * Pre: metodo2
	 * Post: Este m�todo realiza una operaci�n aritmetica en forma de resta.
	 */
	private static double metodo2(double dato1, double dato2) { // M�todo que realiza y devuelve una resta.
		return dato1-dato2;
	}
	
	/**
	 * Pre: metodo3
	 * Post: Este m�todo realiza una operaci�n aritmetica en forma de multiplicaci�n.
	 */
	private static double metodo3(double dato1, double dato2) { // M�todo que realiza y devuelve una multiplicaci�n.
		return dato1*dato2;
	}
	
	/**
	 * Pre: metodo4
	 * Post: Este m�todo realiza una operaci�n aritmetica en forma de divisi�n.
	 */
	private static double metodo4(double dato1, double dato2) { // M�todo que realiza y devuelve una divisi�n.
		return dato1/dato2;
	}
}
