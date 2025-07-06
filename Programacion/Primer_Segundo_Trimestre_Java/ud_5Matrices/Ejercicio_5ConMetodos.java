package ud_5Matrices;

import java.util.Scanner;

public class Ejercicio_5ConMetodos {

	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int filas = 5, columnas;
		
		System.out.print("Introduce el numero de columnas que deseas: ");
		columnas = scanner.nextInt();
		
		int matriz[][] = rellenarArray(filas, columnas);
		
		mostrarArray(matriz);
		
		scanner.close();
		
	}
	

	static int[][] rellenarArray(int filas, int columnas){
		
		int matriz[][] = new int[filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				matriz[i][j] = (int)(Math.random() * 10);
			}
			System.out.println();
		}
		return matriz;
	}
	
	
	static void mostrarArray(int array[][]) {
		
		System.out.println("Mostrando array:");
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				
				System.out.printf("%-4d", array[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	
}
