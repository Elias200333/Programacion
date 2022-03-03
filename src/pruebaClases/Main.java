package pruebaClases;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Producto elegido = new Producto("0987324","Las mejores zapatillas de todas","pepepepe","Nike");
		
		elegido.mostrarProducto();
		
		Producto[] lista = new Producto[5];
		Ropa [] listaRopa = new Ropa[5];
		
		for (int i = 0; i < lista.length; i++) {
			System.out.println("Introduce el nombre del producto:");
			String nombre = entrada.next();
			System.out.println("Introduce la descripcion del producto:");
			String descripcion = entrada.next();
			System.out.println("Introduce el precio del producto:");
			String precio = entrada.next();
			System.out.println("Introduce la marca del producto:");
			String marca = entrada.next();
			System.out.println("Introduce el tipo del producto:");
			String tipo = entrada.next();
			
			lista[i] = new Producto(nombre, descripcion, precio, marca);
			listaRopa[i] = new Ropa(nombre, descripcion, precio, marca, tipo);
		}
		
		
		
		for (int i = 0; i < lista.length; i++) {
			lista[i].mostrarProducto();
		}
		
		
	}
}
