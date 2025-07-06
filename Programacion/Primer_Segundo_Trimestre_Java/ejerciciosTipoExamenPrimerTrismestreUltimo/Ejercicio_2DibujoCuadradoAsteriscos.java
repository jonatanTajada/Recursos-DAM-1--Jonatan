package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Scanner;

public class Ejercicio_2DibujoCuadradoAsteriscos {

//	Programa que pinta un cuadrado con 2 asteriscos como borde 
//	según el ancho que un usuario ha introducido por teclado

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		rellenarCuadradoConAstericos();

	}

	public static void rellenarCuadradoConAstericos() {

		System.out.print("Introduce la anchura del cuadrado, minimo 5 columnas: ");
		int anchuraCuadrado = scanner.nextInt();

		// la anchura del dibujo
		while (anchuraCuadrado < 5) {
			System.err.println("La anchura debe ser como mínimo 5 columnas, intentelo de nuevo.");
			System.out.print("Introduce la anchura del cuadrado (mínimo 5): ");
			anchuraCuadrado = scanner.nextInt();
		}

		// Imprimir el cuadrado
		for (int i = 1; i <= anchuraCuadrado; i++) {
			for (int j = 1; j <= anchuraCuadrado; j++) {
				// Imprimir asteriscos en los bordes y espacios en el interior
				// Imprimir las dos primeras y dos últimas filas
				if ((i == 1 || i == 2 || i == anchuraCuadrado - 1 || i == anchuraCuadrado)
						|| (j == 1 || j == 2 || j == anchuraCuadrado - 1 || j == anchuraCuadrado)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(); // Nueva línea después de cada fila
		}

		scanner.close();

	}
}
