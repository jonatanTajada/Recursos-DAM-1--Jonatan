package ejercicio2_SalaCine;

public class Pelicula {

    // atributos
    private String titulo;
    private int duracion;
    private int edadMinima;
    private String director;

    // constructor
    public Pelicula(String titulo, int duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // toString
    @Override
    public String toString() {
        return "Pelicula: " + titulo + "\n" +
                "Duración: " + duracion + " minutos\n" +
                "Edad mínima: " + edadMinima + "\n" +
                "Director: " + director;
    }

}
