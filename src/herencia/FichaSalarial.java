package herencia;

public interface FichaSalarial {

    /**
     * Pre:...
     * Post: calcula el sueldo utilizando los atributos
     * 		correspondientes.
     */
    public void calcularSueldo();

    /**
     * Pre:...
     * Post: devuelve un dato de tipo [double] que indica
     * 		el suelo de las pagas extra.
     */
    public double pagasExtra();
}
