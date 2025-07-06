package ejercicioBanco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Cliente {

	//Atributos
	
	 private String nombre;
	 private String apellidos;
	 private String fechaNacimiento;
     private Date altaCuenta;
     private String localidadSucursal;
     private List<CuentaBancaria> cuentasBancarias;
	
	
	
	//Constructores
	
	public Cliente(String nombre, String apellidos, String fechaNacimiento, Date altaCuenta, String localidadSucursal) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.altaCuenta=altaCuenta;
		this.localidadSucursal=localidadSucursal;
		this.cuentasBancarias= new ArrayList<CuentaBancaria>();
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


	public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

	
	 public void agregarCuentaBancaria(CuentaBancaria cuentaBancaria) {
	        cuentasBancarias.add(cuentaBancaria);
	    }

	
	//toString
	
	 public String toString() {
		 
	        StringBuilder stringBuilder = new StringBuilder();
	        
	        stringBuilder.append("Nombre: ").append(nombre)
	                     .append("\nApellidos: ").append(apellidos)
	                     .append("\nFecha de nacimiento: ").append(fechaNacimiento)
	                     .append("\nFecha de alta de cuenta bancaria: ").append(altaCuenta)
	                     .append("\nLocalidad de la sucursal: ").append(localidadSucursal)
	                     .append("\nInformacion cuentas bancarias: \n");

	        for (CuentaBancaria cuenta : cuentasBancarias) {
	            stringBuilder.append(cuenta).append("\n");
	        }

	        return stringBuilder.toString();
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
