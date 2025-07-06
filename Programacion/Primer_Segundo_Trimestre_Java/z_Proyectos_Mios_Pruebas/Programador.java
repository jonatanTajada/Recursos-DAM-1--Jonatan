package z_Proyectos_Mios_Pruebas;

public class Programador extends Empleado {

	//atributos
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;
	
	
	//Constructor
	public Programador() {}


	public Programador(String nombre, int edad, boolean isCasado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante ) {
		super(nombre, edad, isCasado, salario);
		this.lineasDeCodigoPorHora=lineasDeCodigoPorHora;
		this.lenguajeDominante=lenguajeDominante;	
	}
	
	
	//getters and setters
	public int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}


	public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}


	public String getLenguajeDominante() {
		return lenguajeDominante;
	}


	public void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}
	
	public void mostrarDatosEmpleado() {
		System.out.println("-Datos del empleado Programador: " + "--------------------" + "\nNombre: " + super.getNombre() 
		+ "\nEdad: " + super.getEdad()+ "\n¿Esta casado?: " + super.isCasado()
		+ "\nSalario: " + super.getSalario()+ "€" + "\nLineas de codigo por hora: " + this.lineasDeCodigoPorHora 
		+ "\nLenguaje dominante: " + this.lenguajeDominante);
	}
	
}
