package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Random;

public class Ejercicio_4ContarNumerosMultiplos {

	public static void main(String[] args) {
		
		Random random = new Random();

		int[] numeros = new int[20];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = random.nextInt(10) + 1;
		}

		System.out.println("Array original:");
		mostrarArray(numeros);

		// Cuenta los numeros cuantas veces se repite
		contarCuantasVecesRepiteNumero(numeros);
	}

	//**********************************************************
	private static void mostrarArray(int[] array) {
		for (int numero : array) {
			System.out.print(numero + " ");
		}
		System.out.println();
	}

	// Función para contar la frecuencia de cada número y mostrarla
	private static void contarCuantasVecesRepiteNumero(int[] array) {
		
		System.out.println("Total de veces de cada número:");
		// Utilizo un array para almacenar la frecuencia de cada número
		int[] numerosAgrupadosRepetidos = new int[10];

		// Contar la frecuencia de cada número en el array
		for (int numero : array) {
			numerosAgrupadosRepetidos[numero - 1]++;
		}

		// Mostrar la frecuencia de cada número
		for (int i = 0; i < numerosAgrupadosRepetidos.length; i++) {
			System.out.println("Número " + (i + 1) + ": " + numerosAgrupadosRepetidos[i] + " veces");
		}
	}

}
