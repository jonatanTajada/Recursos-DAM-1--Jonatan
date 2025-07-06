package z_Proyectos_Mios_Pruebas;

import java.util.Scanner;

public class App_Empleado_Programador {

	public static void main(String[] args) {
		
		// creando objetos
		Empleado empleado = new Empleado("Jonatan", 35, true, 2500);
		Empleado empleado2 = new Empleado("Aitor", 21, false, 500);
		
		Empleado programador = new Programador("Andrew", 10, false, 2500, 120, "Java");
		Empleado programador2 = new Programador("Michael", 2, false, 1500, 120, "MySQL");
		
		//imprimir datos de los empleados antes de aumentalos
		System.out.println("Datos de los empleados antes de subirles el sueldo: ");
		System.out.println("---------------------------------------------------------");
		empleado.mostrarDatosEmpleado();
		System.out.println();
		empleado2.mostrarDatosEmpleado();
		System.out.println();
		programador.mostrarDatosEmpleado();
		System.out.println();
		programador2.mostrarDatosEmpleado();
		System.out.println();
		
		//aumentar salarios a todos los empleados
		
		System.out.println("Aumento de salario 10%: -------------");
		empleado.aumentarSalario(10);
		empleado2.aumentarSalario(10);
		programador.aumentarSalario(10);
		programador2.aumentarSalario(10);
		
		//imprimir datos despues de aumentar salario
		System.out.println("\n-Datos de los empleados despues de aumentar salario: ");
		System.out.println("-------------------------------------------------------");
		empleado.mostrarDatosEmpleado();
		System.out.println();
		empleado2.mostrarDatosEmpleado();
		System.out.println();
		programador.mostrarDatosEmpleado();
		System.out.println();
		programador2.mostrarDatosEmpleado();
		System.out.println();
		
		//clasificacion de edades
		System.out.println("-Clasificacion de edades:");
		System.out.println("--------------------------");
		empleado.clasificacionEdad(35);
		empleado2.clasificacionEdad(21);
		programador.clasificacionEdad(10);
		programador2.clasificacionEdad(2);
	}
	
	
}
