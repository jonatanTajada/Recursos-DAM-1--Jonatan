package EDE_ejercicioEquipoFutbol;

public class Jugador extends Persona {
    private boolean titular;

    public Jugador(String nombre, String apellidos, int edad, boolean titular) {
        super(nombre, apellidos, edad);
        this.titular = titular;
    }

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}

	@Override
	public String toString() {
		return "Jugador [titular=" + titular + ", isTitular()=" + isTitular() + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
    
}

