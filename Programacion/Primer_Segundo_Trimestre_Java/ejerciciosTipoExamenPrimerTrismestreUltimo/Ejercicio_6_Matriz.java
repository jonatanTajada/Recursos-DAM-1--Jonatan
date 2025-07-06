package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Random;

public class Ejercicio_6_Matriz {

	public static void main(String[] args) {
		
		int[][] arrayBidimensional = rellenarMatriz(3, 3);

		System.out.println("Mostrando matriz: ");
		mostrarMatriz(arrayBidimensional);
	}

	//*******************************************************************
	
	private static int[][] rellenarMatriz(int filas, int columnas) {
		int[][] array = new int[filas][columnas];
		Random random = new Random();

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				array[i][j] = random.nextInt(100); 
			}
		}

		return array;
	}

	
	private static void mostrarMatriz(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
