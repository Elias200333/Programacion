package pruebaClases;

public class Producto {
	private String nombre;
	private String descripcion;
	private String precio;
	private String marca;
	
	public Producto(String nombre, String descripcion, String precio, String marca) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.marca = marca;
		comprobarPrecio();
	}
	
	//------------------Métodos GET---------------------//
	
	public String getNombre () {
		return nombre;
	}
	public String getDescripcion () {
		return descripcion;
	}
	public String getPrecio () {
		return precio;
	}
	public String getMarca () {
		return marca;
	}
	
	//------------------Métodos SET---------------------//
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPrecio (String precio) {
		this.precio = precio;
	}
	public void setMarca (String marca) {
		this.marca = marca;
	}
	
	//------------------Métodos VER---------------------//
	
	public void mostrarProducto() {
		System.out.println("____________________________");
		System.out.println("Nombre: "+		nombre);
		System.out.println("Descripción: "+	descripcion);
		System.out.println("Precio: "+		precio);
		System.out.println("Marca: "+		marca);
	}
	
	public void comprobarPrecio() {
		try {
			Integer.parseInt(precio);
		} catch(NumberFormatException e){
			precio="0€";
		}
	}
}
