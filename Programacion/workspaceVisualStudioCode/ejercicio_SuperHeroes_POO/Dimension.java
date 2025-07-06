public class Dimension {

    // atributos
    private double alto;
    private double ancho;
    private double profundidad;

    // constructores
    public Dimension() {
        this.alto = 0;
        this.ancho = 0;
        this.profundidad = 0;
    }

    public Dimension(double alto, double ancho, double profundidad) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    // setters and getters
    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    // metodo que calcula el volumen del objeto
    public double getVolumen() {
        return this.alto * this.ancho * this.profundidad;
    }

    // toString

    @Override
    public String toString() {
        return "\nAlto: " + this.alto + "\nAncho: " + this.ancho + "\nProfundidad: "
                + this.profundidad
                + "\nVolumen: " + this.getVolumen();
    }

}


