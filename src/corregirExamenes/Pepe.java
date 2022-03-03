package corregirExamenes;

import java.util.Scanner;

public class Pepe{
	static int nTest = 0;
	static int puntosTotales = 0;
	
	/*
	 * Pre: --
	 * 
	 * Post: El método RELLENAR ejecuta las instrucciones para comprobar las respuestas correctas, y realiza un informe 
	 * de los resultados. Además devuelve un valor booleano en caso de repetir el proceso.
	 * 
	 * */
	
	private static boolean rellenar(int[] tabla) {
		Scanner entrada = new Scanner(System.in);
		nTest++; // Incrementa los test que lleva corregidos
		int correcto = 0; // Creamos variable global en metodo para contar aciertos.
		System.out.println("_________________________________");
		System.out.println("_________________________________");
		System.out.print("Introduce las respuestas del alumno: ");
		for(int i = 0; i < tabla.length; i++) { // Recorrer bucle de tabla de preguntas
			while (true) { // Ejecución infinita hasta que introduzca datos correctos
				try {
					if (tabla[i] == Integer.parseInt(entrada.next())) { // Comprobar si el valor introducido coincide con la tabla preguntas.
						correcto++; // Incremento de respuestas correctas
					};
					break;
				} catch (NumberFormatException e){ // Ejecución en caso de introducir un valor no entero.
					System.out.println("Error favor, introduce un valor numérico entero.");
				}
			}
		}
		System.out.println("_________________________________");
		System.out.println("_________________________________");
		
		int nota = 100*correcto/tabla.length; // Algoritmo para calcular la nota media.
		
		if (nota >= 50) { // Condición en caso de que apruebe
			correcto(); // Método que imprime un dibujo
			System.out.println("Enhorabuena, tu alumno ha aprobado.");
		} else {
			incorrecto(); // Método que imprime un dibujo
			System.out.println("Lo siento, ha suspendido.");
		}
		
		puntosTotales = puntosTotales + correcto; //Aumento de puntos totales de todos los examenes.
		int numerador = puntosTotales*100; // Actua como numerador de una división aplicando los puntos totales X 100
		int denominador = nTest*tabla.length; // Actua como denominador de una división aplicando el número total de tests por el número de preguntas
		
		//INFORME
		
		System.out.println("__________________________________");
		System.out.println("|Informe:                        |");
		System.out.println("|                                |");
		System.out.println("|Aciertos: "+correcto+"                     |");
		System.out.println("|Porcentaje aciertos: "+nota+"%        |");
		System.out.println("----------------------------------");
		System.out.println("|Porcentaje MEDIA tests: " + numerador/denominador + "%     |");
		System.out.println("|________________________________|");
		
		while (true) { // Ejecución infinita hasta que introduzca datos correctos.
			System.out.print("¿Deseas hacer un nuevo test? (y/n)");
			String respuesta = entrada.next(); // Registra el dato del usuario
			if (respuesta.equals("y")) { // En caso de introducir 'y' este método retornará boleano TRUE 
				return true;
			}else if (respuesta.equals("n")) { // En caso de introducir 'n' este método retornará boleano FALSE 
				return false;
			}else {
				System.out.println("Por favor, elige una de las opciones.");
			}
		}
	}
	
	/*
	 * Pre: --
	 * 
	 * Post: El método CORRECTO imprime un dibujo ascii que aparecerá cuando el resultado sea correcto.
	 * 
	 * */
	
	private static void correcto(){
		System.out.println(""
				+ "________________$$$$__________________$$$$\r\n"
				+ " _______________$__$$_________________$$__$\r\n"
				+ " ______________$$___$_________________$___$$\r\n"
				+ " ______________$$___$_________________$___$$\r\n"
				+ " _____________$$___$$_________________$___$$\r\n"
				+ " ____________$$____$__________________$____$$\r\n"
				+ " __________$$$____$$__________________$$____$$$\r\n"
				+ " _________$$_____$$____________________$$_____$$\r\n"
				+ " ________$$______$$____________________$$______$$\r\n"
				+ " _______$$_______$_______________________$_______$$\r\n"
				+ " ______$$________$$$$$$$___________$$$$$$$________$$\r\n"
				+ " __$$$$$_______________$$$_______$$$_______________$$$$\r\n"
				+ " _$$$____________$$$$____$$_____$$____$$$$____________$$\r\n"
				+ " $$____________$$$__$$$___$_____$___$$$__$$$___________$\r\n"
				+ " $____________$$$________$$_____$$________$$$___________$\r\n"
				+ " $____________$$$$$$____$$_______$$____$$$$$$___________$\r\n"
				+ " $___________$$____$$$$$$$_______$$$$$$$____$$__________$\r\n"
				+ " $___________$$$$_______$$_______$$_______$$$$__________$\r\n"
				+ " $$_________$$__$$$$$$$$$_________$$$$$$$$$__$$________$\r\n"
				+ " _$$$$_____$$$$________$___________$________$$$$______$$\r\n"
				+ " __$$$$$____$$$$$$____$$___________$$____$$$$$$____$$$$\r\n"
				+ " ______$$__$$____$$$$$$_____________$$$$$$____$$__$$\r\n"
				+ " _______$$$_$$$_____$________________$_____$$$_$$$\r\n"
				+ " _________$$$$$$$$$$__________________$$$$$$$$$..\r\n"
				+ "");
	}
	
	/*
	 * Pre: --
	 * 
	 * Post: El método INCORRECTO imprime un dibujo ascii que aparecerá cuando el resultado sea incorrecto.
	 * 
	 * */
	
	private static void incorrecto() {
		System.out.println(""
				+ "11111111111111111111111111111\r\n"
				+ "11111111111111¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\r\n"
				+ "1111111111¶¶¶¶¶111_________________¶¶\r\n"
				+ "11111111¶¶1_______1111______111_____¶¶\r\n"
				+ "111111¶¶______11_________11111111____¶1\r\n"
				+ "111111¶____11___1_____11______1111___1¶\r\n"
				+ "11111¶1___1_____1_____1_________1_____¶1\r\n"
				+ "11111¶__________________1¶¶¶¶1________1¶\r\n"
				+ "1111¶¶_____¶¶¶¶1______1¶¶_¶¶¶¶¶1_______¶¶\r\n"
				+ "111¶¶_1_1_¶¶¶¶¶¶¶_1___¶__1¶¶¶¶¶¶111____1¶¶\r\n"
				+ "111¶_1________11¶¶1___¶¶¶1__1_____1¶¶¶1__1¶\r\n"
				+ "11¶1__1¶¶1______11_____1____¶¶__1¶¶1__¶¶__1¶\r\n"
				+ "11¶1__111¶¶¶¶___¶1___________1¶¶1___¶__¶1__¶\r\n"
				+ "11¶1____1_11___¶¶_____1¶1_________¶¶¶1__¶__¶1\r\n"
				+ "111¶_1__¶____1¶¶______11¶1_____1¶¶1_¶¶¶1¶__¶1\r\n"
				+ "111¶1__¶¶___11¶¶____¶¶¶_¶___1¶¶¶1___¶__¶___¶1\r\n"
				+ "111¶¶__¶¶¶1_____¶¶1_____11¶¶¶1_¶__1¶¶_____¶11\r\n"
				+ "1111¶__¶¶1¶¶¶1___¶___1¶¶¶¶1____¶¶¶¶¶_____¶¶11\r\n"
				+ "1111¶__¶_1__¶¶¶¶¶¶¶¶¶11__¶__1¶¶¶1_¶_____¶¶111\r\n"
				+ "1111¶1_¶¶¶__1___¶___1____¶¶¶¶¶1¶_¶¶____¶¶1111\r\n"
				+ "1111¶1_¶¶¶¶¶¶¶1¶¶11¶¶1¶¶¶¶¶1___1¶¶_____¶11111\r\n"
				+ "1111¶1_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1_¶____¶¶_____¶¶11111\r\n"
				+ "1111¶1_¶¶¶¶¶¶¶¶¶¶¶¶1¶1____¶__1¶¶______¶111111\r\n"
				+ "1111¶__1¶¶_¶_¶__¶___11____1¶¶¶______1¶1111111\r\n"
				+ "1111¶___¶¶1¶_11_11__1¶__1¶¶¶1___11_1¶11111111\r\n"
				+ "1111¶_____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1___11111¶¶111111111\r\n"
				+ "1111¶__________11111_______111_1¶¶11111111111\r\n"
				+ "1111¶_1__11____________1111__1¶¶1111111111111\r\n"
				+ "1111¶__11__1________1111___1¶¶111111111111111\r\n"
				+ "1111¶___1111_____________1¶¶11111111111111111\r\n"
				+ "1111¶¶_______________11¶¶¶1111111111111111111\r\n"
				+ "11111¶¶__________1¶¶¶¶¶1111111111111111111111\r\n"
				+ "1111111¶¶¶¶¶¶¶¶¶¶¶111111111111111111111111111\r\n"
				+ "");
	}
	
	/*
	 * Pre: --
	 * 
	 * Post: El método INTRODUCCION crea una tabla con la cantidad de preguntas que el usuario indica, y
	 * la rellena con sus respuestas correctas.
	 * 
	 * */
	
	private static int[] introduccion() {
		Scanner entrada = new Scanner(System.in);
		int [] tabla = new int[0]; // Crea una tabla vacio y sin valor
		System.out.print("Selecciona el número de preguntas que tendrá el examen: ");
		while (true) { // Ejecución infinita hasta que introduzca datos correctos
			try { 
				tabla = new int [Integer.parseInt(entrada.next())]; // Comprobar si la tabla se crea correctamente
				break;
			} catch (NumberFormatException e){ // Mensaje en caso de introducir valor erroneo
				System.out.println("Por favor, introduce un valor numérico entero.");
			}
		}
		System.out.println("_________________________________");
		System.out.print("Introduce las respuestas correctas del examen: ");
		for(int i = 0; i < tabla.length; i++) {
			int pregunta = i+1;
			while (true) { // Ejecución infinita hasta que introduzca datos correctos
				try {
					tabla[i] = Integer.parseInt(entrada.next()); // Rellenar las respuestas correctas en la tabla de preguntas
					break;
				} catch (NumberFormatException e){ // Mensaje en caso de introducir valor erroneo
					System.out.println("Por favor, introduce un valor numérico entero.");
				}
			}
		}
		return tabla; // Retornar la tabla con los datos
	}
	
	/*
	 * Pre: --
	 * 
	 * Post: El metodo MAIN alberga la ejecución del programa para corregir los examenes, incluido el bucle 
	 * para ejecutar de nuevo el apartado de comprobar respuestas.
	 * 
	 * */
	public static void main(String[] args) {
		int [] tabla = introduccion(); // Guarda la tabla con las respuestas correctas introducidas por el usuario.
		while (true) {
			boolean repetir = rellenar(tabla); // Ejecuta el metodo y al finalizar devuelve un valor booleano.
			
			if (repetir == false) { // Si el booleano es falso, finaliza el bucle. En caso contrario, continua ejecutando de nuevo el bucle.
				break;
			}
		}
	}
}