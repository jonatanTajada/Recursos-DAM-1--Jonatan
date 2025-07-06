package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_8TiendaVentasAnualesConMetodos {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] ventas = { 100, 250, 25, 68, 40 };

		comprobarValorMenor(ventas);
		comprobarValorMayor(ventas);
		importeTotalDeVentas(ventas);
		ordenarArray(ventas);
		mostrarArray(ventas);

		encontrarValorBuscado(40, ventas);
		// System.out.println("El valor buscado se encuentra en la posición: " + Arrays.binarySearch(ventas, 40));

	}

	private static void ordenarArray(int ventas[]) {
		Arrays.sort(ventas);
	}

	private static void mostrarArray(int[] ventas) {
		for (int venta : ventas) {
			System.out.println(venta + " \t");
		}
	}

	private static void comprobarValorMenor(int[] ventas) {

		if (ventas.length > 0) {

			int ventaMenor = ventas[0];
			for (int i = 1; i < ventas.length; i++) {
				if (ventas[i] < ventaMenor) {
					ventaMenor = ventas[i];
				}
			}

			System.out.println("La venta de menor importe es: " + ventaMenor);
		} else {
			System.err.println("No hay datos de ventas para comprobar el valor menor.");
		}
	}

	private static void comprobarValorMayor(int[] ventas) {

		if (ventas.length > 0) {

			int ventaMayor = ventas[0];
			for (int i = 0; i < ventas.length; i++) {
				if (ventas[i] > ventaMayor) {
					ventaMayor = ventas[i];
				}
			}
			System.out.println("El importe de la venta mayor es: " + ventaMayor);
		} else {
			System.err.println("El array no tiene valores");
		}
	}

	private static void importeTotalDeVentas(int[] ventas) {

		int sumaTotal = 0;

		for (int i = 0; i < ventas.length; i++) {

			sumaTotal += ventas[i];
		}
		System.out.println("La suma de total de las ventas es: " + sumaTotal);
	}

	private static void encontrarValorBuscado(int valorABuscar, int[] ventas) {

		for (int i = 0; i < ventas.length; i++) {

			if (ventas[i] == valorABuscar) {
				System.out.println("Hemos encontrado el valor deseado en la posicion : " + i);
			}
		}
	}

}
