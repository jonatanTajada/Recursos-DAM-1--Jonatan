package ejerciciosArrays7Nov;

import java.util.Scanner;

public class Ejercicio_3_ContarNumeroVecesApareceUnCaracter {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduce una texto");
		String texto = scanner.nextLine();
		
		System.out.println("Introduce el caracter que deseas contar: ");
		char caracterABuscar = scanner.next().charAt(0);
		
		int contador = contarCaracteres(texto, caracterABuscar);
		
		System.out.println("El caracter '" + caracterABuscar + "' aparece " + contador + " veces en el texto");
		
		
		
	}
	
	
	public static int contarCaracteres(String texto, char caracterABuscar) {
		
		int contador = 0;
		
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == caracterABuscar) {
				contador++;
			}
		}
		return contador;
	}
	
	
	
	
	
}
