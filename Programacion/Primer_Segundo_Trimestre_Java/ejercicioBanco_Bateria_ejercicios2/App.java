package ejercicioBanco_Bateria_ejercicios2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejercicioBanco_Bateria_ejercicios.Titular;

public class App {

	Scanner scanner = new Scanner(System.in);
	
	private List<CuentaCorriente> cuentasCorrientes;
	
	public void agregarCuenta(CuentaCorriente cuentaCorriente) {
		cuentasCorrientes.add(cuentaCorriente);
	}
	
	public void mostrarListaDeCuentas() {
		
		for(CuentaCorriente cuenta : cuentasCorrientes) {
			System.out.println(cuenta);
			System.out.println();
			
		}
	}
	
	public App() {
		cuentasCorrientes = new ArrayList<CuentaCorriente>();
	}
	
	
	public static void main(String[] args) {
		
		
	App app = new App();
	
	
	app.crearTitular();
	
	app.mostrarListaDeCuentas();
	
	//app.agregarCuenta(null);
	
		
	
		
		
		
	}
	
	
	
	
	
	
	public void cambiarSaldo() {
		
		System.out.print("Introduce saldo nuevo:");
		double saldoNuevo = scanner.nextDouble();
		
		
		
	}
	
	
	
	
	

	public Titular crearTitular() {
		
		System.out.println("-Introduce los datos del cliente para crear una cuenta.");
		System.out.println("--------------------------------------------------------------");
		System.out.print("Nombre: ");
		String nombre1 = scanner.nextLine();
		System.out.print("Apellidos: ");
		String apellidos1 = scanner.nextLine();
		System.out.print("Dirección: ");
		String direccion1 = scanner.nextLine();
		System.out.print("DNI: ");
		String dni1 = scanner.nextLine();

		Titular titular1 = new Titular(nombre1, apellidos1, direccion1, dni1);
		
		// Pregunta si se quiere asignar otro titular a esta cuenta
		System.out.println("¿Quieres asignar otro titular a esta cuenta? (S/N)");
		String opcion = scanner.nextLine();

		if (opcion.equalsIgnoreCase("s")) {
			System.out.println("-Introduce los datos del segundo titular:");
			Titular titular2 = crearTitular(); 
			
			String numeroCuenta;
			
			do {
				System.out.print("Introduce el número de cuenta: ");
				numeroCuenta = scanner.nextLine();
				
				if (numeroCuenta.length() != 20) {
					System.err.println("Introduce 20 digitos");
				}
			} while (numeroCuenta.length() !=20);
			
			
			double saldoInicial;
			
			do {
				System.out.print("Introduce el saldo inicial: ");
				saldoInicial = Double.parseDouble(scanner.nextLine());
				
				if (saldoInicial < 0) {
					System.err.println("Introduce un numero positivo!");
				}
				
			} while (saldoInicial < 0);
			
			

			CuentaCorriente cuenta = new CuentaCorriente(titular1, titular2, numeroCuenta, saldoInicial);
			
			cuentasCorrientes.add(cuenta);
		}
		

		return titular1;
	}
	
	
	
	
	
	
	
	
//	public CuentaCorriente crearCuentaCorriente() {
//		
//	    System.out.println("-Introduce los datos del primer titular:");
//	    System.out.println("--------------------------------------------------------------");
//	    System.out.print("Nombre: ");
//	    String nombre1 = scanner.nextLine();
//	    System.out.print("Apellidos: ");
//	    String apellidos1 = scanner.nextLine();
//	    System.out.print("Dirección: ");
//	    String direccion1 = scanner.nextLine();
//	    System.out.print("DNI: ");
//	    String dni1 = scanner.nextLine();
//
//	    Titular titular1 = new Titular(nombre1, apellidos1, direccion1, dni1);
//
//	    // Pregunta si se quiere asignar otro titular a esta cuenta
//	    System.out.println("¿Quieres asignar otro titular a esta cuenta? (S/N)");
//	    String opcion = scanner.nextLine();
//
//	    Titular titular2 = null;
//
//	    if (opcion.equalsIgnoreCase("s")) {
//	        System.out.println("-Introduce los datos del segundo titular:");
//	        titular2 = new Titular(crearCuentaCorriente());
//	    }
//
//	    String numeroCuenta;
//
//	    do {
//	        System.out.print("Introduce el número de cuenta: ");
//	        numeroCuenta = scanner.nextLine();
//
//	        if (numeroCuenta.length() != 20) {
//	            System.err.println("Introduce 20 dígitos");
//	        }
//	    } while (numeroCuenta.length() != 20);
//
//	    double saldoInicial;
//
//	    do {
//	        System.out.print("Introduce el saldo inicial: ");
//
//	        try {
//	            saldoInicial = Double.parseDouble(scanner.nextLine());
//
//	            if (saldoInicial < 0) {
//	                System.err.println("Introduce un número positivo.");
//	            }
//	        } catch (NumberFormatException e) {
//	            System.err.println("Error: Ingresa un número válido.");
//	            saldoInicial = -1;  // Asignar un valor negativo para repetir el bucle
//	        }
//
//	    } while (saldoInicial < 0);
//
//	    CuentaCorriente cuenta = new CuentaCorriente(titular1, titular2, numeroCuenta, saldoInicial);
//
//	    cuentasCorrientes.add(cuenta);
//
//	    return cuenta;
//	}

	
	

}
