package EjercicioBanco2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {

	//atributos
	
	private String nombre;
	private String apellidos;
	private String fecha_nacimiento;
	private Date altaCuenta;
	private String localidadSucursal;
	private List<CuentaBancaria> cuentasBancariasCliente;
	
	//constructor
	
	public Cliente(String nombre, String apellidos, String fecha_nacimiento, Date altaCuenta, String localidadSucursal) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.altaCuenta = altaCuenta;
		this.localidadSucursal = localidadSucursal;
		cuentasBancariasCliente = new ArrayList<CuentaBancaria>();
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
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
	public List<CuentaBancaria> getCuentasBancariasCliente() {
		return cuentasBancariasCliente;
	}
	public void setCuentasBancariasCliente(List<CuentaBancaria> cuentasBancariasCliente) {
		this.cuentasBancariasCliente = cuentasBancariasCliente;
	}
	
	// agregar cuenta bancaria
	public void agregarCuentaBancaria(CuentaBancaria cuenta) {
		cuentasBancariasCliente.add(cuenta);
	}
	
	
	//toString
	
	public String toString() {
	 String cadena = "\nNombre: " + this.nombre + "\nApellidos: " + this.apellidos + "\nFecha nacimiento: " + this.fecha_nacimiento
				+ "\nFecha de alta de la cuenta: " + this.altaCuenta + "\nLocalidad sucursal: " + this.localidadSucursal 
				+"\nInformacion cuentas bancarias: \n" ;
	 	
	 for (CuentaBancaria cuentaBancaria : cuentasBancariasCliente) {
		cadena += cuentaBancaria + "\n";
	}

	 return cadena;
	}
	
	
	
	
	
	
	
	
	
	
	

}
