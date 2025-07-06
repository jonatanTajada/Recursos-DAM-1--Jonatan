package EDE_ejercicioEquipoFutbol;

public class Portero extends Jugador {
    private int golesRecibidos;

    public Portero(String nombre, String apellidos, int edad, boolean titular, int golesRecibidos) {
        super(nombre, apellidos, edad, titular);
        this.golesRecibidos = golesRecibidos;
    }

	public int getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}

	@Override
	public String toString() {
		return "Portero [golesRecibidos=" + golesRecibidos + ", getGolesRecibidos()=" + getGolesRecibidos()
				+ ", isTitular()=" + isTitular() + ", toString()=" + super.toString() + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
    
    
}
