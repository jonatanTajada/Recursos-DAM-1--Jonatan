package EDE_ejercicioClubCiclista;

public abstract class Ciclista {

	// Atributos
	//private static int ultimoId = 0;
	private int id;
	private String nombre;
	private int tiempo;


	// Constructores
	public Ciclista() {
		//   this.id = ++ultimoId; el otro id tendria quew borrarlo
		this.id = 0;
		this.nombre = "";
		this.tiempo = 0;
	}

	public Ciclista(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.tiempo = 0;
	}

	// Getters and Setters
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


	// Método abstracto
	public abstract String imprimirTipo();  

	// toString
	public void imprimirDatos() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Tiempo acumulado: " + this.tiempo + " minutos");
	}
}
