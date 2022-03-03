package pruebaClases;

public class Ropa extends Producto {
	private String tipo;
	
	public Ropa(String nombre, String descripcion, String precio, String marca, String tipo) {
		super(nombre, descripcion, precio, marca);
		this.tipo = tipo;
	}
	
	public void mostrarRopa() {
		System.out.println("Tipo de ropa: " + tipo);
	}
}
