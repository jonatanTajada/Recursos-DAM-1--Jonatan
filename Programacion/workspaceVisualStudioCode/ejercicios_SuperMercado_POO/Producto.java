package ejercicios_SuperMercado_POO;

public  class Producto {

    // atributos
    protected String marca;
    protected double precio;

    // constrcutor
    public Producto(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    // toString
   @Override
   public String toString() {
       return "\nMarca: " + this.marca + "\nPrecio: " + this.precio;
   }
}
