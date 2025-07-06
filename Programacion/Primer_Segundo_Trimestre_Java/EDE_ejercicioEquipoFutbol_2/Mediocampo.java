package EDE_ejercicioEquipoFutbol_2;

public class Mediocampo extends Jugador {

	// atributos
	private int numeroAsistencias;

	// constructor
	public Mediocampo(String nombre, String apellidos, int edad, boolean esTitular, int numeroAsistencias) {
		super(nombre, apellidos, edad, esTitular);
		this.numeroAsistencias = numeroAsistencias;
	}

	//getters ands setters
	public int getNumeroAsistencias() {
		return numeroAsistencias;
	}

	public void setNumeroAsistencias(int numeroAsistencias) {
		this.numeroAsistencias = numeroAsistencias;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + "\nNumero de asistencias: " + this.numeroAsistencias;
	}

}
