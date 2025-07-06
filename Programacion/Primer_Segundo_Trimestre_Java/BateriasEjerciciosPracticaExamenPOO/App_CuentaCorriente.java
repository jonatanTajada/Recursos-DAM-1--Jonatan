package BateriasEjerciciosPracticaExamenPOO;

import java.util.Scanner;

public class App_CuentaCorriente {

	static Scanner scanner = new Scanner(System.in);
	
	public static CuentaCorriente rellenarCuenta() {
		
	    int cantidadTitulares;
	    String numCuenta;
	    Titular[] titulares;
	    CuentaCorriente cuentaCorriente;
	    double saldo = 0;

	    do {
	        System.out.println("Cuantos titulares tiene vinculada esta cuenta? (1 o 2)");
	        cantidadTitulares = Integer.parseInt(scanner.next());

	        if (cantidadTitulares < 1 || cantidadTitulares > 2) {
	            System.err.println("La cuenta solo puede tener como mínimo 1 y como máximo 2 titulares.");
	        }
	    } while (cantidadTitulares < 1 || cantidadTitulares > 2);

	    titulares = new Titular[cantidadTitulares];

	    for (int i = 0; i < cantidadTitulares; i++) {
	        System.out.println("Introduce los datos del titular: #" + (i + 1));
	        System.out.println("---------------------------------------------");
	        scanner.nextLine();

	        System.out.println("Introduce nombre");
	        String nombre = scanner.nextLine();

	        System.out.println("Introduce apellidos: ");
	        String apellidos = scanner.nextLine();

	        System.out.println("Introduce direccion: ");
	        String direccion = scanner.nextLine();

	        System.out.println("Introduce DNI: ");
	        String dni = scanner.next();

	        titulares[i] = new Titular(nombre, apellidos, direccion, dni);
	    }

//	    do {
//	        scanner.nextLine();
//	        System.out.println("Introduce el numero de cuenta: ");
//	        numCuenta = scanner.nextLine();
//
//	        if (numCuenta.length() != 20) {
//	            System.err.println("Introduce 20 digitos");
//	        }
//	    } while (numCuenta.length() != 20);
	    
	    do {
	        scanner.nextLine();
	        System.out.println("Introduce el numero de cuenta (solo números): ");
	        numCuenta = scanner.nextLine();

	        if (!numCuenta.matches("\\d{20}")) { //este if ya lo valido desde el constructor, podria quitarlo
	            System.err.println("Introduce exactamente 20 dígitos numéricos.");
	        }
	    } while (!numCuenta.matches("\\d{20}"));


	    do {
	        System.out.println("Introduce el saldo");
	        saldo = Double.parseDouble(scanner.next());

	        if (saldo < 0) {
	            System.err.println("No es posible tener saldo negativo.");
	        }
	    } while (saldo < 0);

	    cuentaCorriente = new CuentaCorriente(titulares[0], (cantidadTitulares == 2) ? titulares[1] : null, numCuenta, saldo);

	    return cuentaCorriente;
	}

	
	
//---------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------*** MAIN ***----------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
		 CuentaCorriente cuentaCorriente = rellenarCuenta();

		    // Imprimir información detallada de la cuenta corriente
		    System.out.println("\nInformación de la cuenta corriente:");
		    System.out.println("---------------------------------");
		  //  System.out.println(cuentaCorriente.toString());
		    
		    // Imprimir titulares individualmente
		    Titular titular1 = cuentaCorriente.getTitular1();
		    System.out.println("\nInformación del Titular 1:");
		    System.out.println("-------------------------");
		    System.out.println(titular1.toString());

		    Titular titular2 = cuentaCorriente.getTitular2();
		    if (titular2 != null) {
		        System.out.println("\nInformación del Titular 2:");
		        System.out.println("-------------------------");
		        System.out.println(titular2.toString());
		    }
	
	}
	

	
}
