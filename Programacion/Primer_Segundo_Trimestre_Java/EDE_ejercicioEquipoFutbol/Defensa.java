package EDE_ejercicioEquipoFutbol;

public class Defensa extends Jugador {
	
    public Defensa(String nombre, String apellidos, int edad, boolean titular) {
        super(nombre, apellidos, edad, titular);
    }

	@Override
	public String toString() {
		return "Defensa [isTitular()=" + isTitular() + ", toString()=" + super.toString() + ", getNombre()="
				+ getNombre() + ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
    
    
}
