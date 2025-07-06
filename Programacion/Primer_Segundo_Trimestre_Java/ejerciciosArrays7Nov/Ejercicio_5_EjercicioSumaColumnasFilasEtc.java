package ejerciciosArrays7Nov;

import java.util.Scanner;

public class Ejercicio_5_EjercicioSumaColumnasFilasEtc {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[][] matriz = new int[4][4];
		boolean matrizLlena = false;

		do {
			int opcion=0;
			do {
				System.out.println("Menú:");
				System.out.println("1. Rellenar la matriz");
				System.out.println("2. Suma de una fila");
				System.out.println("3. Suma de una columna");
				System.out.println("4. Sumar la diagonal principal");
				System.out.println("5. Sumar la diagonal inversa");
				System.out.println("6. Media de todos los valores");
				System.out.println("7. Salir");
				System.out.print("Elige una opción: ");

				opcion = scanner.nextInt();
				
				if (opcion < 1 || opcion > 7) {
		            System.err.println("Opción no válida. Introduce un número entre 1 y 7.");
		        }
				
			} while (opcion < 0|| opcion > 7 );

			//scanner.nextLine();
			
			switch (opcion) {
			case 1:
				matrizLlena = rellenarMatriz(matriz);
				break;
			case 2:
				if (matrizLlena) {
					
					System.out.print("Introduce el número de fila (0-3): ");
					int fila = scanner.nextInt();
					
					if (fila >= 0 && fila < 4) {
						int sumaFila = sumarFila(matriz, fila);
						System.out.println("La suma de la fila " + fila + " es: " + sumaFila);
					} else {
						System.out.println("Fila incorrecta. Debe ser un número entre 0 y 3.");
					}
				} else {
					System.out.println("Debes rellenar la matriz primero.");
				}
				break;
			case 3:
				if (matrizLlena) {
					System.out.print("Introduce el número de columna (0-3): ");
					int columna = scanner.nextInt();
					if (columna >= 0 && columna < 4) {
						int sumaColumna = sumarColumna(matriz, columna);
						System.out.println("La suma de la columna " + columna + " es: " + sumaColumna);
					} else {
						System.out.println("Columna incorrecta. Debe ser un número entre 0 y 3.");
					}
				} else {
					System.out.println("Debes rellenar la matriz primero.");
				}
				break;
			case 4:
				if (matrizLlena) {
					int sumaDiagonalPrincipal = sumarDiagonalPrincipal(matriz);
					System.out.println("La suma de la diagonal principal es: " + sumaDiagonalPrincipal);
				} else {
					System.out.println("Debes rellenar la matriz primero.");
				}
				break;
			case 5:
				if (matrizLlena) {
					int sumaDiagonalInversa = sumarDiagonalInversa(matriz);
					System.out.println("La suma de la diagonal inversa es: " + sumaDiagonalInversa);
				} else {
					System.out.println("Debes rellenar la matriz primero.");
				}
				break;
			case 6:
				if (matrizLlena) {
					double media = calcularMedia(matriz);
					System.out.println("La media de todos los valores de la matriz es: " + media);
				} else {
					System.out.println("Debes rellenar la matriz primero.");
				}
				break;
			case 7:
				System.out.println("Saliendo del programa. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Inténtalo de nuevo.");
				break;
			}

		} while (true);
	}

	
	//*************METODOS*******************
	
	private static boolean rellenarMatriz(int[][] matriz) {
		boolean matrizLlena = false;
		System.out.println("Rellenar la matriz:");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print("Introduce el valor en la posición [" + i + "][" + j + "]: ");
				matriz[i][j] = scanner.nextInt();
			}
		}

		matrizLlena = true;
		System.out.println("Matriz rellenada correctamente.");
		return matrizLlena;
	}

	private static int sumarFila(int[][] matriz, int fila) {
		int suma = 0;
		for (int j = 0; j < matriz[0].length; j++) {
			suma += matriz[fila][j];
		}
		return suma;
	}

	private static int sumarColumna(int[][] matriz, int columna) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			suma += matriz[i][columna];
		}
		return suma;
	}

	private static int sumarDiagonalPrincipal(int[][] matriz) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			suma += matriz[i][i];
		}
		return suma;
	}

	private static int sumarDiagonalInversa(int[][] matriz) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			suma += matriz[i][matriz.length - 1 - i];
		}
		return suma;
	}

	private static double calcularMedia(int[][] matriz) {
		int totalValores = matriz.length * matriz[0].length;
		int suma = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				suma += matriz[i][j];
			}
		}

		return (double) suma / totalValores;
	}
}
