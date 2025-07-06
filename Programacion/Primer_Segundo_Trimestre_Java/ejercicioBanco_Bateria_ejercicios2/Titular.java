package ejercicioBanco_Bateria_ejercicios2;


import java.util.*;

public class Titular {
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String dni;
	private List<CuentaCorriente> cuentas;
	
	
	public Titular(String nombre, String apellidos, String direccion, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
		 this.cuentas = new ArrayList<>();
	}


	
	
	public List<CuentaCorriente> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(CuentaCorriente cuenta) {
        cuentas.add(cuenta);
    }
	
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	@Override
	public String toString() {
		return "Titular [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni
				+ "]";
	}
	
	
	
	
	
	

}
