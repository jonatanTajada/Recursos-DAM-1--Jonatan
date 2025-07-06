package EDE_ejercicioClubCiclista;

public class Velocista extends Ciclista {
	
	//atributos
	private double potencia;
	private double velocidad;

	//Constructores
	public Velocista() {
		super();
		this.potencia = 0.0;
		this.velocidad = 0.0;
	}

	public Velocista(int id, String nombre, double potencia, double velocidad) {
		super(id, nombre);
		this.potencia = potencia;
		this.velocidad = velocidad;
	}

	// Getters and Setters

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	// toString
	@Override
	public String imprimirTipo() {
		return "Es un Velocista";
	}

	@Override
	public String toString() {
		return "Velocista [potencia=" + this.potencia + ", velocidad=" + this.velocidad + ", getPotencia()=" + getPotencia()
				+ ", getVelocidad()=" + getVelocidad() + ", imprimirTipo()=" + imprimirTipo() + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getTiempo()=" + getTiempo() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

	
}
