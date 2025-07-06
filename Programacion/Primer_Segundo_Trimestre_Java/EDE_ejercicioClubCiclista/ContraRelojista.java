package EDE_ejercicioClubCiclista;

public class ContraRelojista extends Ciclista {
	
	//Atributos
	private double velocidadMaxima;

	//Constructor
	public ContraRelojista() {
		super();
		this.velocidadMaxima = 0.0;
	}

	public ContraRelojista(int id, String nombre, double velocidadMaxima) {
		super(id, nombre);
		this.velocidadMaxima = velocidadMaxima;
	}

	// Getters and Setters
	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	// tipo ciclista
	@Override
	public String imprimirTipo() {
		return "Es un Contrarrelojista";
	}

	@Override
	public String toString() {
		return "ContraRelojista [velocidadMaxima=" + velocidadMaxima + ", getVelocidadMaxima()=" + getVelocidadMaxima()
				+ ", imprimirTipo()=" + imprimirTipo() + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getTiempo()=" + getTiempo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



}
