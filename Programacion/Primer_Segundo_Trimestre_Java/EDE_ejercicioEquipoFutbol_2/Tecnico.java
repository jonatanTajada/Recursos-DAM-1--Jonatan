package EDE_ejercicioEquipoFutbol_2;

public class Tecnico extends Persona{


	//atributos
	private int aniosExperiencia;
	private boolean esNacional;
	
	//constructor
	public Tecnico(String nombre, String apellidos, int edad, int aniosExperiencia, boolean esNacional) {
		super(nombre, apellidos, edad);
		this.aniosExperiencia=aniosExperiencia;
		this.esNacional=esNacional;
	}
	
	
	
	//getters and setters
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public boolean isEsNacional() {
		return esNacional;
	}

	public void setEsNacional(boolean esNacional) {
		this.esNacional = esNacional;
	}


	//toString
	public String toString() {
		return super.toString() + "\nAños de experiencia como entrenador: " + this.aniosExperiencia 
								+ "\nEntrenador nacional: " + this.esNacional; 
	}
	
	
	
	
	
	
	
	

}
