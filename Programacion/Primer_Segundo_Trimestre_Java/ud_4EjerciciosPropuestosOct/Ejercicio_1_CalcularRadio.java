package ud_4EjerciciosPropuestosOct;

import java.util.Scanner;

public class Ejercicio_1_CalcularRadio {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Por favor, ingresa el valor del radio del círculo: ");
		String radioStr = scanner.nextLine();

		try {
			double radio = Double.parseDouble(radioStr);
			double area = Math.PI * Math.pow(radio, 2);

			System.out.println("El área del círculo con radio " + radio + " es: " + area);
		} catch (NumberFormatException e) {
			System.err.println("El valor ingresado no es un número válido.");
		}

		scanner.close();

	}

}
