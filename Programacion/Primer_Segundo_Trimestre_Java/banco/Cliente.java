package banco;

import java.util.Date;


public class Cliente {

	//Atributos
	
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private Date altaCuenta;
	private String localidadSucursal;
	private CuentaBancaria cuentaBancaria;
	
	
	//Constructores
	
	public Cliente(String nombre, String apellidos, String fechaNacimiento, Date altaCuenta, String localidadSucursal, CuentaBancaria cuentaBancaria) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.altaCuenta=altaCuenta;
		this.localidadSucursal=localidadSucursal;
		this.cuentaBancaria=cuentaBancaria;
	}


	//setters ands getters
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


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Date getAltaCuenta() {
		return altaCuenta;
	}


	public void setAltaCuenta(Date altaCuenta) {
		this.altaCuenta = altaCuenta;
	}


	public String getLocalidadSucursal() {
		return localidadSucursal;
	}


	public void setLocalidadSucursal(String localidadSucursal) {
		this.localidadSucursal = localidadSucursal;
	}


	public CuentaBancaria getNumeroCuenta() {
		return cuentaBancaria;
	}


	public void setNumeroCuenta(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
	
	//toString
	
	public String toString() {
		return "Nombre: " + nombre + "\nApellidos: " + apellidos + "\nFecha de nacimiento: " + fechaNacimiento + "\nFecha de alta de cuenta bancaria: " + altaCuenta +
				"\nLocalidad de la sucursal: " + localidadSucursal + "\nCuenta bancari: " + cuentaBancaria;	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
