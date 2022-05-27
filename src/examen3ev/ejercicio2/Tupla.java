package examen3ev.ejercicio2;

public class Tupla {
    private String nombre;
    private boolean separacionPrevia;
    private String ano;
    private int total;

    public Tupla() {
    }

    public Tupla(String nombre, boolean separacionPrevia, String ano, int total) {
        this.nombre = nombre;
        this.separacionPrevia = separacionPrevia;
        this.ano = ano;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSeparacionPrevia() {
        return separacionPrevia;
    }

    public void setSeparacionPrevia(boolean separacionPrevia) {
        this.separacionPrevia = separacionPrevia;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
