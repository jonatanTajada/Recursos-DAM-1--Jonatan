package ejerciciosArrayListParaPracticar;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_1_V2 {

	 static Scanner scanner = new Scanner(System.in);
	 
	 
	public static void main(String[] args) {
		
		try {
			
			String texto = obtenerTexto();
			char letra = obtenerLetra();

			ArrayList<Integer> posicionLetra = encontrarLetra(texto, letra);

			mostrarResultado(letra, posicionLetra);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	
//-------------------------------------------------------------------------------------------------------------------------------------
//							-- METODOS --
//-------------------------------------------------------------------------------------------------------------------------------------
	

	
	// obtener texto
    public static String obtenerTexto() {
        System.out.print("Introduce un texto: ");
        return scanner.nextLine();
    }

    //obtener letra
    public static char obtenerLetra() throws IllegalArgumentException {
		char letra;
    	do {
			System.out.print("Introduce una letra: ");
			letra = scanner.next().charAt(0);

			if (!Character.isLetter(letra) || Character.isDigit(letra) || Character.isWhitespace(letra)) {
				System.err.println("El valor valida es una letra, el resto de valores no son validos");
			}

		} while (!Character.isLetter(letra) || Character.isDigit(letra) || Character.isWhitespace(letra));

        return letra;
    }

    //encontrar posiciones
	public static ArrayList<Integer> encontrarLetra(String texto, char letra) {
		
		ArrayList<Integer> indiceLetraEncontrada = new ArrayList<>();

		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == letra) {
				indiceLetraEncontrada.add(i);
			}
		}

		return indiceLetraEncontrada;
	}

	public static void mostrarResultado(char letra, ArrayList<Integer> posicion) {
		
		System.out.println("La letra '" + letra + "' aparece " + posicion.size() + " veces en el texto.");

		if (!posicion.isEmpty()) {
			
			
			
			System.out.println("Posiciones de la letra '" + letra + "': " + posicion.toString());
		} else {
			System.err.println("La letra no aparece en el texto.");
		}
	}
	
	


	
	// otra forma mas sencilla de hacerlo!!
//public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		String texto;
//		char letra;
//		int contador=0;
//		
//		System.out.print("Introduce un texto: ");
//		texto = scanner.nextLine();
//		
//	  
//		
//		do {
//			System.out.print("Introduce una palabra: ");
//			letra = scanner.next().charAt(0);
//			
//			
//			if (!Character.isLetter(letra) || Character.isDigit(letra) || Character.isWhitespace(letra)) {
//				System.err.println("El valor valida es una letra, el resto de valores no son validos");
//			}
//			
//		} while (!Character.isLetter(letra) || Character.isDigit(letra) || Character.isWhitespace(letra));
//		
//		
//		texto = texto.toLowerCase();
//		for (int i = 0; i < texto.length(); i++) {		
//			if (texto.charAt(i) == letra) {
//				contador++;
//			}
//		}
//		
//		System.out.println("La letra '" + letra + "', aparece : " + contador + " veces.");
//	}
	
}
