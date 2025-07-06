package z_PracticasParaExamen2ºEvaluacion;

import java.util.Scanner;

public class Empleado {

	
	private String nombre;
	private int edad;
	private boolean casado;
	private double salario;
	
	
	
	public Empleado(String nombre, int edad, boolean casado, double salario) {

		this.nombre = nombre;
		
		if (edad > 17 && edad < 46) {
			this.edad = edad;
		}else {
			System.err.println("Introduce una edad compredidad entre 18 y 45");
		}

		this.casado = casado;
		this.salario = salario;
	}
	
	
	public Empleado() {
		
	}
	
	
	
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
		return casado;
	}


	public void setCasado(boolean casado) {
		this.casado = casado;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	
	
	public void clasificarEdades() {
		
		if (edad > 17 && edad <=21) {
			System.out.println("Principiante");
		}else if(edad > 21 && edad <=35){
			System.out.println("Intermedio");
		}else{
			System.out.println("Senior");
		}
		
	}
	
	
	public void aumentarSalario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el porcentaje que quieres introducir para subir salario: ");
		double porcentaje = Double.parseDouble(scanner.nextLine());
		double salarioNuevo = this.salario + (this.salario * porcentaje)/100;
		
		this.salario = salarioNuevo;
		System.out.println("Salario aumentado con exito.\nSu nuevo salario es: " + this.salario + "€.");
		
	}
	
	
	public String toString() {
		
		return "\n-Datos empleado:\n" + "----------------------" + "\nNombre: " + nombre + "\nEdad: " + edad 
				+ "\nCasado: " + casado + "\nSalario: " + salario;
		
	}
	
	

	
}
