package ud_1;

import java.util.Scanner;

public class CambioDeRueda {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		
		System.out.print("¿Están las tuercas de la rueda pinchada aflojadas? (S/N): ");
		String tuercasAflojadas = scanner.nextLine().trim().toUpperCase();
		
		if (tuercasAflojadas.equals("S")) {
			System.out.println("¡Excelente! Continuemos con el proceso de cambio de rueda.");

			System.out.println("1. Desinflando la rueda pinchada...");
			System.out.println("2. Elevando el coche con el gato...");
			System.out.println("3. Quitando la rueda pinchada...");
			System.out.println("4. Colocando la rueda de repuesto...");
			System.out.println("5. Volviendo a colocar las tuercas...");
			System.out.println("6. Bajando el coche...");
			System.out.println("7. Apretando las tuercas de la rueda...");
			System.out.println("8. Verificando la presión de la rueda de repuesto...");
			System.out.println("9. Terminado. Conduce con precaución al taller de reparación.");

		} else if (tuercasAflojadas.equals("N")) {
			System.out.println("Por favor, afloje las tuercas de la rueda antes de continuar.");
		} else {
			System.out.println("Respuesta no válida. Por favor, responda con 'S' o 'N'.");
		}

		scanner.close();
	}
}
