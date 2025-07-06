package z_Proyectos_Mios_Pruebas;

import java.util.Scanner;

public class Empleado {

	//atributos
	private String nombre;
	private int edad;
	private boolean isCasado;
	private double salario;
	
	
	//constructor
	
	public Empleado() {}
	
	public Empleado(String nombre, int edad, boolean isCasado, double salario) {
		this.nombre=nombre;
		this.edad=edad;
		this.isCasado=isCasado;
		this.salario=salario;
	}
	
	
	// getters ands setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isCasado() {
		return isCasado;
	}

	public void setCasado(boolean isCasado) {
		this.isCasado = isCasado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	
	//metodo que permite mostrar la clasificación según la edad 
	public void clasificacionEdad(int edad) {
		System.out.println("Clasificando edad:");
		if (edad < 0) {
			System.err.println("Error: la edad no puede ser un numero negativo");
		}else if(edad >= 0 && edad <= 20) {
			System.out.println("Principiante");
		}else if(edad > 20 && edad <= 35){
			System.out.println("Intermedio");
		}else if(edad > 35 && edad <= 90) {
			System.out.println("Senior");
		}else {
			System.err.println("Lo siento, muy mayor para trabajar, introduza otra edad");
			clasificacionEdad(edad);
		}
	}
	
	// mostrar datos empleado
	public void mostrarDatosEmpleado() {
		System.out.println("-Datos de empleado Empleado: " + "\nNombre: " + this.nombre + "\nEdad: " + this.edad + "\n¿Esta casado?: " 
							+ isCasado + "\nSalario: " + this.salario + "€");
	}

	//metodo aumentar salario
	public void aumentarSalario(double porcentaje) {
		if (porcentaje < 0) {
			System.err.println("Error: El porcentaje no puede ser negativo.");
		}
		
		double salarioNuevo = this.salario + (this.salario * porcentaje)/100;
		this.salario = salarioNuevo;
		
	}
	

	
}
