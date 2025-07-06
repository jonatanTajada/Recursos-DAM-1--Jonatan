package ejercicio_diferencias_entre_ArrayList_LinkedList;



public class Vehiculo {
    
//atributos
    private int idVehiculo;
    private String tipo;

    //constructor
    public Vehiculo(int idVehiculo, String tipo) {
        this.idVehiculo = idVehiculo;
        this.tipo = tipo;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //toString
    @Override
public String toString(){
    return "Id del Vehiculo: " + idVehiculo + "\nTipo de vehiculo: " + tipo;
}

}
