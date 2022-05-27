package examen3;

public class Recursividad1 {
    public static void main(String[] args) {
        MySQLAccessPrueba baseDeDatos = new MySQLAccessPrueba();

        System.out.println(esPalindromo("halah"));

        System.out.println(sumarNaturales(10));
    }

    public static boolean esPalindromo(String palabra){
        if (palabra.equals(invertir(palabra, 0))){
            return true;
        }else{
            return false;
        }
    }

    public static String invertir(String palabra, int minimo){
        if (minimo < palabra.length()){
            return invertir(palabra, minimo + 1)+palabra.substring(minimo, minimo +1);
        }else {
            return "";
        }
    }

    public static int sumarNaturales(int n){
        if (n > 0){
            return sumarNaturales(n-1)+n;
        }else {
            return 0;
        }
    }

    public static int potenciaNumero(int base, int exponente){
        if (exponente > 0){
            return sumarNaturales(n-1)+n;
        }else {
            return 0;
        }
    }

    public static
}
