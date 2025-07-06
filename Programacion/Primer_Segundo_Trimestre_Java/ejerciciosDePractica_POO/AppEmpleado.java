package ejerciciosDePractica_POO;

public class AppEmpleado {

	
	
	
	public static void main(String[] args) {
		
		
		Empleado empSalarial = new EmpleadoASalariado("Jonatan Tajada", 1, 2500);
		Empleado empPorHoras = new EmpleadoPorHoras("Janire Jauregui", 2, 12.5, 160);
		
		
		System.out.println(empSalarial.toString());
		System.out.println("********************************************");
		System.out.println(empPorHoras.toString());
		
		
		
	}
	
	
}
