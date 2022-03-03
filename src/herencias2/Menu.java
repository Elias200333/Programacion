package herencias2;

import java.util.ArrayList;

public class Menu {
	public static void main (String[]args) {
		ArrayList<Vehiculo> lista1 = new ArrayList <Vehiculo>();
		
		Coche1 BMW = new Coche1(5, "rojo");
		Coche1 Mercedes = new Coche1(4,"verde");
		Coche1 Toyota = new Coche1(2, "Azul");
		Moto  SKoda = new Moto(1,"Blanco");
		Moto Yamaha = new Moto(2,"Negro");
		
		lista1.add(BMW);
		lista1.add(Mercedes);
		lista1.add(Toyota);
		lista1.add(SKoda);
		lista1.add(Yamaha);
		
		System.out.println("BMW:\n" + BMW);
		System.out.println(BMW.acelerar(100));
		System.out.println(BMW.frenar(100));
		System.out.println("\nMercedes:\n" + Mercedes);
		System.out.println(Mercedes.acelerar(200));
		System.out.println(Mercedes.frenar(30));
		System.out.println("\nToyota:\n" + Toyota);
		System.out.println(Toyota.acelerar(300));
		System.out.println(Toyota.frenar(100));
		System.out.println("\nSkoda:\n" + SKoda);
		System.out.println(SKoda.acelerar(40));
		System.out.println(SKoda.frenar(10));
		System.out.println("\nYamaha:\n" + Yamaha);
		System.out.println(Yamaha.acelerar(400));
		System.out.println(Yamaha.frenar(20));
		
		
	}

}
