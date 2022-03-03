package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		Cuenta jose = new Cuenta("Jose", 2000);
		
		System.out.println(jose.toString());
		
		jose.ingresar(1000);
		
		System.out.println(jose.toString());
		
		jose.retirar(200);
		
		System.out.println(jose.toString());
		
		jose.setTitular("Carlos");
		
		System.out.println(jose.toString());
	}
}
