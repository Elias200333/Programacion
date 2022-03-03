package herencia;

public class Funcionario implements FichaSalarial {
    private double trienios;
    private double sueldoBase;
    private double horasExtra;
    private double peligrosidad;

    public Funcionario(double trienios, double sueldoBase, double horasExtra, double peligrosidad) {
        this.trienios = trienios;
        this.sueldoBase = sueldoBase;
        this.horasExtra = horasExtra;
        this.peligrosidad = peligrosidad;
    }

    public double getTrienios() {
        return trienios;
    }

    public void setTrienios(double trienios) {
        this.trienios = trienios;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(double peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

    @Override
    public void calcularSueldo() {
        System.out.println("El sueldo final de un Funcionario es: " +
                (trienios + sueldoBase + horasExtra + peligrosidad));
    }

    @Override
    public double pagasExtra() {
        return horasExtra;
    }
}
