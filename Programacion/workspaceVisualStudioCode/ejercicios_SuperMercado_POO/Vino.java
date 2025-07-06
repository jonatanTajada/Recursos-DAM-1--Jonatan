package ejercicios_SuperMercado_POO;

public class Vino extends Producto implements EsLiquido, ConDescuento {

    // atributos
    private double volumen;
    private String tipoVino;
    private double gradosAlcohol;
    private double descuento;
    private String tipoEnvase; // Nuevo atributo para el tipo de envase


    // constructor
    public Vino(String marca, double precio, String tipoVino, double gradosAlcohol) {
        super(marca, precio);
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
    }

    // setters and gettes
    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        this.gradosAlcohol = gradosAlcohol;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

   
    // metodos de interface/s

    @Override
    public void setTipoEnvase(String env) {
        this.tipoEnvase = env;
    }

    @Override
    public String getTipoEnvase() {
        return tipoEnvase;
    }


    public double getPrecioDescuento() {
        return precio - (precio * descuento / 100);
    }

    public int getCalorias() {
        return (int) (gradosAlcohol * 10);
    }



    // toString
    @Override
    public String toString() {
        return "-Vino: \n" + super.toString() + "\nVolumen: " +
                this.volumen + "\nTipo de vino: " + this.tipoVino + "\nGrados en alcohol: " + this.gradosAlcohol +
                "\nDescuento: " + this.descuento + "\nTipo de envase: " + this.tipoEnvase;
    }

}
