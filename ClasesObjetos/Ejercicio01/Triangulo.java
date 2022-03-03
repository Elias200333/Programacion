package Ejercicio01;

public class Triangulo {
	private double b, y, j, h;
	
	public Triangulo() {
		b = 2;
		y = 2;
		j = 2;
		h = 2;
	}
	
	public Triangulo(double b, double y, double j, double h) {
		this.b = b;
		this.h = h;
		this.y = y;
		this.j = j;
	}
	
	public double perimetro() {
		double perimetro = 0;
		
		perimetro = b + y + j;
		
		return perimetro;
	}
	
	public double area() {
		double area = 0;
		
		area = b*h/2;
		
		return area;
	}
}
