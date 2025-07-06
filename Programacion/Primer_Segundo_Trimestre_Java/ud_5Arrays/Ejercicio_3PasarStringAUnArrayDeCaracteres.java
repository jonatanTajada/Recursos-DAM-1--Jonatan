 package ud_5Arrays;

import java.util.Scanner;

public class Ejercicio_3PasarStringAUnArrayDeCaracteres {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("Ingrese frase: ");
//		String frase = scanner.nextLine();
//		
//		char arrayChar[] = new char[frase.length()];
		//char arrayChar[]= frase.toCharArray(); esta opcion es equivalente a la linea anteior , si uso est alinea el siguiente for no me haria falta
//		
//		for (int i = 0; i < arrayChar.length; i++) {
//			
//			arrayChar[i] = frase.charAt(i);
//		}
//		
//		System.out.println("Array de caracteres procedentes de la frase introducida por el usuario");
//		for(char caracter : arrayChar) {
//			System.out.println(caracter);
//		}	
		
		///***********************************************************************
		//reliazando ejercicio con metodo
		
		System.out.println("Ingrese una frase");
		String frase = scanner.nextLine();
		
		char array[] = convertirFraseEnArrayDeCaracteres(frase);
		
		System.out.println("Mostrando array de caracteres introducida por el usuario");
		for(char caracter : array) {
			System.out.println(caracter);
		}
		
		
	}

	static char[] convertirFraseEnArrayDeCaracteres(String frase) {
		char[] letras = frase.toCharArray();
		return letras;
	}
	
	
	
	
	
	
	
	
}
