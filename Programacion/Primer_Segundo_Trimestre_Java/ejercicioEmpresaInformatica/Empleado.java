package ejercicioEmpresaInformatica;

public class Empleado {
	
	// Atributos
	private String nombre;
	private int edad;
	private boolean casado;
	private double salario;

	
	// Constructores
	public Empleado() {
	}

	public Empleado(String nombre, int edad, boolean casado, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.casado = casado;
		this.salario = salario;
	}

	
	//Setters anD Getters
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
	
	
				//*********METODOS***********

	// Mostrar la clasificación según la edad
	public void clasificarEdad() {
		
		if (edad <= 21) {
			System.out.println("Principiante.");
		} else if (edad >= 22 && edad <= 35) {
			System.out.println("Intermedio.");
		} else {
			System.out.println("Senior.");
		}
	}

	//Imprimir los datos del empleado
	public void imprimirDatos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Casado: " + casado);
		System.out.println("Salario: " + salario + "€.");
	}

	//Aumentar  salario en un porcentaje dado
	public void aumentarSalario(double porcentaje) {
		salario += salario * (porcentaje / 100);
	}
	
}
