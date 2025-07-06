package EDE_ejercicioEquipoFutbol_2;

public class Portero extends Jugador {

	// atributos
	private int golesRecibidos;

	public Portero(String nombre, String apellidos, int edad, boolean esTitular, int golesRecibidos) {
		super(nombre, apellidos, edad, esTitular);
		this.golesRecibidos = golesRecibidos;
	}

	public int getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + "\nGoles recibidos: " + this.golesRecibidos;
	}

}
