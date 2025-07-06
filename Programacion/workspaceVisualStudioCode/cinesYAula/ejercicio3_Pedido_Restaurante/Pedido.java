package ejercicio3_Pedido_Restaurante;

public class Pedido {
    
    //atributos
    private Plato primerPlato;
    private Plato segundoPlato;
    private Bebida bebida;
    private Postre postre;

    // Constructores
    public Pedido(Plato primerPlato) {
        this.primerPlato = primerPlato;
    }

    public Pedido(Plato primerPlato, Plato segundoPlato) {
        this.primerPlato = primerPlato;
        this.segundoPlato = segundoPlato;
    }

    public Pedido(Plato primerPlato, Plato segundoPlato, Bebida bebida) {
        this.primerPlato = primerPlato;
        this.segundoPlato = segundoPlato;
        this.bebida = bebida;
    }

    public Pedido(Plato primerPlato, Plato segundoPlato, Bebida bebida, Postre postre) {
        this.primerPlato = primerPlato;
        this.segundoPlato = segundoPlato;
        this.bebida = bebida;
        this.postre = postre;
    }


    public Pedido(Postre postre2) {
        //TODO Auto-generated constructor stub
    }

    public Pedido(Bebida bebida1) {
        //TODO Auto-generated constructor stub
    }

    public Pedido(Plato primerPlato2, Bebida bebida1) {
        //TODO Auto-generated constructor stub
    }

    // Getters y Setters
    public Plato getPrimerPlato() {
        return primerPlato;
    }

    public void setPrimerPlato(Plato primerPlato) {
        this.primerPlato = primerPlato;
    }

    public Plato getSegundoPlato() {
        return segundoPlato;
    }

    public void setSegundoPlato(Plato segundoPlato) {
        this.segundoPlato = segundoPlato;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Postre getPostre() {
        return postre;
    }

    public void setPostre(Postre postre) {
        this.postre = postre;
    }


     // Metodos para calcular el valor del pedido
     public double calcularValor() {
        double valorTotal = 0;
        if (primerPlato != null) {
            valorTotal += primerPlato.getValor();
        }
        if (segundoPlato != null) {
            valorTotal += segundoPlato.getValor();
        }
        if (bebida != null) {
            valorTotal += bebida.getValor();
        }
        if (postre != null) {
            valorTotal += postre.getValor();
        }
        return valorTotal;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        if (primerPlato != null) {
            sb.append("Primer Plato: ").append(primerPlato.toString()).append("\n");
        }
        if (segundoPlato != null) {
            sb.append("Segundo Plato: ").append(segundoPlato.toString()).append("\n");
        }
        if (bebida != null) {
            sb.append("Bebida: ").append(bebida.toString()).append("\n");
        }
        if (postre != null) {
            sb.append("Postre: ").append(postre.toString()).append("\n");
        }
        sb.append("Valor Total: ").append(calcularValor() + "€");
        return sb.toString();
    }





















}
