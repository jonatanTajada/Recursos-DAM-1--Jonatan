package ejerciciosArrays7Nov;

import java.util.Scanner;

public class Ejercicio_4_CalcularLetraDNI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce el número del DNI (sin la letra): ");
		int numeroDNI = scanner.nextInt();

		char letraDNI = calcularLetraDNI(numeroDNI);

		System.out.println("La letra del DNI es: " + letraDNI);

		scanner.close();
	}

	public static char calcularLetraDNI(int numeroDNI) {
		final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = numeroDNI % 23;

		return LETRAS_DNI.charAt(resto);
	}

}
