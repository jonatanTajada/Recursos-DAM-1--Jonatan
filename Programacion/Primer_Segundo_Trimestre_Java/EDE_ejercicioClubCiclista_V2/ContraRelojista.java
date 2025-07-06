package EDE_ejercicioClubCiclista_V2;

public class ContraRelojista extends Ciclista{

	//Atributos
	private double velocidadMaxima;

	
	//Constructores
	public ContraRelojista() {}

	public ContraRelojista(int id, String nombre, int tiempo, double velocidadMaxima) {
		super(id, nombre, tiempo);
		this.velocidadMaxima=velocidadMaxima;
	}
	
	
	//setters and getterss
	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	
	@Override
	public String imprimirTipo() {
		
		return "Ciclista de tipo: ContraRelojista ";
	}
	
	@Override
	public void imprimirDatos() {
		super.imprimirDatos();
		System.out.println("Velocidad maxima alcanzada: " + this.velocidadMaxima + " km/h.");
	}
	
	
	
	
}
