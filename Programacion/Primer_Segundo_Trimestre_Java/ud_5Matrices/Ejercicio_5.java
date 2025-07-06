package ud_5Matrices;


import java.util.Scanner;

public class Ejercicio_5 {


	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int filas = 5, columnas, array[][];

		System.out.print("Introduce el numero de columnas para tu matriz: ");
		columnas=scanner.nextInt();
		
		array = new int [filas][columnas];
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				array[i][j] = (int)(Math.random() * 10);
				
			}
		}
		
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.printf("%-4d", array[i][j]);
				
			}
			System.out.println();
		}
		
		scanner.close();
	}
	
	
}
