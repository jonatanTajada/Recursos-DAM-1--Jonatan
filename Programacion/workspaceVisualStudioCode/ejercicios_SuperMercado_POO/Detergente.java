package ejercicios_SuperMercado_POO;

public class Detergente extends Producto implements EsLiquido, ConDescuento {

    // atributos
    private double volumen;
    private String tipoEnvase;
    private double descuento;

    // constructor
    public Detergente(String marca, double precio, double volumen, String tipoEnvase, double descuento) {
        super(marca, precio);
        this.volumen = volumen;
        this.tipoEnvase = tipoEnvase;
        this.descuento = descuento;

    }

    // setters and getters
    public void setVolumen(double v) {
        this.volumen = v;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setTipoEnvase(String env) {
        this.tipoEnvase = env;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setDescuento(double des) {
        this.descuento = des;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getPrecioDescuento() {
        return precio - (precio * descuento / 100);
    }

    // tostring
    @Override
    public String toString() {
        return "-Detergente: \n" + super.toString() + "\nVolumen: " + this.volumen +
                "\nTipo envase: " + this.tipoEnvase + "\nDescuento: " + this.descuento;

    }
}
