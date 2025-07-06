package ejerciciosDePractica_POO;

public abstract class Empleado {

	//Atributos
	private String nombre;
	private int id;
	
	//Constructor
	
	public Empleado(String nombre, int id) {
		this.nombre=nombre;
		this.id=id;
	}
	
	//Setters and getters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	//Metodos
	
	public abstract double calcularSalario();
	
	@Override
	public String toString() {
		return "\n***Empleado***" + "\nNombre: " + nombre + "\nId: " + id ;
	}
	
	
	
	
}
