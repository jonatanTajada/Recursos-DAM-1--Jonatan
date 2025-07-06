package ejerciciosDePractica_POO;

public class EmpleadoASalariado extends Empleado {  

	
	//Atributos
	private double salarioMensual;
	
	//Constructor
	
	public EmpleadoASalariado(String nombre, int id, double salarioMensual) {
		super(nombre, id);
		
		if (salarioMensual < 0) {
			System.err.println("\nIntroduce un valor positivo.");
		}else {
			this.salarioMensual = salarioMensual;
		}
	}

	
	
	//Set and Get
	
	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}


	//Metodos
	
	@Override
	public double calcularSalario() {
		return salarioMensual;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\nSalario mensual: " + calcularSalario() + "€.";
	}
	
}
