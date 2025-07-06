
public class SuperHeroe {

    // atributos
    private String nombre;
    private String descripcion;
    private boolean tieneCapa;

    // constructor
    public SuperHeroe(String nombre) {
        this.nombre = nombre;
        this.descripcion = "";
        this.tieneCapa = false;
    }

    // setters and getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isTieneCapa() {
        return tieneCapa;
    }

    public void setTieneCapa(boolean tieneCapa) {
        this.tieneCapa = tieneCapa;
    }

    // toString
    @Override
    public String toString() {
        return "\nNombre: " + this.nombre + "\nDescripcion: " + this.descripcion + "\nTiene capa: "
                + this.tieneCapa + "\n";
    }

}