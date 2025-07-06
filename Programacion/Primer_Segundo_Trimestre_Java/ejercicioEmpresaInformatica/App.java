package ejercicioEmpresaInformatica;

public class App {

	public static void main(String[] args) {

		// Crear un objeto Empleado
		Empleado empleado = new Empleado("Jonatan Tajada", 64, false, 30000.0);
		System.out.println("-Datos del empleado antes del aumento: \n");
		System.out.print("Categoria de empleado por edad: ");  
		empleado.clasificarEdad();
		empleado.imprimirDatos();
		System.out.println();

		// Aumentar el salario en un 25%
		empleado.aumentarSalario(25);

		// Imprimir los datos del empleado después del aumento
		System.out.println("- Datos del empleado despues del aumento: \n");
		System.out.print("Categoria de empleado por edad: ");  
		empleado.clasificarEdad();
		empleado.imprimirDatos();
		System.out.println();

		//-------------------
		
		// Crear un objeto Programador
		Programador programador = new Programador("Maria Jimenez", 10, true, 45000.0, 100, "Java");

		// Imprimir los datos del programador antes del aumento
		System.out.println("- Datos del programador antes del aumento: \n");
		System.out.print("Categoria de empleado por edad: ");  
		programador.clasificarEdad();
		programador.imprimirDatos();
		System.out.println();

		// Aumentar el salario del programador en un 25%
		programador.aumentarSalario(25);

		// Imprimir los datos del programador después del aumento
		System.out.println("- Datos del programador después del aumento: \n");
		System.out.print("Categoria de empleado por edad: ");  
		programador.clasificarEdad();
		programador.imprimirDatos();
		System.out.println();
	}

}
