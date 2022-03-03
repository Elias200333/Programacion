package examen;

public class Jugador {
    private String nombre;

    private int dorsal;
    private int lvlPotencia;
    private int lvlPorteria;
    private int vidas = 2;

    public Jugador(String nombre, int dorsal, int lvlPotencia, int lvlPorteria){
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.lvlPotencia = lvlPotencia;
        this.lvlPorteria = lvlPorteria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getLvlPotencia() {
        return lvlPotencia;
    }

    public void setLvlPotencia(int lvlPotencia) {
        this.lvlPotencia = lvlPotencia;
    }

    public int getLvlPorteria() {
        return lvlPorteria;
    }

    public void setLvlPorteria(int lvlPorteria) {
        this.lvlPorteria = lvlPorteria;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**Pre: ---
     *
     * Post: El método habilidadDisparo devuelve una potencia calculada con
     * el lvlPotencia del jugador multiplicada aleatoriamente. Se tiene más
     * probabilidad en los disparos para evitar alargar infinitamente la partida.
     */

    public int habilidadDisparo(){
        return lvlPotencia*(int)(int)(Math.floor(Math.random()*20 + 1));
    }
    /**Pre: ---
     *
     * Post: El método habilidadPorteria devuelve una resistencia calculada con
     * el lvlPorteria del jugador multiplicada aleatoriamente. Se tiene menos
     * probabilidad en la resistencia para evitar alargar infinitamente la partida.
     */
    public int habilidadPorteria(){
        return lvlPorteria*(int)(Math.floor(Math.random()*5 + 1));
    }
}
