package Ejercicio2;

public class Persona {
	private String nombre;
	private int edad;
	private String dni;
	private String sexo;
	private double peso;
	private double altura;
	
	//-----------------CONSTRUCTORES--------------------//
	
	public Persona() {
		this.nombre = "Anonimo";
		this.edad = 18;
		this.dni = generarDNI();
		this.sexo = "No introducido";
		this.peso = 0;
		this.altura = 0;
		comprobarSexo(this.sexo);
	}
	
	public Persona(String nombre, int edad, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = generarDNI();
		this.sexo = sexo;
		this.peso = 0;
		this.altura = 0;
		comprobarSexo(this.sexo);
	}
	
	public Persona(String nombre, int edad, String sexo, String dni, int peso, int altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		comprobarSexo(this.sexo);
	}
	
	//------------------Métodos GET---------------------//
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDNI() {
		return dni;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public int getEdad() {
		return edad;
	}
	
	//------------------Métodos SET---------------------//
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	//------------------Método  VER---------------------//
	
	public void mostrarPersona() {
		System.out.println("____________________________");
		System.out.println("Nombre: " + nombre);
		System.out.println("DNI: " + dni);
		System.out.println("Sexo: " + sexo);
		System.out.println("Edad: " + edad);
		System.out.println("Altura: " + altura);
		System.out.println("Peso: "+ peso);
	}
	
	//------------------Método  STR---------------------//
	
	public String toString() {
		String caja = 
				
				"____________________________\n"
				+ "Nombre: " + nombre + "\n"
				+ "DNI: "+ dni + "\n"
				+ "Sexo: " + sexo + "\n"
				+ "Edad: " + edad + "\n"
				+ "Altura: " + altura + "\n"
				+ "Peso: "+ peso + "\n";
		
		return caja;
	}
	
	//---------------Métodos especiales-----------------//
	
	public int calcularIMC(){
		if (peso/(altura*altura) < 20) {
			return -1;
		} else if (peso/(altura*altura) > 25) {
			return 1;
		}
		return 0;
	}
	
	public boolean esMayorDeEdad() {
		if (edad < 18) {
			return false;
		}
		return true;
	}
	
	private void comprobarSexo(String sexo) {
		if (!sexo.equals("H") || !sexo.equals("M")) {
			this.sexo = "H";
		} else {
			this.sexo = sexo;
		}
	}
	
	public String generarDNI() {
		
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		int dniNumerico = (int)Math.floor(Math.random()*100000000);
		
		int resto = dniNumerico%23;
		
		String letra = "";
		if (resto == 22) {
			letra = letras.substring(resto-1, resto);
		} else {
			letra = letras.substring(resto, resto+1);
		}
		
		String dniElegido = Integer.toString(dniNumerico)+letra;
		
		return dniElegido;
	}
}
