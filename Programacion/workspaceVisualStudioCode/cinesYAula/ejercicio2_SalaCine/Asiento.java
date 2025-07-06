package ejercicio2_SalaCine;

public class Asiento {

    // atributo
    private int fila;
    private char columna;
    private boolean ocupado;
    private Espectador espectadorActual;

    // constructor
    public Asiento(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
        this.ocupado = false;
        this.espectadorActual = null;
    }

    // getters and setters
    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    public Espectador getEspectadorActual() {
        return espectadorActual;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(char columna) {
        this.columna = columna;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setEspectadorActual(Espectador espectadorActual) {
        this.espectadorActual = espectadorActual;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    // metodo asignar espectador al asiento y marcarlo como ocupado
    public void ocuparAsiento(Espectador espectador) {
        this.ocupado = true;
        this.espectadorActual = espectador;
    }

    // metodo para liberar asiento
    public void liberarAsiento() {
        this.ocupado = false;
        this.espectadorActual = null;
    }

    // toString
    @Override
    public String toString() {
        if (ocupado) {
            return "Asiento " + fila + columna + ": Ocupado por " + espectadorActual.getNombre();
        } else {
            return "Asiento " + fila + columna + ": Libre";
        }
    }
}
