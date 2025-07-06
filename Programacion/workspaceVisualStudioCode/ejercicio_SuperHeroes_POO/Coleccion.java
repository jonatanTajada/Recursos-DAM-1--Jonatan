import java.util.ArrayList;

public class Coleccion {

    // atributos
    private String nombreColeccion;
    private ArrayList<Figura> listaFiguras;

    // constructor
    public Coleccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
        this.listaFiguras = new ArrayList<Figura>();
    }

    // setters and getters
    public String getNombreColeccion() {
        return nombreColeccion;
    }

    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }

    public ArrayList<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(ArrayList<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    // metodo añadir figura
    public void aniadirFigura(Figura fig) {
        listaFiguras.add(fig);
    }

    // metodo subir precio
    public void subirPrecio(double cantidad, String id) {

        if (cantidad <= 0) {
            System.err.println("La cantidad ingresada para subir precio debe ser mayor a cero!");
        }

        if (listaFiguras.isEmpty()) {
            System.out.println("La lista de figuras está vacía.");
            return;
        }

        for (Figura figura : listaFiguras) {
            if (figura.getCodigo().equals(id)) {
                figura.subirPrecio(cantidad);
                return;
            }
        }
        System.err.println("No se encontro una figura con el ID especificado: " + id);
    }

    // metodo si una figura tiene o no capa
    public String conCapa() {

        String resultado = "Figuras con capa en la coleccion: " + nombreColeccion + ": \n";

        for (Figura figura : listaFiguras) {
            if (figura.getSuperHeroe().isTieneCapa()) {
                resultado += figura.toString() + "\n";
            }
        }
        return resultado;
    }

    // metodo devuelve la figura mas valiosa '€'
    public Figura masValioso() {
        Figura figuraMasValiosa = listaFiguras.get(0);
        for (Figura figura : listaFiguras) {
            if (figura.getPrecio() > figuraMasValiosa.getPrecio()) {
                figuraMasValiosa = figura;
            }
        }
        return figuraMasValiosa;
    }

    // metodo para sumar importe total de listaFiguras
    public double getValorColeccion() {
        double valorTotal = 0;
        for (Figura figura : listaFiguras) {
            valorTotal += figura.getPrecio();
        }
        return valorTotal;
    }

    // metodo devuelve el volumen que ocupa toda la collecion de figuras
    public double getVolumenColeccion() {
        double volumenTotal = 0;
        for (Figura figura : listaFiguras) {
            volumenTotal += figura.getDimensiones().getVolumen();
        }
        return volumenTotal + 200;
    }

    // toString

    public String toString() {
        String resultado = "Coleccion: " + nombreColeccion + "\n";
        for (Figura figura : listaFiguras) {
            resultado += figura.toString() + "\n";
        }
        return resultado;
    }

}
