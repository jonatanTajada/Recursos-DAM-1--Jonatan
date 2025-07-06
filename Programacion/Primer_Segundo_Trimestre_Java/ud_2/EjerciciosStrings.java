package ud_2;

import java.util.Scanner;

public class EjerciciosStrings {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		//Ejercicio 1
		
//		String cadena = "La casa de";
//
//		cadena += " Juan es";
//
//		cadena += " el número";
//
//		int numero = 25;
//		cadena += " " + numero;
//
//		System.out.println(cadena);
		
		
		
		//Ejercicio 3
		
		System.out.print("Introduce una palabra: ");
		String palabra =  scanner.nextLine();
		
		String primeraLetra =palabra;
		System.out.println(primeraLetra.charAt(0));
		
		String ultimaLetra= palabra;
		System.out.println(ultimaLetra.charAt(ultimaLetra.length()-1));
	
		System.out.println(ultimaLetra.substring(2, 5));
		
	}

}
