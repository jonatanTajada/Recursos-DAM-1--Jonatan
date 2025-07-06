package ejercicio2_SalaCine;

import java.util.Random;

public class Cine {

    // atributos
    private Pelicula peliculaActual;
    private double preciosEntrada;
    private Asiento[][] asientos;

    // constructor
    public Cine(Pelicula peliculaActual, double precioEntrada, int filas, int columnas) {
        this.peliculaActual = peliculaActual;
        this.preciosEntrada = precioEntrada;
        this.asientos = new Asiento[filas][columnas];
        // Inicializar los asientos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.asientos[i][j] = new Asiento(i + 1, (char) ('A' + j));
            }
        }
    }

    // setters ands getters
    public Pelicula getPeliculaActual() {
        return peliculaActual;
    }

    public double getPreciosEntrada() {
        return preciosEntrada;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setPeliculaActual(Pelicula peliculaActual) {
        this.peliculaActual = peliculaActual;
    }

    public void setPreciosEntrada(double preciosEntrada) {
        this.preciosEntrada = preciosEntrada;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public boolean hayEspacioLibre() {
        for (Asiento[] fila : asientos) {
            for (Asiento asiento : fila) {
                if (!asiento.isOcupado()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Asiento buscarAsientoLibre() {
        Random random = new Random();
        while (true) {
            int fila = random.nextInt(asientos.length);
            int columna = random.nextInt(asientos[0].length);
            if (!asientos[fila][columna].isOcupado()) {
                return asientos[fila][columna];
            }
        }
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cine:\n");
        sb.append("Película actual: ").append(peliculaActual.getTitulo()).append("\n");
        sb.append("Precio de la entrada: ").append(String.format("%.2f", preciosEntrada)).append("€\n"); 
        sb.append("Asientos:\n");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                Asiento asiento = asientos[i][j];
                sb.append(asiento.getFila()).append(asiento.getColumna()).append(": ");
                if (asiento.isOcupado()) {
                    sb.append("Ocupado por ").append(asiento.getEspectadorActual().getNombre()).append("\n");
                } else {
                    sb.append("Libre\n");
                }
            }
        }
        return sb.toString();
    }

}
