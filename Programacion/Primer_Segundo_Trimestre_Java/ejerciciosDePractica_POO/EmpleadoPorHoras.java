package ejerciciosDePractica_POO;

public class EmpleadoPorHoras extends Empleado {

	
	
	//Atributos
	private double tarifaPorHoras;
	private double horasTrabajadas;
	
	//Constructor
	
	public EmpleadoPorHoras(String nombre, int id, double tarifaPorHoras, double horasTrabajadas) {
		super(nombre, id);
		
		if (tarifaPorHoras < 0) {
			System.err.println("\nIntroduce un valor positivo.");
		}else {
			this.tarifaPorHoras=tarifaPorHoras;
		}
		
		if (horasTrabajadas < 0) {
			System.err.println("\nIntroduce un numero positivo");
		}else {
			this.horasTrabajadas=horasTrabajadas;
		}
		
	}


	//Setters and Getters
	
	public double getTarifaPorHoras() {
		return tarifaPorHoras;
	}


	public void setTarifaPorHoras(double tarifaPorHoras) {
		this.tarifaPorHoras = tarifaPorHoras;
	}


	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}


	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	
	//Metodos
	
	@Override
	public double calcularSalario() {
		
		return horasTrabajadas * tarifaPorHoras;
	}
	
	
	@Override
	public String toString() {
		
		return super.toString() + "\nTotal salario (horasTraba. * tarifaPorHoras): " + calcularSalario() + "€.";
	}
	
	
	
}
