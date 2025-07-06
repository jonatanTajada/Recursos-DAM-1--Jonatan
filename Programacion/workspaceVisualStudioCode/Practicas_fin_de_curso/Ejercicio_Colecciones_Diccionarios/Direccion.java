package Practicas_fin_de_curso.Ejercicio_Colecciones_Diccionarios;

public class Direccion {

    // atributos
    private String calle;
    private int cp;
    private String provincia;

    // constructor
    public Direccion(String calle, int cp, String provincia) throws IllegalArgumentException {
        if (calle == null || calle.isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar vacia.");
        }
        this.calle = calle;

        if (cp >= 0 && cp <= 99999) {
            this.cp = cp;
        } else {
            throw new IllegalArgumentException("El codigo postal debe estar entre 0 y 99999.");
        }

        if (provincia == null || provincia.isEmpty()) {
            throw new IllegalArgumentException("La provincia no puede estar vacia.");
        }
        this.provincia = provincia;
    }

    // setters and getters
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    // toString
    @Override
    public String toString() {
        return "\nCalle: " + this.calle + "\nCodigo postal: " + this.cp + "\nProvincia: " + this.provincia;
    }

}
