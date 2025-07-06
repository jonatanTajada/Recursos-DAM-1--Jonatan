package ejerciciosExtrasPOO;

public class EmpleadoRepartidor extends Empleado {

	//Atributos
	
	private String zona;
	
	//Constructor
	
	public EmpleadoRepartidor(String nombre, int edad, double salario, String zona) {
		super(nombre, edad, salario);
		this.zona=zona;
	}
	
	//Getters and Setters
	//no me funciona el do while, aunque si la validacion, mirar el porque.
	public void setZona(String zona) {
		
		do {
            if (zona != null && !zona.isEmpty()) {
                this.zona = zona;
            } else {
                System.out.println("La zona no puede estar vacía o ser nula. Introduce una zona válida.");
            }
        } while (zona == null || zona.isEmpty());
	}
	
	public String getZona() {
		return zona;
	}
	
	
	//Metodo plus
	@Override
	public void plus() {
		
		if (getEdad() < 25 && getZona().equalsIgnoreCase("zona 3")) {
			setSalario(getSalario() + PLUS);
			System.out.println("Se le aplico el plus al Repartidor: " + getNombre() + " - El plus es de: " + PLUS + "€.");
		}else {
			System.err.println("No se le aplico el plus al Repartidor: " + getNombre());
		}
	}
	
	//Metodo toString
	@Override
	public String toString() {
		
		return "\n***Empleado:***" + "\nNombre: " + getNombre() + "\nEdad: " + getEdad() + "\nSalario: " + getSalario() + "\nZona: " + zona;
	}

	
}
