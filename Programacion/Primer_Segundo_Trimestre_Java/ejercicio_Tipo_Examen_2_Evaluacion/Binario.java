package ejercicio_Tipo_Examen_2_Evaluacion;

import java.util.Random;
import java.util.Scanner;

public class Binario {
	
	private int[] V;

	// Constructor
	public Binario(int longitud) {
		V = new int[longitud];
	}

	
	
// 						---------------
//						 *** METODOS ***
// 						----------------
	
	// llenar arrat de numeros aleatorios entre 0 y 1
	public void llenarBinario() {
		Random random = new Random();
		for (int i = 0; i < V.length; i++) {
			V[i] = random.nextInt(2);
		}
	}

	// mostrar el numero binario en el orden correcto
	public void mostrar() {
		System.out.print("El numero binario es: ");
		for (int i = V.length - 1; i >= 0; i--) {
			System.out.print(V[i]);
		}
		System.out.println();
	}

	// convertir el numero binario a decimal
	public int pasarBaseDiez() {
		
		int decimal = 0;
		int potencia = 0;
		
		for (int i = V.length - 1; i >= 0; i--) {
			decimal += V[i] * Math.pow(2, potencia);
			potencia++;
		}
		return decimal;
	}

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Introduce longitud del número binario: ");
			int longitud = Integer.parseInt(scanner.nextLine());

			// Crear objeto Binario
			Binario binario = new Binario(longitud);

			// Llenar array con numeros binarios
			binario.llenarBinario();

			// Mostrar el numero binario
			binario.mostrar();

			// Calcular y mostrar el valor en decimal
			int valorDecimal = binario.pasarBaseDiez();
			
			System.out.println("El valor en decimal es: " + valorDecimal);
		} catch (NumberFormatException e) {
			System.out.println("Error: Ingrese una longitud válida.");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
