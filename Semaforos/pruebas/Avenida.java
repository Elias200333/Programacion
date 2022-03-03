package pruebas;

public class Avenida {
	private int distanciaMaxima;
	private double distanciaMinima = 0.1;
	private int [][] datosAvenida;
	
	public Avenida (int dMax, int[][]tabla) {
		distanciaMaxima = dMax;
		datosAvenida = tabla;
	}

	public int getDistanciaMaxima() {
		return distanciaMaxima;
	}

	public void setDistanciaMaxima(int distanciaMaxima) {
		this.distanciaMaxima = distanciaMaxima;
	}

	public int[][] getDatos() {
		return datosAvenida;
	}

	public void setDatos(int[][] datos) {
		this.datosAvenida = datos;
	}
	public String getVelocidadYTiempo() {
		double velocidadFinal = 0;
		double tiempoFinal = 0;
		int multiplicador = 1;
		boolean noReiniciar = false;
		String resultadoFinal = "IMPOSIBLE";
		while (multiplicador < 10) {
			int [][] datos = datosAvenida;
			int distanciaTotal = 0;
			double mediaDistancia = 0;
			double mediaSegundos = 0;
			double sumaDistancia = 0;
			double velocidad = 0;
			
			int [] mcd = new int[datos.length];
			
			for (int i = 0; i < datos.length; i++) {
				System.out.println(datos[i][1]);
				int sumador = 0;
				for (int iterador = 1; iterador < multiplicador; iterador++) {
					sumador += datos[i][1];
					sumador += datos[i][2];
				}
				System.out.println(sumador);
				datos[i][1] += sumador;
				System.out.println("Semáforo "+ i);
				System.out.println("Distancia al semaforo: "+datos[i][0]);
				System.out.println("Tiempo rojo: "+datos[i][1]);
				System.out.println("Tiempo verde: "+datos[i][2]);
				distanciaTotal += datos[i][0];
				
				mcd[i] = datos[i][2]+datos[i][1];	
				
				sumaDistancia += datos[i][0];
			}
			mediaSegundos = mComunDivisor(mcd);
			
			mediaDistancia = sumaDistancia / datos.length;
			
			velocidad = mediaDistancia / mediaSegundos;
			
			while (true) {
				System.out.println("Velocidad: "+velocidad);
				if (velocidad < 0.1) {
					System.out.println("Bajé de la velocidad mínima");
					break;
				}
				if (velocidad > distanciaMaxima) {
					System.out.println("Superé la velocidad máxima");
					velocidad /= datos.length;
				} else {
					boolean cumple = true;
					for (int i = 0; i < datos.length; i++){
						System.out.println("Segundos hasta llegar al semaforo "+i+"= "+datos[i][0]/velocidad);
						System.out.println("Distancia entre semaforos: "+datos[i][0]);
						System.out.println("Segundos del semaforo "+datos[i][2]);
						if (datos[i][0]/velocidad > datos[i][2]) {
							System.out.println("No cumplio la condicion");
							cumple = false;
							break;
						}
					}
					if (cumple) {
						noReiniciar = true;
						break;
					} else {
						velocidad /= datos.length;
					}
				}
			}
			
			
			if (noReiniciar) {
				velocidadFinal = velocidad;
				double tiempo = distanciaTotal / velocidadFinal;
				resultadoFinal = velocidadFinal+"m/s "+tiempo+" s";
				break;
			}
			multiplicador++;
		}
		
		return resultadoFinal;
	}
	
	private double mComunDivisor(int[] mcd) {
		double [][] resultados = new double[mcd.length][mcd.length];
		double numero = 0;
		String [] tablaNumeros = new String [mcd.length];
		
		
		for (int i = 0; i < mcd.length; i++) {
			for (int j = 0; j < mcd.length; j++) {
				int a = Math.max(mcd[i], mcd[j]);
			    int b = Math.min(mcd[i], mcd[j]);
			 
			    int resultado = 0;
			    do {
			        resultado = b;
			        b = a % b;
			        a = resultado;
			    } while (b != 0);
			    
			    resultados[i][j] = resultado;
			}
		}
		
		double [] nCoincidentes = new double [resultados.length];
		
		for (int fila = 0; fila < resultados.length; fila++) {
			for (int celda = 0; celda < resultados[fila].length; celda++) {
				boolean estaEnTodas = true;
				for (int fila2 = 0; fila2 < resultados.length; fila2++) {
					boolean filaActual = false;
					for (int celda2 = 0; celda2 < resultados[fila2].length; celda2++) {
						if (resultados[fila][celda] == resultados[fila2][celda2]) {
							filaActual = true;
							break;
						}
					}
					if (!filaActual) {
						estaEnTodas = false;
						break;
					}
				}
				if (estaEnTodas) {
					nCoincidentes[fila] = resultados[fila][celda];
				}
			}
		}
		
		for (int i = 0; i < nCoincidentes.length; i++) {
			if (i == 0) {
				numero = nCoincidentes[i];
			} else if (numero < nCoincidentes[i]) {
				numero = nCoincidentes[i];
			}
		}
		
		return numero;
	}
}
