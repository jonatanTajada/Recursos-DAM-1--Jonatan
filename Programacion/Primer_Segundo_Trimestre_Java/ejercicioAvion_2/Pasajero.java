package ejercicioAvion_2;

public class Pasajero {

	
	//Atributos
	private String nombrePasajero;
	private int numeroAsientoPasajero;
	private boolean haPerdidoTarjetaEmbarque;
	private boolean haEmbarcado;
	
	
	
	//Constructor
	public Pasajero(String nombrePasajero, int numeroAsientoPasajero) {
		this.nombrePasajero=nombrePasajero;
		this.numeroAsientoPasajero=numeroAsientoPasajero;
		this.haPerdidoTarjetaEmbarque= false;
		this.haEmbarcado = false;
	}

	//setters and getters
	
	public String getNombrePasajero() {
		return nombrePasajero;
	}

	public void setNombrePasajero(String nombrePasajero) {
		this.nombrePasajero = nombrePasajero;
	}

	public int getNumeroAsientoPasajero() {
		return numeroAsientoPasajero;
	}

	public void setNumeroAsientoPasajero(int numeroAsientoPasajero) {
		this.numeroAsientoPasajero = numeroAsientoPasajero;
	}

	public boolean isHaPerdidoTarjetaEmbarque() {
		return haPerdidoTarjetaEmbarque;
	}

	public void setHaPerdidoTarjetaEmbarque(boolean haPerdidoTarjetaEmbarque) {
		this.haPerdidoTarjetaEmbarque = haPerdidoTarjetaEmbarque;
	}
	
	public boolean isHaEmbarcado() {
		return this.haEmbarcado;
	}
	
	public void setHaEmbarcado(boolean haEmbarcado) {
		this.haEmbarcado = haEmbarcado;
	}

	
	@Override
	public String toString() {
		return "-Datos del pasajero:\nNombre pasajero: " + this.nombrePasajero + "\nNumero asiento pasajero: " + this.numeroAsientoPasajero
				+"\nTarjeta de embarque perdida: " + this.haPerdidoTarjetaEmbarque + "\nPasajero a bordo: " + this.haEmbarcado;
	}

	
	
	
	
	
}
