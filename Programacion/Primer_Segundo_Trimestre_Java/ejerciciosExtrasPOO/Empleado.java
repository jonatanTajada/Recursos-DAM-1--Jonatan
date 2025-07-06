package ejerciciosExtrasPOO;

public abstract class Empleado implements EmpleadoTrabajador{

	
	//Atributos
	
	private String nombre;
	private int edad;
	private double salario;
	public static final double PLUS = 300;
	
	//Constructor
	
	public Empleado(String nombre, int edad, double salario) {
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	
	//Setters and Getters
	
	public void setNombre(String nombre) {
		
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre=nombre;
		}else {
			throw new IllegalArgumentException("El nombre no puede estar vacio o ser nulo.");
		}
		
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEdad(int edad) {
		
		if (edad >= 0) {
			this.edad=edad;
		}else {
			throw new IllegalArgumentException("La edad no puede ser negativa.");
		}
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setSalario(double salario) {
		
		if (salario >= 0) {
			this.salario=salario;
		}else {
			throw new IllegalArgumentException("El salario no puede ser una cantidad negativa.");
		}
	}
	
	public double getSalario() {
		return salario;
	}
	
	
	//Metodo abstracto plus
	
	public abstract void plus();
	
	
	//Metodo toString
	
	public String toString() {
		return "\n***Empleado:***" + "\nNombre: " + nombre + "\nEdad: " + edad + "\nSalario: " + salario;
	}
	
}


