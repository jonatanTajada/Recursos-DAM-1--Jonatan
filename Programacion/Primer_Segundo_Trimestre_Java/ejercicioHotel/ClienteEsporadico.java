package ejercicioHotel;

public class ClienteEsporadico extends Cliente {

	//Atributos
	private boolean recibirOfertas;
	
	
	//Constuctor
	public ClienteEsporadico(String dni, String nombre, String direccion, String telefono, boolean recibirOfertas) {
		super(dni,nombre, direccion, telefono);
		this.recibirOfertas=recibirOfertas;
	}

	//getters and setters
	public boolean isRecibirOfertas() {
		return recibirOfertas;
	}


	public void setRecibirOfertas(boolean recibirOfertas) {
		this.recibirOfertas = recibirOfertas;
	}

	//toString
	@Override
	public String toString() {
		return "\nDatos del cliente esporadico: \n" + super.toString() + "\nRecibir oferta: " + recibirOfertas;
	}

	
	
	
	
	
}
