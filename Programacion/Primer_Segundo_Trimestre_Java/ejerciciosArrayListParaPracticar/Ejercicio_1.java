package ejerciciosArrayListParaPracticar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio_1 {

	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un texto: ");
		String texto = scanner.nextLine();
		
		System.out.print("Ingrese una letra: ");
		String letraInput = scanner.next();

		// Validar que se haya ingresado una sola letra
		if (letraInput.length() != 1) {
			System.out.println("Ingrese solo una letra.");
			scanner.close();
			return;
		}

		char letra = letraInput.charAt(0);
        
		ArrayList<Integer> posiciones = new ArrayList<Integer>();
		
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == letra) {
				posiciones.add(i);
			}
		}
		
		 // Mostrar el resultado
        System.out.println("La letra: '" + letra + "' aparece " + posiciones.size() + " veces en el texto.");

		if (posiciones.size() > 0) {
			System.out.println("Posiciones de la letra '" + letra + " ': " + posiciones.toString());
		}else {
            System.out.println("La letra no aparece en el texto.");
        }

        scanner.close();
		
	}
	
	
	
}
