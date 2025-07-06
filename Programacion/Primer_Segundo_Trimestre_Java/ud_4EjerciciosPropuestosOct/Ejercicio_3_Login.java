package ud_4EjerciciosPropuestosOct;

import java.util.Scanner;

public class Ejercicio_3_Login {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String contraseña = "Jonatan"; 
		int intentosMaximos = 3;
		int intentos = 0;

		while (intentos < intentosMaximos) {
			System.out.print("Introduce la contraseña: ");
			String contraseniaUsuario = scanner.nextLine();

			if (contraseniaUsuario.equals(contraseña)) {
				System.out.println("¡Enhorabuena! Has acertado la contraseña.");
				break; 
			} else {
				intentos++;
				int intentosRestantes = intentosMaximos - intentos;
				if (intentosRestantes > 0) {
					System.out.println("Contraseña incorrecta. Te quedan " + intentosRestantes + " intentos.");
				} else {
					System.out.println("Has agotado tus intentos. La contraseña era: " + contraseña);
				}
			}
		}

		scanner.close();

	}

}
