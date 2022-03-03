package aviones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import bicis.UsuarioBici;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce la ruta del fichero csv de accidentes aereos: ");
		ArrayList<Accidentes> tabla = ficheroTabla(entrada.nextLine());
	}
	
	private static ArrayList<Accidentes> ficheroTabla(String ruta){
		ArrayList<Accidentes> tabla = new ArrayList<Accidentes>();
		File file = new File(ruta);														// Localizar fichero
		boolean primeraLinea = true;
		
		try {
			Scanner f = new Scanner(file);													// Leer fichero
			int contador = 1;
			while(f.hasNextLine()) {														// Mientras haya lineas que recorrer
				if (primeraLinea) {															// Si es la primera linea
					String nulo = f.nextLine();
					primeraLinea = false;
				} else {
					String linea = f.nextLine();
					String[] lineaLeida = linea.split(",");
					String sumary = "";
					for(int i = 12; i < lineaLeida.length; i++) {
						sumary += lineaLeida[i];
					}
					
					if (lineaLeida.length < 14) {
						if (lineaLeida.length == 13) {
							Accidentes caja = new Accidentes(lineaLeida[0], 
									lineaLeida[1], lineaLeida[2] , lineaLeida[3],
									lineaLeida[4], lineaLeida[5], lineaLeida[6], lineaLeida[7],
									lineaLeida[8], lineaLeida[9], lineaLeida[10], lineaLeida[11], sumary);
							tabla.add(caja);
						} else {
							
							String datos[] = {"","","","","","","","","","","","",""};
							
							for (int i = 0; i < lineaLeida.length-1; i++) {
								if (i == 2) {
									datos[i] = lineaLeida[i]+",";
									datos[i] += lineaLeida[i+1];
								} else if (i > 2) {
									datos[i] = lineaLeida[i+1];
								} else {
									datos[i] = lineaLeida[i];
								}
								
							}
							
							Accidentes caja = new Accidentes(datos[0], 
									datos[1], datos[2] , datos[3],
									datos[4], datos[5], datos[6], datos[7],
									datos[8], datos[9], datos[10], datos[11], datos[12]);
							tabla.add(caja);
						}
					} else {
						String location = lineaLeida[2]+","+lineaLeida[3];
						Accidentes caja = new Accidentes(lineaLeida[0], 
								lineaLeida[1], location , lineaLeida[4],
								lineaLeida[5], lineaLeida[6], lineaLeida[7], lineaLeida[8],
								lineaLeida[9], lineaLeida[10], lineaLeida[11], lineaLeida[12], sumary);
						tabla.add(caja);
					}
					contador++;
				}
			}
			
		} catch (FileNotFoundException errorEnArchivo) {
			System.out.println(errorEnArchivo);
		}
		
		for (int i = 0; i < tabla.size(); i++) {
			System.out.println("Linea"+i+": "+tabla.get(i).getDate()+"**"+
			tabla.get(i).getTime()+"**"+tabla.get(i).getLocation()+"**"+
			tabla.get(i).getOperator()+"**"+tabla.get(i).getnFlight()+"**"+
			tabla.get(i).getRoute()+"**"+tabla.get(i).getType()+"**"+
			tabla.get(i).getRegistration()+"**"+tabla.get(i).getCnIn()+"**"+
			tabla.get(i).getAboard()+"**"+tabla.get(i).getFatalities()+"**"+
			verBooleano(tabla.get(i).isGround()));
		}
		
		return tabla;
	}
	
	private static String verBooleano(boolean booleano) {
		if (booleano) {
			return "True";
		}
		return "False";
	}
}
