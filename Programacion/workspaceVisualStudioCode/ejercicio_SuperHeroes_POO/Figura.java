public class Figura {

    // atributos
    private String codigo;
    private double precio;
    private SuperHeroe superHeroe;
    private Dimension dimensiones;

    // constructor
    public Figura(String codigo, double precio, SuperHeroe superHeroe, Dimension dimensiones) {
        this.codigo = codigo;
        this.precio = precio;
        this.superHeroe = superHeroe;
        this.dimensiones = dimensiones;
    }

    // setters and getters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public SuperHeroe getSuperHeroe() {
        return superHeroe;
    }

    public void setSuperHeroe(SuperHeroe superHeroe) {
        this.superHeroe = superHeroe;
    }

    public Dimension getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(Dimension dimensiones) {
        this.dimensiones = dimensiones;
    }

    // metodo subir precio
    public void subirPrecio(double cantidad) {
        precio += cantidad;
    }

    // metodo toString
    @Override
    public String toString() {
        return "-- Figura -- : " + "\nCodigo: " + this.codigo + "\nPrecio: " + this.precio + "\nSuperHeroe: "
                + superHeroe.toString()
                + "\nDimensiones: " + dimensiones.toString();
    }

}
