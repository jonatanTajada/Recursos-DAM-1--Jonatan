package z_PracticasParaExamen2ºEvaluacion;

import java.util.Scanner;

public class AppEmpleado {

	Scanner scanner = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		
		Empleado empleado1 = new Empleado("Jonatan", 30, true, 1000);
		
		empleado1.isCasado();
		empleado1.clasificarEdades();
		empleado1.aumentarSalario();
		System.out.println(empleado1.toString());
		System.out.println("-----------------------------------------------------------------------------");
		
		Empleado programador1 = new Programador("Javier", 30, false, 10000, 150, "Java");
		
		programador1.isCasado();
		programador1.clasificarEdades();
		programador1.aumentarSalario();
		System.out.println(programador1.toString());
		System.out.println("--------------------------------------------------------------------------------");
		
		
		
	}
	
	
}
