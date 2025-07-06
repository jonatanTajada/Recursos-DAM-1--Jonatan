package ejercicioZoologico2;

public class Trabajador {

	//Atributos
	private String id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String especialidad;
	private String dni;
	
	public Trabajador(String id, String nombre, String apellido1, String apellido2, String especialidad, String dni) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.especialidad = especialidad;
		this.dni = dni;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Trabajador [id= " + id + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", especialidad=" + especialidad + ", dni=" + dni + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
