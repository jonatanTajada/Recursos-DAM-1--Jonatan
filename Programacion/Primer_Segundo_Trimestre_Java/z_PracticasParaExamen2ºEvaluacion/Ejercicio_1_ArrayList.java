package z_PracticasParaExamen2ºEvaluacion;

import java.util.*;

public class Ejercicio_1_ArrayList {

	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String texto;
		char letra;
		int contador=0;
		
		System.out.print("Introduce un texto: ");
		texto = scanner.nextLine();
		
	  
		
		do {
			System.out.print("Introduce una palabra: ");
			letra = scanner.next().charAt(0);
			
			
			if (!Character.isLetter(letra) || Character.isDigit(letra) || Character.isWhitespace(letra)) {
				System.err.println("El valor valida es una letra, el resto de valores no son validos");
			}
			
		} while (!Character.isLetter(letra) || Character.isDigit(letra) || Character.isWhitespace(letra));
		
		
		texto = texto.toLowerCase();
		for (int i = 0; i < texto.length(); i++) {		
			if (texto.charAt(i) == letra) {
				contador++;
			}
		}
		
		System.out.println("La letra '" + letra + "', aparece : " + contador + " veces.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
