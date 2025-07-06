package ejercicioBanco_Bateria_ejercicios;

import ejercicioBanco_Bateria_ejercicios2.CuentaCorriente;

//Clase Titular
	public class Titular {
		
	private String nombre;
	private String apellidos;
	private String direccion;
	private String dni;

	// Constructor
	public Titular(String nombre, String apellidos, String direccion, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
	}

	public Titular(CuentaCorriente crearCuentaCorriente) {
		// TODO Auto-generated constructor stub
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Titular [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni
				+ "]";
	}
	
	
}
