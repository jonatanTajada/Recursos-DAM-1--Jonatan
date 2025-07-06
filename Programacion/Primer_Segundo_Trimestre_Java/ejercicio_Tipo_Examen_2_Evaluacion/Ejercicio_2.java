package ejercicio_Tipo_Examen_2_Evaluacion;

import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce valor de A: ");
		int a = scanner.nextInt();

		
		int b;
		do {
			System.out.print("Introduce valor de B (debe ser mayor que A): ");
			b = scanner.nextInt();

			if (b < a) {
				System.err.println("Error: El valor de B debe ser mayor que el valor de A. Intenta de nuevo.");
			}
		} while (b < a);

		int[] listaNumeros = new int[20];

		// rellenar array de numeros aleatorios
		for (int i = 0; i < listaNumeros.length; i++) {
			listaNumeros[i] = generarNumAleatorios(a, b);
		}
		// mostrar array
		System.out.println("Numeros aleatorios entre " + a + " y " + b + ":");
		mostrarArray(listaNumeros);

	}

	// 						---------------
	//						 *** METODOS ***
	// 						----------------

	// generar numeros aleatorios entre un rango de dos numeros (a-b)
	public static int generarNumAleatorios(int a, int b) {
		return (int) (Math.random() * (b - a + 1) + a);
	}

	// mostrar array lista numeros
	public static void mostrarArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " - ");
		}
	}

}
