package BateriasEjerciciosPracticaExamenPOO;

import java.util.Scanner;

public class Ejercicio1_ArrayListParaPracticar {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String texto;
		char letra;

		texto = pedirTexto(scanner);

		letra = pedirLetra(scanner);

		int contador = contarLetra(texto, letra);

		mostrarResultado(letra, contador);

		scanner.close();

	}

	public static void mostrarResultado(char letra, int contador) {
		System.out.println("La letra '" + letra + "' aparece " + contador + " veces en el texto.");
	}

	public static char pedirLetra(Scanner scanner) {
		char letra;
		System.out.println("Introduce una palabra");
		letra = scanner.next().charAt(0);
		return letra;
	}

	public static String pedirTexto(Scanner scanner) {
		String texto;
		System.out.println("Introduce un texto");
		texto = scanner.nextLine();
		return texto;
	}

	public static int contarLetra(String texto, char letra) {
		int contador = 0;

		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == letra) {
				contador++;
			}
		}

		return contador;
	}

}
