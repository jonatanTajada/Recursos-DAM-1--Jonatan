package ejercicioHotel;

public class HabitacionDoble extends Habitacion{

	//Atributos
	private boolean camaMatrimonio;
	
	
	public HabitacionDoble(int numero, double precio, String tipo, String foto, boolean camaMatrimonio) {
		super(numero, precio, tipo, foto);
		this.camaMatrimonio=camaMatrimonio;
	}


	public boolean isCamaMatrimonio() {
		return camaMatrimonio;
	}


	public void setCamaMatrimonio(boolean camaMatrimonio) {
		this.camaMatrimonio = camaMatrimonio;
	}

	
	public String toString() {
		return "\n-Datos de la habitacion doble: " + super.toString() + "\nHabitacion con cama matrimonio: "  + camaMatrimonio;
	} 
	
}
