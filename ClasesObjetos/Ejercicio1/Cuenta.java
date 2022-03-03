package Ejercicio1;

public class Cuenta {
	private String titular;
	private double cantidad;
	
	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}
	
	public Cuenta(String titular) {
		this.titular = titular;
		this.cantidad = 0;
	}
	
	//------------------Métodos GET---------------------//
	
	public String getTitular () {
		return titular;
	}
	public double getCantidad () {
		return cantidad;
	}
	
	//------------------Métodos SET---------------------//
	
	public void setTitular (String titular) {
		this.titular = titular;
	}
	public void setCantidad (double cantidad) {
		this.cantidad = cantidad;
	}
	
	//------------------Método  VER---------------------//
	
	public void mostrarCuenta() {
		System.out.println("____________________________");
		System.out.println("Titular: "+		titular);
		System.out.println("Cantidad: "+ cantidad);
	}
	
	//------------------Método  STR---------------------//
	
	public String toString() {
		String caja = "____________________________\n"
				+ "Titular: " + titular + "\n"
				+ "Cantidad: "+ cantidad;
		return caja;
	}
	
	//---------------Métodos especiales-----------------//
	
	public void ingresar(double cantidad) {
		if (cantidad > 0) {
			this.cantidad = this.cantidad + cantidad;
		}
	}
	
	public void retirar(double cantidad) {
		if (cantidad > 0) {
			/*800*/this.cantidad = this.cantidad - cantidad;
			if (this.cantidad < 0) {
				this.cantidad = 0;
			}
		}
	}
}
