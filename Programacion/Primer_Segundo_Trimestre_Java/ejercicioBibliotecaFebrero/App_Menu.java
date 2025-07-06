package ejercicioBibliotecaFebrero;

import java.util.Scanner;

public class App_Menu {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();

		// Crear algunos documentos y usuarios
		Documento libro1 = new Libro("L001", "Aprende a programar", 2000);
		Documento revista1 = new Revista("R001", "El economista");
		
		Usuario socio1 = new Socio("111", "Jonata Tajada");
		Usuario ocasional1 = new UsuarioOcasional("222", "Maria Sanchez");

		biblioteca.agregarDocumento(libro1);
		biblioteca.agregarDocumento(revista1);
		biblioteca.agregarUsuario(socio1);
		biblioteca.agregarUsuario(ocasional1);

		int opcion;
		
		do {
			
			do {
			
				mostrarMenu();
			
				System.out.print("Seleccione una opcion: ");
				opcion = Integer.parseInt(scanner.next());
				if (opcion < 0 || opcion > 5) {
				System.err.println("Seleccione una opcion valida");
			}
				scanner.nextLine();
			
			} while (opcion < 0 || opcion > 5);

			switch (opcion) {
			case 1:
				// Seleccionar un documento
				System.out.print("Ingrese el codigo del documento: ");
				String codigoDocumento = scanner.nextLine();
				biblioteca.seleccionarDocumento(codigoDocumento);
				break;
			case 2:
				// Prestar documento a usuario
				System.out.print("Ingrese el DNI del usuario: ");
				String dniUsuario = scanner.nextLine();
				try {
					biblioteca.prestarDocumentoActual(dniUsuario);
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 3:
				// Devolver documento
				biblioteca.devuelveDocumentoActual();
				break;
			case 4:
				// Buscar documentos por titulo
				System.out.print("Ingrese el texto a buscar en el titulo: ");
				String textoBusqueda = scanner.nextLine();
				biblioteca.buscaDocumentos(textoBusqueda);
				break;
			case 5:
				// Informe de prestamos
				biblioteca.informePrestamos();
				break;
			case 0:
				// Salir del programa
				System.out.println("Saliendo del programa...\n¡Hasta luego!");
				break;
			default:
				System.out.println("Opcion no valida. Por favor, ingrese una opcion correcta.");
			}

		} while (opcion != 0);

		scanner.close();
	}

	private static void mostrarMenu() {
		System.out.println("\n--- Menu ---");
		System.out.println("1. Seleccionar un documento");
		System.out.println("2. Prestar documento a usuario");
		System.out.println("3. Devolver documento");
		System.out.println("4. Buscar documentos por titulo");
		System.out.println("5. Informe de prestamos");
		System.out.println("0. Salir");
	}
}
