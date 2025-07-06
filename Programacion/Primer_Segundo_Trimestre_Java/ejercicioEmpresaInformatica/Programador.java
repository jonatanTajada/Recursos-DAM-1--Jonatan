package ejercicioEmpresaInformatica;

public class Programador extends Empleado {
	
	// Atributos 
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;

	// Constructores
	public Programador() {
	}

	public Programador(String nombre, int edad, boolean casado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
		super(nombre, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}

	
	//Setters and Getters
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
	
	//********METODOS*********************
	

	public void imprimirDatos() {
		System.out.println("Nombre: " + super.getNombre());
		System.out.println("Edad: " + super.getEdad());
		System.out.println("Casado: " + super.isCasado());
		System.out.println("Salario: " + super.getSalario()+ "€.");
		System.out.println("Lineas de codigo por horas: " + lineasDeCodigoPorHora);
		System.out.println("Lenguaje dominante: " + lenguajeDominante);
	}
	
	
}
