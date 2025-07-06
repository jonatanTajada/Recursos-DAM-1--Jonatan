package ejerciciosArrayListParaPracticar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_2_ArrayList {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Integer> listaNumeros = new ArrayList<>(10);
		int numPositivos = 0, numNegativos = 0, numIgualCero = 0;
		int cantidadElementos = 10;

		// Rellenar array
		System.out.println("- Introduce " + cantidadElementos + " numeros: ");
		System.out.println("-------------------------------------------------");

		for (int i = 0; i < cantidadElementos; i++) {
			System.out.print((i + 1) + "#. Introduce un numero: ");

			try {
				int numero = scanner.nextInt();
				listaNumeros.add(numero);

				if (numero < 0) {
					numNegativos++;
				} else if (numero > 0) {
					numPositivos++;
				} else {
					numIgualCero++;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debes introducir un número válido.");
				scanner.next(); // Limpiar el búfer de entrada
				i--; // Restamos 1 a 'i' para repetir la entrada del número
			}
		}

		// Recorrer array
		System.out.println("Números ingresados:");
		for (Integer numero : listaNumeros) {
			System.out.println(numero);
		}

		System.out.println("Numero total de numeros positivos es: " + numPositivos);
		System.out.println("Numero total de numeros negativos es: " + numNegativos);
		System.out.println("Numero total de numeros igual a cero es: " + numIgualCero);
	}
}
