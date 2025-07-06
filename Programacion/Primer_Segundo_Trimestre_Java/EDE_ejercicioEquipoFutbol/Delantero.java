package EDE_ejercicioEquipoFutbol;

public class Delantero extends Jugador {
    private int golesAnotados;

    public Delantero(String nombre, String apellidos, int edad, boolean titular, int golesAnotados) {
        super(nombre, apellidos, edad, titular);
        this.golesAnotados = golesAnotados;
    }

	public int getGolesAnotados() {
		return golesAnotados;
	}

	public void setGolesAnotados(int golesAnotados) {
		this.golesAnotados = golesAnotados;
	}

	@Override
	public String toString() {
		return "Delantero [golesAnotados=" + golesAnotados + ", getGolesAnotados()=" + getGolesAnotados()
				+ ", isTitular()=" + isTitular() + ", toString()=" + super.toString() + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
    
    
    
}
