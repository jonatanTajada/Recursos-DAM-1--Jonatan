package ejercicioSerVivoConHashCode;

import java.util.Objects;

public class Humano extends SerVivo {

	
	//Atributos
	private String nombre;
	
	//Constructor
	public Humano(byte edad, String nombre) {
		super(edad);
		this.nombre=nombre;
	}

	//getters/setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nombre);
		return result;
	}

	//equals
	public boolean equals(Humano otro) {
		if (this == otro)
			return true;
		if (otro == null || getClass() != otro.getClass())
			return false;
		Humano other =  otro;
		return super.equals(otro) && Objects.equals(nombre, other.nombre);
	}



	//  comparar dos objetos de tipo SerVivo y devuelve el mayor - Humano .-
	@Override
	public SerVivo mayor(SerVivo otro) {
	    if (otro instanceof Humano) {
	        Humano otroHumano = (Humano) otro;
	        int comparacionNombres = this.nombre.compareTo(otroHumano.getNombre());

	        if (comparacionNombres > 0 || (comparacionNombres == 0 && this.getEdad() > otroHumano.getEdad())) {
	            return this;
	        } else {
	            return otroHumano;
	        }
	    } else {
	        return this;
	    }
	}



	@Override
	public String toString() {
	    return "\n-Datos de Humano: \nNombre: " + nombre + "\nEdad: " + super.getEdad()  ;
	}

	
	
	
	
	
	
	
}
