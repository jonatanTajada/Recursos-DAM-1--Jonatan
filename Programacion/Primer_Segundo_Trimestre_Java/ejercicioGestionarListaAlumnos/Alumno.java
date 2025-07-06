package ejercicioGestionarListaAlumnos;

import java.util.Objects;

public class Alumno {

	//Atributos
	private String nombre, direccion, telefono,dni;

	
	//Constructor
	public Alumno(String nombre, String direccion, String telefono, String dni) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	//Setters and Getters
	
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}
	
	//toString
	public String toString() {
		return "\n*** Datos del alumno: ***" + "\nNombre: " + nombre + "\nDireccion: " + direccion 
				+ "\nTelefono: " + telefono + "\nDNI: " +dni ;
	}

	 @Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Alumno alumno = (Alumno) o;
			return dni.equals(alumno.dni);
		}
	
	
	 @Override
	    public int hashCode() {
	        return Objects.hash(dni);
	    }
	
}
