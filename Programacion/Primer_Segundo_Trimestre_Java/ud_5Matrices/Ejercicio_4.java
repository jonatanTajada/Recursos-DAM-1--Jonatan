package ud_5Matrices;

import java.util.Arrays;

public class Ejercicio_4 {

	public static void main(String[] args) {

		// 1ºforma

		int filas = 3, columnas = 3;
		int contador = 1;

		int matriz[][] = new int[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				matriz[i][j] = contador++;
				//contador++;
			}
		}

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				System.out.printf("%-4d", matriz[i][j]);
			}
			System.out.println();
		}

		
		
		
		// 2º forma
//		int matriz[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
//
//		for (int i = 0; i < matriz.length; i++) {
//
//			for (int j = 0; j < matriz[0].length; j++) {
//				System.out.println(matriz[i][j]);
//			}
//		}
//
//		for (int i = 0; i < matriz.length; i++) {
//			System.out.println(Arrays.toString(matriz[i]));
//		}

	}

}
