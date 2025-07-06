package ud_5Matrices;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio_6 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		int totalPersonas;
		int alturaMayorMedia = 0, alturaMenorMedia = 0;
		String continuar;

		do {

			double sumaAlturas = 0;
			double media = 0;
			alturaMayorMedia = 0;
			alturaMenorMedia = 0;

			do {
				System.out.println("Cuantas personas quieres introducir:");
				totalPersonas = scanner.nextInt();

				if (totalPersonas <= 0) {
					System.err.println("Introduce un número positivo mayor que cero.");
				}

			} while (totalPersonas <= 0);

			double[] arrayPersonas = new double[totalPersonas];

			System.out.println("*** Introducir datos en el array ****");

			for (int i = 0; i < arrayPersonas.length; i++) {
				
				System.out.print("Introduce la altura de la persona " + (i + 1) + ": ");
				arrayPersonas[i] = scanner.nextDouble();
				sumaAlturas += arrayPersonas[i];
			}

			media = sumaAlturas / totalPersonas;

			for (int i = 0; i < arrayPersonas.length; i++) {
				if (arrayPersonas[i] > media) {
					alturaMayorMedia++;
				} else {
					alturaMenorMedia++;
				}
			}

			System.out.println("La altura media del total de las personas en el array es: " + media);
			System.out.println("Cantidad de personas con la altura superior a la media: " + alturaMayorMedia);
			System.out.println("Cantidad de personas con la altura inferior a la media: " + alturaMenorMedia);

			System.out.println("¿Quieres introducir más personas? (si/no)");
			continuar = scanner.next();

		} while (continuar.equalsIgnoreCase("si"));

	}

}
