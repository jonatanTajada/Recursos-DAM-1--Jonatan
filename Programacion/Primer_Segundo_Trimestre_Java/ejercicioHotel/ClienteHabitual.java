package ejercicioHotel;

public class ClienteHabitual extends Cliente {

	//Atributos
	private double descuento;
	
	//Constructor
	public ClienteHabitual(String dni, String nombre, String direccion, String telefono, double descuento) {
		super(dni, nombre, direccion, telefono);
		this.descuento=descuento;
	}

	//setters ands getters
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	//toString
	
	public String toString() {
		return "\n-Datos del cliente habitual: \n" + super.toString() + "\nDescuento: " + descuento + "€.";
	}
	
	
	
}
