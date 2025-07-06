package ejercicios_SuperMercado_POO;

import java.time.LocalDate;

public class Cereal extends Producto implements EsAlimento {

    // atributos

    private String tipoCereal;
    private LocalDate caducidad;

    // constructor
    public Cereal(String marca, double precio, String tipoCereal) {
        super(marca, precio);
        this.tipoCereal = tipoCereal;
    }

    // setters and getters
    public String getTipoCereal() {
        return tipoCereal;
    }

    public void setTipoCereal(String tipoCereal) {
        this.tipoCereal = tipoCereal;
    }

    // metodos interface
    public LocalDate getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(LocalDate caducidad) {
        this.caducidad = caducidad;
    }

    public int getCalorias() {
        switch (tipoCereal) {
            case "espelta":
                return 5;
            case "maíz":
                return 8;
            case "trigo":
                return 12;
            default:
                return 15;
        }
    }

    // tostring
    @Override
    public String toString() {
        return "Cereal: \n" + super.toString() + "\nTipo cereal: "
                + this.tipoCereal + "\nFecha de caducidad: " + this.caducidad;
    }

}
