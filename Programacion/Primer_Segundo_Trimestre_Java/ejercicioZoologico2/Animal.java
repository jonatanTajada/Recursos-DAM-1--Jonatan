package ejercicioZoologico2;

public class Animal {

	//Atributos
	private String id;
	private String nombre;
	private String especie;
	private int anioNacimiento;
	
	
	
	public Animal(String id, String nombre, String especie, int anioNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.anioNacimiento = anioNacimiento;
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



	public String getEspecie() {
		return especie;
	}



	public void setEspecie(String especie) {
		this.especie = especie;
	}



	public int getAnioNacimiento() {
		return anioNacimiento;
	}



	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}



	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", anioNacimiento=" + anioNacimiento
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
