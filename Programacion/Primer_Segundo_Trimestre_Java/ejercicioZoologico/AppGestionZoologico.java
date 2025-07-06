package ejercicioZoologico;

import java.util.Scanner;

public class AppGestionZoologico {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("*** Bienvenido a la aplicacion de gestion del zoologico ***");

		System.out.print("Ingrese el nombre del zoologico: ");
		String nombreZoologico = scanner.nextLine();

		Zoologico zoologico = new Zoologico(nombreZoologico);

		int opcion;

		do {

			mostrarMenu();
			System.out.print("Ingrese la opcion: ");
			opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				agregarZona(scanner, zoologico);
				break;

			case 2:
				agregarInstalacion(scanner, zoologico);
				break;

			case 3:
				agregarAnimal(scanner, zoologico);
				break;

			case 4:
				agregarTrabajador(scanner, zoologico);
				break;

			case 5:
				System.out.println("Listado de instalaciones:");
				zoologico.listarInstalaciones();
				break;

			case 6:
				System.out.println("Listado de animales:");
				zoologico.listarAnimales();
				break;

			case 7:
				System.out.print("Ingrese el D.N.I. del trabajador: ");
				String dniTrabajador = scanner.next();
				System.out.println("Listado de zonas de trabajo del trabajador:");
				zoologico.listarZonasTrabajador(dniTrabajador);
				break;

			case 0:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opcion no valida. Intente de nuevo.");
			}

		} while (opcion != 0);

		// Cerrar el scanner
		scanner.close();
	}

	// *** METODOS ***

	private static void mostrarMenu() {
		int opcion = 0;
		try {
			
			do {
				System.out.println("\nMenu:");
				System.out.println("1. Agregar Zona");
				System.out.println("2. Agregar Instalacion");
				System.out.println("3. Agregar Animal");
				System.out.println("4. Agregar Trabajador");
				System.out.println("5. Mostrar listado de instalaciones");
				System.out.println("6. Mostrar listado de animales");
				System.out.println("7. Mostrar zonas de trabajo de un trabajador");
				System.out.println("0. Salir");
				
				if (opcion < 0 || opcion > 7) {
					System.err.println("Error, introduce un numero entre el 0 y el 7.");
				}
			} while (opcion < 0 || opcion > 7 );

		} catch (Exception e) {
			System.err.println("Error al mostrar el menú: " + e.getMessage());

		}
	}

	private static void agregarZona(Scanner scanner, Zoologico zoologico) {
		try {
			System.out.print("- Ingrese el código de la zona: ");
			String codigoZona = scanner.nextLine();
			System.out.print("- Ingrese el nombre de la zona: ");
			String nombreZona = scanner.nextLine();
			System.out.print("- Ingrese los metros cuadrados de la zona: ");
			int metrosCuadrados = scanner.nextInt();
			scanner.nextLine();

			// Verificar si la entrada es un entero
			if (metrosCuadrados > 0) {
		
				Zona nuevaZona = new Zona(codigoZona, nombreZona, metrosCuadrados);
				zoologico.agregarZona(nuevaZona);
				System.out.println("Zona agregada con éxito.");
			} else {
				System.err.println("- Por favor, ingrese solo valores numéricos para los metros cuadrados.");
				scanner.next(); // Consumir la entrada no válida
			}
		} catch (Exception e) {
			System.err.println("Error al agregar zona: " + e.getMessage());
		}
	}

	// En el método agregarInstalacion
	private static void agregarInstalacion(Scanner scanner, Zoologico zoologico) {
	    System.out.print("Ingrese el número de la instalación: ");
	    try {
	        int numeroInstalacion = Integer.parseInt(scanner.next());
	        System.out.print("Ingrese el código de la zona de la instalación: ");
	        String codigoZonaInstalacion = scanner.next();

	        Zona zonaInstalacion = obtenerZonaPorCodigo(zoologico, codigoZonaInstalacion);

	        if (zonaInstalacion != null) {
	            System.out.print("Ingrese la descripción de la instalación: ");
	            String descripcionInstalacion = scanner.next();
	            System.out.print("Ingrese el año de instalación de la instalación: ");
	            int anoInstalacion = scanner.nextInt();

	            Instalacion nuevaInstalacion = new Instalacion(numeroInstalacion, zonaInstalacion,
	                    descripcionInstalacion, anoInstalacion);
	            zoologico.agregarInstalacion(nuevaInstalacion);
	            System.out.println("Instalación agregada con éxito.");
	        } else {
	            System.out.println("La zona especificada no existe.");
	        }
	    } catch (NumberFormatException e) {
	        System.err.println("Error: Ingrese un número válido para el número de instalación.");
	        scanner.nextLine(); // Consumir la entrada no válida
	    }
	}

	

	private static void agregarAnimal(Scanner scanner, Zoologico zoologico) throws Exception {

		try {

			System.out.print("- Ingrese el código del animal: ");
			String codigoAnimal = scanner.next();
			System.out.print("- Ingrese el nombre del animal: ");
			String nombreAnimal = scanner.next();
			System.out.print("- Ingrese la especie del animal: ");
			String especieAnimal = scanner.next();
			System.out.print("- Ingrese el año de nacimiento del animal: ");

			// Verificar si la entrada es un entero
			if (scanner.hasNextInt()) {
				int anoNacimientoAnimal = scanner.nextInt();

				// Seleccionar instalación para el animal
				System.out.print("Ingrese el número de la instalación del animal: ");

				// Verificar si la entrada es un entero
				if (scanner.hasNextInt()) {
					int numeroInstalacionAnimal = scanner.nextInt();
					// Obtener la instalación (puede implementarse)
					Instalacion instalacionAnimal = obtenerInstalacionPorNumero(zoologico, numeroInstalacionAnimal);

					if (instalacionAnimal != null) {
						Animal nuevoAnimal = new Animal(codigoAnimal, nombreAnimal, especieAnimal, anoNacimientoAnimal,
								instalacionAnimal);
						zoologico.agregarAnimal(nuevoAnimal);
						System.out.println("Animal agregado con éxito.");

					} else {
						System.out.println("La instalación especificada no existe.");

					}
				} else {
					throw new Exception("La entrada para el número de instalación no es válida.");

				}
			} else {
				throw new Exception("La entrada para el año de nacimiento no es válida.");
			}
		} catch (Exception e) {
			System.err.println("Error al agregar animal: " + e.getMessage());
			throw e; // Lanzar la excepción para que sea manejada en el main
		}
	}

	private static void agregarTrabajador(Scanner scanner, Zoologico zoologico) throws Exception {

		try {

			System.out.print("- Ingrese el nombre y apellidos del trabajador: ");
			String nombreApellidoTrabajador = scanner.nextLine();
			nombreApellidoTrabajador = scanner.nextLine();
			System.out.print("- Ingrese la especialidad del trabajador: ");
			String especialidadTrabajador = scanner.next();
			System.out.print("- Ingrese el D.N.I. del trabajador: ");
			String dniTrabajador = scanner.next();

			Trabajador nuevoTrabajador = new Trabajador(nombreApellidoTrabajador, especialidadTrabajador,
					dniTrabajador);
			zoologico.agregarTrabajador(nuevoTrabajador);

			// Asignar zonas al trabajador
			System.out.print("¿Cuántas zonas trabajará este trabajador? ");

			// Verificar si la entrada es un entero
			if (scanner.hasNextInt()) {
				int numZonas = scanner.nextInt();
				for (int i = 0; i < numZonas; i++) {
					System.out.print("Ingrese el código de la zona: ");
					String codigoZonaTrabajador = scanner.next();
					// Obtener la zona (puede implementarse)
					Zona zonaTrabajador = obtenerZonaPorCodigo(zoologico, codigoZonaTrabajador);

					if (zonaTrabajador != null) {
						System.out.print("Ingrese el horario de trabajo en la zona: ");
						String horarioZonaTrabajador = scanner.next();

						Asignacion asignacion = new Asignacion(nuevoTrabajador, zonaTrabajador, horarioZonaTrabajador);
						zoologico.agregarAsignacion(asignacion);
					} else {
						System.out.println("La zona especificada no existe.");
					}
				}
				System.out.println("Trabajador agregado con exito.");
			} else {
				throw new Exception("La entrada para el numero de zonas no es valida.");
			}
		} catch (Exception e) {
			System.err.println("Error al agregar trabajador: " + e.getMessage());
			throw e;
		}
	}

	// Métodos auxiliares

	private static Zona obtenerZonaPorCodigo(Zoologico zoologico, String codigoZona) {
		try {
			for (Zona zona : zoologico.getZonas()) {
				if (zona.getCodigo().equals(codigoZona)) {
					return zona;
				}
			}
			return null;
		} catch (Exception e) {
			System.err.println("Error al obtener zona por código: " + e.getMessage());
			return null;
		}
	}

	private static Instalacion obtenerInstalacionPorNumero(Zoologico zoologico, int numeroInstalacion) {
		try {
			for (Instalacion instalacion : zoologico.getInstalaciones()) {
				if (instalacion.getNumero() == numeroInstalacion) {
					return instalacion;
				}
			}
			return null;
		} catch (Exception e) {
			System.err.println("Error al obtener instalación por número: " + e.getMessage());
			return null;
		}
	}

}
