package ejercicioAvion;

public class Pasajero {

	//Atributos
	private String nombre;
	private int numeroAsiento;
	private boolean tajertaPerdida;
	
	//Constructor
	public Pasajero(String nombre, int numeroAsiento) {
		this.nombre = nombre;
		this.numeroAsiento = numeroAsiento;
		this.tajertaPerdida = false;
	}

	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroAsiento() {
		return numeroAsiento;
	}

	public void setNumeroAsiento(int numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

	public boolean isTajertaPerdida() {
		return tajertaPerdida;
	}

	public void setTajertaPerdida(boolean tajertaPerdida) {
		this.tajertaPerdida = tajertaPerdida;
	}
	
	@Override
	public String toString() {
		
		return "-Datos del cliente:\n1. Nombre: " + nombre + "\n2. Numero asiento: "+ numeroAsiento 
				+ "\n3. Tarjeta de embarque perdida: " + tajertaPerdida;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
