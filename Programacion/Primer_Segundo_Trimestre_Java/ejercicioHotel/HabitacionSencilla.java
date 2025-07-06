package ejercicioHotel;

public class HabitacionSencilla extends Habitacion{

	//Atributos
	private boolean exterior;
	
	
	//Constructor
	public HabitacionSencilla(int numero, double precio, String tipo, String foto, boolean exterior) {
		super(numero, precio, tipo, foto);
		this.exterior=exterior;
	}


	public boolean isExterior() {
		return exterior;
	}


	public void setExterior(boolean exterior) {
		this.exterior = exterior;
	}
	
	
	
	public String toString() {
		return "\n-Datos de la habitacion sencilla: " + super.toString() + "\nHabitacion exterior: "  + exterior;
	}
	
	
	
}
