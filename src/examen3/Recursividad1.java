package examen3;

public class Recursividad1 {
    public static void main(String[] args) {
        MySQLAccessPrueba baseDeDatos = new MySQLAccessPrueba();

        System.out.println(esPalindromo("halah"));

        System.out.println(sumarNaturales(10));

        System.out.println(potenciaNumero(5, 4));
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

    public static double potenciaNumero(double base, int exponente){
        if (exponente > 0){
            return potenciaPos(base, Math.abs(exponente));
        }else if (exponente < 0){
            return potenciaNeg(base, Math.abs(exponente));
        }else {
            return 1;
        }
    }

    private static double potenciaPos(double base, int exponente){
        if(exponente > 1){
            double nBase = potenciaPos(base, exponente - 1);
            return nBase * base;
        }else{
            return base;
        }
    }

    private static double potenciaNeg(double base, int exponente){
        if(exponente > -1){
            double nBase = potenciaNeg(base, exponente - 1);
            return nBase / base;
        }else{
            return base;
        }
    }
}
