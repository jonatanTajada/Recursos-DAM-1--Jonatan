package EDE_ejercicioEquipoFutbol_2;

public class Persona {

	
	//atributos
	private String nombre;
	private String apellidos;
	private int edad;
	
	//constructor
	public Persona(String nombre, String apellidos, int edad) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
	}

	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	//toString
	@Override
	public String toString() {
		return "\nNombre: " + this.nombre + "\nApellidos: " + this.apellidos + "\nEdad: " + this.edad;
	}
	
	
	
	
	
	
	
	
	

}
