package EDE_ejercicioClubCiclista_V2;

public class Velocista extends Ciclista{


	//Atributos
	private double potencia;
	private double velocidad;
	
	//Constructor
	public Velocista(int id, String nombre, int tiempo, double potencia, double velocidad) {
		super(id, nombre, tiempo);
		this.potencia=potencia;
		this.velocidad=velocidad;
	}

	public Velocista() {}
	
	
	//getters and setters
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
	
	
	@Override
	public String imprimirTipo() {
		
		return "Ciclista de tipo: Velocista";
	}
	
	@Override
	public void imprimirDatos() {
		super.imprimirDatos();
		System.out.println("Potencia: " + this.potencia + " vatios." + "\nVelocidad: " + this.velocidad + " km/h.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
