package ejercicioHotel;

public class Cliente {

	//Atributos
	protected String dni;
	protected String nombre;
	protected String direccion;
	protected String telefono;
	
	//Constructor
	public Cliente(String nombre, String direccion, String telefono, String dni) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.telefono=telefono;
	}

	//setters and getters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//toString
	@Override
	public String toString() {
		return "\nDni: " + this.dni + "\nNombre: " + this.nombre + "\nDireccion: " + this.direccion + "\nTelefono: " + this.telefono;
	}
	
	

	
	
	
	
}
