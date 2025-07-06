package ejercicio_Loterias;

import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class Juegos {

	static Scanner scanner = new Scanner(System.in);
	private static double totalCosto = 0;
	private static Random random = new Random();

	public static void main(String[] args) {

		Juegos juegos = new Juegos();
		juegos.iniciarJuegos();
		scanner.close();
	}

//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------

	// iniciarJuego
	public void iniciarJuegos() {
		int opcion;
		String continuar;
		
		do {
			
			do {
				opcion = mostrarMenu();

				if (opcion < 1 || opcion > 4) {
					System.err.println("Error, introduce una opcion valida");
				}

			} while (opcion < 1 || opcion > 4);
			

			switch (opcion) {
			case 1:
				jugarPrimitiva();
				break;
			case 2:
				jugarQuiniela();
				break;
			case 3:
				jugarLoteriaNacional();
				break;
			case 4:
				break;

			default:
				System.out.println("Opcion no valida. Por favor, elige una opcion correcta.");
				break;
			}

			System.out.println("\nDeseas volver apostar?:(si/no)");
			continuar = scanner.next();

			if (!continuar.equalsIgnoreCase("si")) {
				break;
			}

		} while (continuar.equalsIgnoreCase("si"));

		System.out.println("Total a pagar por el total de apuestas es : " + totalCosto + " €.\nGracias por jugar y suerte!");
	}

	//menu
	private int mostrarMenu() {
		System.out.println(".........................");
		System.out.println("LOTERIAS Y APUESTAS ");
		System.out.println(".........................");
		System.out.println("1. Jugar Primitiva");
		System.out.println("2. Jugar Quiniela");
		System.out.println("3. Jugar Loteria Nacional");
		System.out.println("4. Salir");
		System.out.print("Elige una opcion: ");

		return scanner.nextInt();
	}

// ---------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------------------
	// JUGAR-PRIMITIVA
	public static void jugarPrimitiva() {
		// Obtener la fecha de hoy
		LocalDate fechaHoy = LocalDate.now();

		// Calcular la fecha del próximo jueves
		LocalDate proximoJueves = fechaHoy.with(DayOfWeek.THURSDAY);

		// Formatear la fecha en un formato deseado
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM 'de' yyyy");
		String fechaProximoSorteo = proximoJueves.format(formatoFecha);

		// Generar los 6 numeros aleatorios entre 1 y 49
		int[] numeros = new int[6];
		
		for (int i = 0; i < 6; i++) {
			int numeroAleatorio;
			boolean repetido;

			do {
				numeroAleatorio = random.nextInt(49) + 1;
				repetido = false;

				// Verificar si el numero ya existe en el array
				for (int j = 0; j < i; j++) {
					if (numeros[j] == numeroAleatorio) {
						repetido = true;
						break;
					}
				}
			} while (repetido);

			numeros[i] = numeroAleatorio;
		}

		// Imprimir  informacion de la apuesta
		System.out.println("\nPróximo sorteo: " + fechaProximoSorteo);
		System.out.print("\nApuesta:");
		for (int numero : numeros) {
			System.out.print(" " + numero);
		}
		System.out.println("\nComplementario: " + (random.nextInt(49) + 1) + "\nReintegro: " + (random.nextInt(9) + 1));

		totalCosto += 1.0;
	}

// ---------------------------------------------------------------------------------------------------------------------------------------	
// ----------------------------------------------------------------------------------------------------------------------------------------
	// JUGAR-QUINIELA
	public static void jugarQuiniela() {
		//fecha
		LocalDate fechaHoy = LocalDate.now();
		LocalDate proximoDomingo = fechaHoy.with(DayOfWeek.SUNDAY);
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM 'de' yyyy");
		String fechaProximaJornada = proximoDomingo.format(formatoFecha);

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("\nPróxima jornada: " + fechaProximaJornada);

		int totalApuestas;

		do {
			System.out.print("¿Cuantas apuestas quieres (2-8)? ");
			totalApuestas = scanner.nextInt();
		} while (totalApuestas < 2 || totalApuestas > 8);

		for (int i = 1; i <= totalApuestas; i++) {
			generarApuestaQuiniela(i);
			totalCosto += 0.5;
		}

		System.out.println("\nVoleto valido.\nImporte total a pagar: " + totalCosto + " €.");
	}

// -----------------------------------------------------------------------
	// Ambos metodos generan los partudos y pone resultado aleatoriamente
	private static void generarApuestaQuiniela(int apuestaNumero) {
		System.out.println("\nApuesta " + apuestaNumero + ":");
		for (int partido = 1; partido <= 15; partido++) {
			char resultado = generarResultadoPartido();
			System.out.print(resultado + "\t");
		}
		System.out.println();
	}

// -------------------------------------------------
	private static char generarResultadoPartido() {
		int resultado = random.nextInt(3);

		if (resultado == 0) {
			return 'X';
		} else if (resultado == 1) {
			return '1';
		} else {
			return '2';
		}
	}

// ---------------------------------------------------------------------------------------------------------------------------------------	
//	---------------------------------------------------------------------------------------------------------------------------------------
	// JUGAR-LOTERIA_NACIONAL
	public static void jugarLoteriaNacional() {
		//fecha
		LocalDate fechaHoy = LocalDate.now();	
		LocalDate proximoSabado = fechaHoy.with(DayOfWeek.SATURDAY);
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaProximoSorteo = proximoSabado.format(formatoFecha);

		System.out.println("\nLotería Nacional - Próximo sorteo: Sabado, " + fechaProximoSorteo);

		// Preguntar al usuario si desea introducir las 3 ultimas cifras
		System.out.print("\nQuieres introducir las 3 ultimas cifras del numero? (si/no): ");
		String respuesta = scanner.next();

		// Obtener las 3 ultimas cifras usando el metodo actualizado
		int terminacion;
		if (respuesta.equalsIgnoreCase("si")) {
			terminacion = obtenerTerminacion();
		} else {
			terminacion = generarTerminacionAleatoria();
		}

		// Generar numero de 5 cifras con la terminacion indicada
		int numero = generarNumero(terminacion);

		// Generar la serie (3 cifras) y la fraccion (2 cifras)
		int serie = random.nextInt(900) + 100; 
		int fraccion = random.nextInt(90) + 10; 

		// Mostrar el resultado
		System.out.println("\nNumero: " + numero);
		System.out.println("Serie: " + serie);
		System.out.println("Fraccion: " + fraccion);

		// Calcular el costo total
		totalCosto += 12.0;
		System.out.println("Total a pagar: " + totalCosto + " €");
	}

// -------------------------------------------
	// Elegir 3 últimas cifras
	private static int obtenerTerminacion() {
		int terminacion;
		do {
			System.out.println("Elige las 3 ultimas cifras del numero:");
			terminacion = scanner.nextInt();

			if (terminacion < 0 || terminacion > 999) {
				System.out.println("Error. Debes ingresar exactamente 3 números.");
			}

		} while (terminacion < 0 || terminacion > 999);

		return terminacion;
	}

	// Generar aleatoriamente las 3 ultimas cifras
	private static int generarTerminacionAleatoria() {
		return random.nextInt(1000);
	}

// --------------------------------------------------------------------------------	
//			un codigo de locos, seguro que hay una forma mucho mas sencillo		   |
//			esto es lo que encontrado por ahi, no sabia muy bien como hacerlo.	   |
//  -------------------------------------------------------------------------------
	// Generar un numero de 5 cifras con la terminacion indicada
	private static int generarNumero(int terminacion) {
		int numeroBase = random.nextInt(90000) + 10000; // Números aleatorios entre 10000 y 99999
		int numeroFinal = (numeroBase / 1000) * 1000 + terminacion; // Conservar las primeras 2 cifras y agregar las 3
																	// últimas cifras

		// Mostrar los 3 últimos dígitos elegidos por el usuario
		System.out.println("Los 3 ultimos digitos elegidos: " + terminacion);

		return numeroFinal;
	}
	
// ---------------------------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------------------------

	
}
