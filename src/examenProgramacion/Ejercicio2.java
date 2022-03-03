package examenProgramacion;


public class Ejercicio2 {
	public static void comprobarFechas(String[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i]+" -> ");
			
			String [] fecha = t[i].split("/");
			int dia = Integer.parseInt(fecha[0]);
			int mes = Integer.parseInt(fecha[1]);
			int ano = Integer.parseInt(fecha[2]);
			if (esValido(dia, mes, ano)) {
				System.out.print("OK");
			} else {
				System.out.print("ERROR");
			}
			
			System.out.println();
		}
	}
	

	private static boolean esValido(int dia, int mes, int ano) {
		int [] meses30dias = {4,6,9,11}; // tabla de meses con 30 dias
		
		if (esBisiesto(ano)) { // comprobando si es bisiesto
			if (mes == 2) { // en caso de serlo, verifica si es febrero
				if (dia > 29) { // en caso de serlo, verifica si se pasa del día permitido
					return false;
				}
			}
		} else {
			if (mes < 0 || mes > 12) { // comprobando si el mes se encuentra en el rango de meses
				return false;
			}
			
			if (dia < 0 || dia > 31) { // comprobando si el día se encuentra en el máximo permitido
				return false;
			} else if (mes == 2) { // en caso de estar, comprueba si es febrero
				if (dia > 28) { // en caso de serlo, comprueba si se pasa del día permitido
					return false;
				}
			} else { 
				for (int i = 0; i < meses30dias.length; i++) { // recorre la tabla con los meses de 30 días posibles
					if (mes == meses30dias[i]) { // comprueba si el mes pertenece a algún valor de la tabla
						if (dia > 30) { // en caso de serlo, comprueba si se pasa del día permitido
							return false;
						}
					} 
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Pre: ---
	 * Post: devuelve [true] sí y solo sí el [ano] pasado como
	 * 		parámetro es bisiesto. En caso contrario, devuelve [false].
	 */
	private static boolean esBisiesto(int ano) {
		if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0)))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		String[] t = {"28/02/1995", "28/03/2010", 
				"32/12/1995", "02/01/2019", "29/02/2024"};
		comprobarFechas(t);
	}
}
