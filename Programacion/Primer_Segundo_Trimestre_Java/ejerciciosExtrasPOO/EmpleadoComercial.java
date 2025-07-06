package ejerciciosExtrasPOO;

public class EmpleadoComercial extends Empleado{

	//Atributos
	
	private double comision;
	
	//Contructor
	
	public EmpleadoComercial(String nombre, int edad, double salario, double comision) {
		super(nombre, edad, salario);
		setComision(comision);
	}

	//Setters and Getters
	
	public void setComision(double comision) {
		
		if (comision >= 0) {
			this.comision=comision;
		}else {
			throw new IllegalArgumentException("La comision no puede se le puede asignar una cantidad negativa");
		}
	}
	
	public double getComision() {
		return comision;
	}

	//Metodo plus
	@Override
	public void plus() {
		
		if (getEdad() > 30 && getComision() > 200) {
			setSalario(getSalario() + PLUS);
			System.out.println("Se le aplico el plus al Comercial: " + getNombre() + " - El plus es de: " + PLUS + "€.");
		}else {
			System.err.println("No se le aplico el plus al Comercial: " + getNombre());
		}
	}

	//Metodo toString
	@Override
	public String toString() {
		return "\n***Empleado:***" + "\nNombre: " + getNombre() + "\nEdad: " + getEdad() + "\nSalario: " + getSalario() + "\nComision: " + comision;
	}
	

	
}
