package ud_5Matrices;

import java.util.Scanner;

public class Ejercicio_8MatrizCruz {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numFilas, numColumnas;
        boolean imparesCorrectos = false;

        do {
        	
            System.out.print("Ingrese el número de filas (n, impar): ");
            numFilas = scanner.nextInt();
            
            System.out.print("Ingrese el número de columnas (m, impar): ");
            numColumnas = scanner.nextInt();

            if (numFilas % 2 == 1 && numColumnas % 2 == 1) {
                imparesCorrectos = true;
            } else {
                System.err.println("Tanto el numero de filas como de columnas han de ser impares.");
            }
        } while (!imparesCorrectos);

        char[][] matriz = new char[numFilas][numColumnas];

        // Llenar la matriz con espacios en blanco
        for (int i = 0; i < numFilas; i++) {
        	
            for (int j = 0; j < numColumnas; j++) {
                matriz[i][j] = ' ';
            }
        }

        // Colocar caracteres especiales para formar la cruz
        int centroFila = numFilas / 2;
        int centroColumna = numColumnas / 2;

        for (int i = 0; i < numFilas; i++) {
            matriz[i][centroColumna] = '*';
        }

        for (int j = 0; j < numColumnas; j++) {
            matriz[centroFila][j] = '*';
        }

        // Imprimir la matriz
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
