package EDE_ejercicioEquipoFutbol_2;

public class Jugador extends Persona {

	// atributos
	private boolean esTitular;

	// Constructor
	public Jugador(String nombre, String apellidos, int edad, boolean esTitular) {
		super(nombre, apellidos, edad);
		this.esTitular = true;
	}

	// setters and setters
	public boolean isEsTitular() {
		return esTitular;
	}

	public void setEsTitular(boolean esTitular) {
		this.esTitular = esTitular;
	}

	//toString
	@Override
	public String toString() {
		return super.toString() + "\nJugador titular: " + this.esTitular;

	}

}
