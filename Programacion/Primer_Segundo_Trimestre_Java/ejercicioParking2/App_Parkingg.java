package ejercicioParking2;

import java.util.Scanner;



public class App_Parkingg {

	static int opcion;
	static Scanner scanner = new Scanner(System.in);
	static Parkingg parkingg = new Parkingg("Parking Los Fueros", 10);
	
	//---------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
		
		menuOpciones(parkingg);
		
//		  App_Parkingg app_Parkingg = new App_Parkingg();
//		  app_Parkingg.menuOpciones(parkingg);
	
		/* corrgir algo va mal---nose si es tema de los static pero no me coge los metodos de la otra clase*/
		
		
		
		
	}
	
	//------------------------------------------------------------------------------------------------------------------
	
	
	public static void menuOpciones(Parkingg parkingg) {
		
	
		String continuar;
		
	do {
		
		do {
			System.out.println("--	Menu de opciones	--" + "\n-------------------------");
			System.out.println("1. Entrada de coche");
			System.out.println("2. Salida de coche");
			System.out.println("3. Mostrar parking");
			System.out.println("4. Salir del programa");
			System.out.println("Introduce opcion: ");
			opcion = scanner.nextInt();
			
			if (opcion < 0 || opcion > 4) {
				System.err.println("Error: introduce una opcion valida");
			}
			scanner.nextLine();
			
		} while (opcion < 0 || opcion > 4);
		

		switch (opcion) {
		case 1:
			entradaCoche(parkingg);
			break;

		case 2:
			salidaCoche(parkingg);
			break;

		case 3:
			mostrarParking(parkingg);
			break;

		case 4:
			salirPrograma(parkingg);
			break;

		}
		
		
		System.out.println("\nDeseas realizar alguna otra operacion? (si/no): ");
		continuar = scanner.next();
		
		if (continuar.equalsIgnoreCase("no")) {
			salirPrograma(parkingg);
		}

		
	} while (continuar.equalsIgnoreCase("si"));
		
	}




	public static void entradaCoche(Parkingg parkingg) {
	    System.out.println("Introduce la matricula: ");
	    String matricula = scanner.nextLine();

	    System.out.println("\nIntroduce la plaza: ");
	    int plaza = Integer.parseInt(scanner.next());

	    try {
	        parkingg.entrada(matricula, plaza);
	    } catch (Exception e) {
	        System.err.println("Ha ocurrido algun problema, posiblemente plaza o matricula, intentelo de nuevo, por favor.");
	    }
	    System.out.println("\nNumero de plazas totales: " + parkingg.getPlazasTotales());
	    System.out.println("\nNumero de plazas ocupadas: " + parkingg.getPlazasOcupadas());
	    System.out.println("\nNumero de plazas libres: " + parkingg.getPlazasLibres());
	}




	public static void salidaCoche(Parkingg parkingg)  {
	
		System.out.println("\nIntroduce la matricula del coche que sale: ");
		String matricula = scanner.nextLine();
		
		try {
			parkingg.salida(matricula);
		} catch (Exception e) {
			System.err.println("\nSe ha producido un error en la salida, intentelo de nuevo.");
			//e.printStackTrace();
		}
		
		System.out.println("\nNumero de plazas totales: " + parkingg.getPlazasTotales());
		System.out.println("\nNumero de plazas ocupadas: " + parkingg.getPlazasOcupadas());
		System.out.println("\nNumero de plazas libres: " + parkingg.getPlazasLibres());
		
	}


	public static void mostrarParking(Parkingg parkingg) {
		System.out.println(parkingg.toString());
	}




	public static void salirPrograma(Parkingg parkingg) {
		System.out.println("Saliendo del programa...\nQue tenga un buen dia, hasta la proxima");
	}





	
	
	
	
	

}
