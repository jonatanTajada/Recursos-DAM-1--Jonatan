package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_9IntercambioPosicionesArrayList {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Integer> listaNumeros = new ArrayList<>();

		introducirDatos(listaNumeros);

		System.out.println("Lista original:");
		mostrarDatos(listaNumeros);

		intercambiarDatos(listaNumeros, 1, 3);

		System.out.println("\nLista después del intercambio:");
		mostrarDatos(listaNumeros);
	}
	
	//*****************************

	// Método para introducir datos en la lista
	private static void introducirDatos(ArrayList<Integer> lista) {
		
		System.out.println("Introduce números enteros (introduce un número negativo para terminar):");

		while (true) {
			int numero = scanner.nextInt();
			if (numero < 0) {
				break; // Salir del bucle si se introduce un número negativo
			}
			lista.add(numero);
		}

		scanner.close();
	}

	// Método para mostrar los datos de la lista
	private static void mostrarDatos(ArrayList<Integer> lista) {
		for (int numero : lista) {
			System.out.print(numero + " ");
		}
		System.out.println();
	}

	// Método para intercambiar datos en la lista
	private static void intercambiarDatos(ArrayList<Integer> lista, int posicion1, int posicion2) {
		if (posicion1 >= 0 && posicion1 < lista.size() && posicion2 >= 0 && posicion2 < lista.size()) {
			// Intercambiar los números en las posiciones especificadas
			int aux = lista.get(posicion1);
			lista.set(posicion1, lista.get(posicion2));
			lista.set(posicion2, aux);
		} else {
			System.out.println("Posiciones de intercambio inválidas.");
		}
	}

}
