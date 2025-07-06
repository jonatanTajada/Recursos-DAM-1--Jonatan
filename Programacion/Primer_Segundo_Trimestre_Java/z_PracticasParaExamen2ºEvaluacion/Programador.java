package z_PracticasParaExamen2ºEvaluacion;

public class Programador extends Empleado{

	
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;
	
	
	public Programador() {
		// TODO Auto-generated constructor stub
	}


	public Programador(String nombre, int edad, boolean casado, double salario, int lineasDeCodigoPorHora,String lenguajeDominante) {
		
		super(nombre, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
		this.lenguajeDominante = lenguajeDominante;
	}


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


//	@Override
//	public String toString() {
//		return "Programador [lineasDeCodigoPorHora=" + lineasDeCodigoPorHora + ", lenguajeDominante="
//				+ lenguajeDominante + "]";
//	}
//	
	
	
	public String toString() {
		
		return "\n-Datos empleado:\n" + "----------------------" + "\nNombre: " + super.getNombre() + "\nEdad: " + super.getEdad() 
				+ "\nCasado: " + super.isCasado() + "\nSalario: " + super.getSalario() 
				+ "\nLineas de codigo por horas: " + lineasDeCodigoPorHora + "\nLenguaje dominante: " + lenguajeDominante;
		
	}
	
	
	
	
	
	
	
	
	
	
}
