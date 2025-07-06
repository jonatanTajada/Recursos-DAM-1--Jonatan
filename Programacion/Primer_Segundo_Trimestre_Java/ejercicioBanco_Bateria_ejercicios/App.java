
package ejercicioBanco_Bateria_ejercicios;

import java.util.Scanner;

public class App {

	static Scanner scanner = new Scanner(System.in);

	// metodo rellenar la cuenta -----------------------------------------------------------------------------------------------
	public static CuentaCorriente rellenarCuenta() {
		
		// Datos del primer titular
		System.out.println("Ingrese los datos del primer titular:");
		System.out.print("Nombre: ");
		String nombre1 = scanner.nextLine();
		System.out.print("Apellidos: ");
		String apellidos1 = scanner.nextLine();
		System.out.print("Dirección: ");
		String direccion1 = scanner.nextLine();
		System.out.print("DNI: ");
		String dni1 = scanner.nextLine();

		Titular titular1 = new Titular(nombre1, apellidos1, direccion1, dni1);

		// Datos del segundo titular (opcional)
		System.out.println("¿Desea ingresar datos para un segundo titular? (S/N): ");
		String opcion = scanner.nextLine().toUpperCase();

		Titular titular2 = null;

		if (opcion.equals("S")) {
			titular2 = ingresarDatosTitular("segundo");
		}

	
		
		String numeroCuenta;
		do {
		    System.out.print("Ingrese el número de cuenta (20 caracteres numéricos): ");
		    numeroCuenta = scanner.nextLine();
		} while (!esNumeroCuentaValido(numeroCuenta));


		
		
		double saldo;
		do {
		    System.out.print("Ingrese el saldo (debe ser positivo): ");
		    saldo = obtenerDoubleDesdeEntrada();
		} while (saldo < 0);


		return new CuentaCorriente(titular1, titular2, numeroCuenta, saldo);
	}
//------------------------------------------------------------------------------------------------------------------------------------------
	
	// metodo para validar el numero de cuenta
	private static boolean esNumeroCuentaValido(String numeroCuenta) {
		// Verificar que la longitud sea 20
		if (numeroCuenta.length() != 20) {
			System.err.println("El numero de cuenta debe tener exactamente 20 caracteres.");
			return false;
		}

		// Verificar que todos los caracteres sean numericos
		for (char c : numeroCuenta.toCharArray()) {
			if (!Character.isDigit(c)) {
				System.err.println("El numero de cuenta debe contener solo caracteres numericos.");
				return false;
			}
		}

		return true;
	}

	// Función para ingresar datos del titular
	private static Titular ingresarDatosTitular(String titularNumero) {
		System.out.println("Ingrese los datos del " + titularNumero + " titular:");
		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Apellidos: ");
		String apellidos = scanner.nextLine();
		System.out.print("Direccion: ");
		String direccion = scanner.nextLine();
		System.out.print("DNI: ");
		String dni = scanner.nextLine();

		return new Titular(nombre, apellidos, direccion, dni);
	}

	// metodo para obtener un double desde la entrada del usuario con manejo de
	private static double obtenerDoubleDesdeEntrada() {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Por favor, ingrese un numero valido.");
			}
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------------------------
// 						***	Main ***
//-----------------------------------------------------------------------------------------------------------------------------------------------	
	public static void main(String[] args) {
		
		CuentaCorriente cuenta = rellenarCuenta();
		
		System.out.println("\nCuenta creada exitosamente:");
		System.out.println("Titular 1: " + cuenta.getTitular1().getNombre() + " " + cuenta.getTitular1().getApellidos());
		
		if (cuenta.getTitular2() != null) {
			System.out.println("Titular 2: " + cuenta.getTitular2().getNombre() + " " + cuenta.getTitular2().getApellidos());
		}
		
		System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
		System.out.println("Saldo actual: " + cuenta.getSaldo());

		// Cambiar el saldo
//		System.out.print("\nIngrese el nuevo saldo: ");
//		double nuevoSaldo = obtenerDoubleDesdeEntrada();
//		cuenta.cambiarSaldo(nuevoSaldo);

		// Mostrar el saldo actualizado
		System.out.println("Saldo actualizado: " + cuenta.getSaldo());
		System.out.println(cuenta.toString());
	}
}
