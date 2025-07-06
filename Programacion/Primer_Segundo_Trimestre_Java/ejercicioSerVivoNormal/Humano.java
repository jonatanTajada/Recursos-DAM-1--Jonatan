package ejercicioSerVivoNormal;

public class Humano extends SerVivo {

	
	//Atributos
	
	private String nombre;
	
	//Constructor
	public Humano(byte edad, String nombre) {
		super(edad);
		this.nombre=nombre;
	}

	//getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// metodo equals - misma edad y mismo nombre
	
	public boolean equals(Humano otro) {
		if (this.getEdad() == otro.getEdad() && this.nombre.equalsIgnoreCase(otro.getNombre())) {
			return true;
		}else {
			return false;
		}
	}
	
	// metodo mayor - el nombre +largo y edad . -
	public SerVivo mayor(Humano otro) {
		if (this.nombre.length() > otro.getNombre().length() && this.getEdad() > otro.getEdad()) {
			return this;
		}else {
			return otro;
		}
	}
	
	
	@Override
	public String toString() {
		return "-Datos del humano:\nNombre: " + this.nombre + "\nEdad: " + super.getEdad();
	}
	
	
	

}
