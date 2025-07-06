package EDE_ejercicioEquipoFutbol_2;

public class Delantero extends Jugador{

	//atributos
	private int golesAnotados;
	
	
	public Delantero(String nombre, String apellidos, int edad, boolean esTitular, int golesAnotados) {
		super(nombre, apellidos, edad, esTitular);
		this.golesAnotados=golesAnotados;
	}


	public int getGolesAnotados() {
		return golesAnotados;
	}


	public void setGolesAnotados(int golesAnotados) {
		this.golesAnotados = golesAnotados;
	}

	//toString
	@Override
	public String toString() {
		return super.toString() + "\nGoles anotados: " + this.golesAnotados;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
