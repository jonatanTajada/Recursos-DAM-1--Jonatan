package ejercicioParking;

import java.util.Scanner;

public class AppParking {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Crear un objeto Parking
		Parking parkingCentro = new Parking("Parking Centro", 10);

		// Menú de opciones
		int opcion=0;
		
		do {
			
			do {
				System.out.println("Menu de opciones:");
				System.out.println("1. Entrada de coche");
				System.out.println("2. Salida de coche");
				System.out.println("3. Mostrar parking");
				System.out.println("4. Salir del programa");
				System.out.print("Seleccione una opcion (1-4): ");
				opcion = Integer.parseInt(scanner.nextLine());
				
				if (opcion < 1 || opcion > 4) {
					System.err.println("Introduce un valor entre el 1/4.");
				}
			} while (opcion < 1 || opcion > 4);

			
			try {
				//scanner.nextLine();

				switch (opcion) {
				
				case 1:
					entradaCoche(parkingCentro, scanner);
					break;
				case 2:
					salidaCoche(parkingCentro, scanner);
					break;
				case 3:
					mostrarParking(parkingCentro);
					break;
				case 4:
					System.out.println("Saliendo del programa. Hasta luego!");
					break;
				default:
					System.err.println("Opcion no valida. Intentelo de nuevo.");
				}
			} catch (NumberFormatException e) {
				System.err.println("Error: Ingrese un numero valido!");
				opcion = 0;
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		} while (opcion != 4);
	}

	
	//******METODOS******  
	
	private static void entradaCoche(Parking parking, Scanner scanner) {
		
		try {
			
			System.out.print("Introduzca la matricula del coche: ");
			String matricula = scanner.nextLine();

			System.out.print("Introduzca la plaza donde se colocara el coche: ");
			int plaza = Integer.parseInt(scanner.nextLine());

			parking.entrada(matricula, plaza);
			System.out.println("Coche ingresado correctamente.");
			mostrarEstadoParking(parking);
			
		} catch (Exception e) {
			System.out.println("Error al ingresar el coche: " + e.getMessage());
		}
		
	}

	private static void salidaCoche(Parking parking, Scanner scanner) {
		try {
			System.out.print("Introduzca la matricula del coche que sale: ");
			String matricula = scanner.nextLine();

			int plazaLiberada = parking.salida(matricula);
			System.out.println("Coche con matrícula " + matricula + " salió del parking. Plaza liberada: " + plazaLiberada);
			mostrarEstadoParking(parking);
		} catch (Exception e) {
			System.out.println("Error al sacar el coche: " + e.getMessage());
		}
	}

	private static void mostrarParking(Parking parking) {
		System.out.println(parking);
	}

	private static void mostrarEstadoParking(Parking parking) {
		System.out.println("Estado del parking:");
		System.out.println("----------------------------------------------------------");
		System.out.println("Plazas totales: " + parking.getPlazasTotales());
		System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
		System.out.println("Plazas libres: " + parking.getPlazasLibres());
	}
}
