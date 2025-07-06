package ejercicioHotel;

public class HabitacionSuite extends Habitacion{

	//Atributos
	private boolean tieneBanera;
	private boolean tieneSauna;
	private boolean tieneMirador;
	
	public HabitacionSuite(int numero, double precio, String tipo, String foto, boolean tieneBanera, boolean tieneSauna,
																									   boolean tieneMirador) {
		super(numero, precio, tipo, foto);
		this.tieneBanera=tieneBanera;
		this.tieneSauna=tieneSauna;
		this.tieneMirador=tieneMirador;
	}

	
	//setters and getters
	public boolean isTieneBanera() {
		return tieneBanera;
	}

	public void setTieneBanera(boolean tieneBanera) {
		this.tieneBanera = tieneBanera;
	}

	public boolean isTieneSauna() {
		return tieneSauna;
	}

	public void setTieneSauna(boolean tieneSauna) {
		this.tieneSauna = tieneSauna;
	}

	public boolean isTieneMirador() {
		return tieneMirador;
	}

	public void setTieneMirador(boolean tieneMirador) {
		this.tieneMirador = tieneMirador;
	}

	
	public String toString() {
		return "\n-Datos de la habitacion suite: " + super.toString() + "\nHabitacion con bañera: "  + tieneBanera + 
				"\nHabitacion con sauna: " + tieneSauna + "\nHabitacion con mirador: " + tieneMirador;
	} 
	
	
}
