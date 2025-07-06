package ejerciciosArrayListParaPracticar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Coche_App {

	static Scanner scanner = new Scanner(System.in);
	ArrayList<Coche> listaCoches = new ArrayList<Coche>();

	public static void main(String[] args) {
		
		Coche_App app = new Coche_App();
		

		int opcion;
		
		do {
			
			do {
				System.out.println("\n--- Menu ---");
				System.out.println("1. Leer coche");
				System.out.println("2. Mostrar coches");
				System.out.println("3. Mostrar por kilometros");
				System.out.println("4. Mostrar por marca");
				System.out.println("5. Mostrar coche con mayor kilometraje");
				System.out.println("6. Mostrar coches ordenados por kilometros");
				System.out.println("0. Salir");
				System.out.print("Selecciona una opcion: ");

				opcion = scanner.nextInt();
				scanner.nextLine();
				
				if (opcion < 0 || opcion > 6) {
					System.err.println("Por favor, introduzca un valor del 0 al 6.");
				}
				
			} while (opcion < 0 || opcion > 6);

			switch (opcion) {
			case 1:
				app.leerCoche();
				break;
			case 2:
				app.mostrarCoches();
				break;
			case 3:
				app.mostrarPorKm(app.listaCoches);
				break;
			case 4:
				app.mostrarPorMarca(app.listaCoches);
				break;
			case 5:
				app.mostrarMayorKm();
				break;
			case 6:
				app.mostrarOrdenadoPorKms(app.listaCoches);
				break;
			case 0:
				System.out.println("Saliendo del programa. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Inténtalo de nuevo.");
			}

		} while (opcion != 0);

		scanner.close();
	}

	// ------------------------------------------------------------------------------------------------------------------
	// 									-- METODOS --
	// leerCoches, mostrarCoches, mostrarPorKm, mostrarPorMarca, mostrarMayorKm, mostrarOrdenadosPorKms
	// ------------------------------------------------------------------------------------------------------------------

	public void leerCoche() {
		
		String continuar;
		
		

		System.out.println("-Introducir datos del coche: ");

		System.out.print("-Introduce matricula: ");
		String matricula = scanner.nextLine();

		System.out.print("-Introduce marca: ");
		String marca = scanner.nextLine();

		System.out.print("-Introduce modelo: ");
		String modelo = scanner.nextLine();

		System.out.print("-Introduce kilometraje del coche: ");
		int kms = Integer.parseInt(scanner.next());

		Coche nuevoCoche = new Coche(matricula, marca, modelo, kms);

		listaCoches.add(nuevoCoche);
		System.out.println("Lectura de coche correctamente.");
		
		System.out.print("Deseas introducir otro coche? (S/N): ");
		continuar = scanner.next().toUpperCase();
			
		if (continuar.equalsIgnoreCase("S")) {
			leerCoche();
		}
	}

	public void mostrarPorKm(ArrayList<Coche> array) {

		System.out.print("-Introduce la matricula del coche que deseas ver los kilometros: ");
		String matricula = scanner.next();

		for (Coche coche : array) {
			if (coche.getMatricula().equals(matricula)) {
				System.out.println("-El kilometraje con la matricula '" + matricula + "' es de: " + coche.getKm());
				return;
			}
		}

		System.err.println("No se encontro ningun coche con la matricula '" + matricula + "'.");
	}

	public void mostrarPorMarca(ArrayList<Coche> array) {
		System.out.print("-Introduce la marca de los coches que quieres ver:  ");
		String marca = scanner.next();

		System.out.println("-Coches de la marca '" + marca + "':");
		for (Coche coche : listaCoches) {

			if (coche.getMarca().equalsIgnoreCase(marca)) {
				System.out.println(coche.toString());
			}
		}
	}

///----------------------------------------------------------------------------	
//	public void mostrarMayorKm() {
//		
//		if (!listaCoches.isEmpty()) {
//			Coche cocheMayorKm = Collections.max(listaCoches, Comparator.comparing(Coche::getKm));
//			 System.out.println("Coche con mayor kilometraje:\n" + cocheMayorKm);
//		}else {
//			System.out.println("No hay coches en la lista.");
//		}
//
//	}
//------------------------------------------------------------------------------------	

	public void mostrarMayorKm() {
		System.out.println("-Coche con mayor kilometraje de la lista: ");
		if (!listaCoches.isEmpty()) {
			Coche cocheMayorKm = listaCoches.stream().max(Comparator.comparing(Coche::getKm)).orElse(null);

			System.out.println("Coche con mayor kilometraje:\n" + cocheMayorKm);
		} else {
			System.out.println("No hay coches en la lista.");
		}
	}

//----------------------------------------------------------------------------------		

	public void mostrarOrdenadoPorKms(ArrayList<Coche> array) {
		System.out.println("-Lista de coche ordenada de mayor a menor por kilometros: \n");

		Collections.sort(array, Comparator.comparing(Coche::getKm).reversed());

		for (Coche coche : array) {
			System.out.println(coche.toString());
		}

	}

	public void mostrarCoches() {
		System.out.println("-Mostrando todos los coches de la lista:\n");

		for (Coche coche : listaCoches) {
			System.out.println(coche);
		}
	}
}
