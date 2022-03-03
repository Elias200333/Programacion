package herencia;

public class JugadorFutbol implements FichaSalarial {
    private double sueldoPublicidad;
    private double sueldoEquipo;
    private double primasPorTrofeos;
    private String nombre;

    public JugadorFutbol(String nombre, double sueldoPublicidad, double sueldoEquipo,
                         double primasPorTrofeos) {
        this.sueldoEquipo = sueldoEquipo;
        this.sueldoPublicidad = sueldoPublicidad;
        this.primasPorTrofeos = primasPorTrofeos;
        this.nombre = nombre;
    }

    public double getSueldoPublicidad() {
        return sueldoPublicidad;
    }

    public void setSueldoPublicidad(double sueldoPublicidad) {
        this.sueldoPublicidad = sueldoPublicidad;
    }

    public double getSueldoEquipo() {
        return sueldoEquipo;
    }

    public void setSueldoEquipo(double sueldoEquipo) {
        this.sueldoEquipo = sueldoEquipo;
    }

    public double getPrimasPorTrofeos() {
        return primasPorTrofeos;
    }

    public void setPrimasPorTrofeos(double primasPorTrofeos) {
        this.primasPorTrofeos = primasPorTrofeos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void calcularSueldo() {
        System.out.println("El sueldo final de un JugadorFutbol es: " + (sueldoPublicidad +
                sueldoEquipo + primasPorTrofeos));
    }

    @Override
    public double pagasExtra() {
        return 25000;
    }

}
