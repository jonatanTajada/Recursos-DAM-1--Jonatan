package EDE_ejercicioClubCiclista_V2;

//clase padre
public abstract class Ciclista {


	//Atributos
	private int id;
	private String nombre;
	private int tiempo;
	
	//Constructor
	public Ciclista()  {}
	
	public Ciclista(int id, String nombre, int tiempo) {
		this.id=id;
		this.nombre=nombre;
		this.tiempo=tiempo;
	}
	
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	//metodo abstracto
	public abstract String imprimirTipo();
	
	
	//metodo imprimir datos
	public void imprimirDatos() {
		System.err.println("Id: " + this.id + "\nNombre: " + this.nombre + "\nTiempo: " + this.tiempo +" minutos");
	}
	
	
	
}
