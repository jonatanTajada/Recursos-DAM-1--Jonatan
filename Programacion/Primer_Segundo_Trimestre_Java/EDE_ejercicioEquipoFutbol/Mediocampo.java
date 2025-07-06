package EDE_ejercicioEquipoFutbol;

public class Mediocampo extends Jugador {
    private int asistencias;

    public Mediocampo(String nombre, String apellidos, int edad, boolean titular, int asistencias) {
        super(nombre, apellidos, edad, titular);
        this.asistencias = asistencias;
    }

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	@Override
	public String toString() {
		return "Mediocampo [asistencias=" + asistencias + ", getAsistencias()=" + getAsistencias() + ", isTitular()="
				+ isTitular() + ", toString()=" + super.toString() + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}


    
    
}
