package BateriasEjerciciosPracticaExamenPOO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2_ArrayListParaPracticar {

	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//-----------Con un Array-------------------------------------------------------------------		
		int contadorP, contadorN, ContarC;
		int cantidadElmentos = 10;
		int listaNumeros[] = new int[cantidadElmentos];

		rellenarArrayNumeros(scanner, listaNumeros);
//-------------Con un ArrayList--------------------------------------------------------------

		List<Integer> listaNumeros2 = new ArrayList<>(cantidadElmentos);
		
		rellenarArrayListNumeros(scanner, listaNumeros2);
	}
	
	
	
//-----------------------------------------------------------------------------------------------|	
//--------*** METODOS ***------------------------------------------------------------------------|	
//-----------------------------------------------------------------------------------------------|	
	
	public static void rellenarArrayListNumeros(Scanner scanner, List<Integer> listaNumeros2) {
		System.out.println("\nRellenar ArrayList:\n----------------------------");
		for (int i = 0; i < 10; i++) {
			System.out.println((i+1) + "#. Introduce numero: ");
			int numero = scanner.nextInt();
			listaNumeros2.add(numero);
			System.out.println();
		}
		
		
		System.out.println("\nMostrando lista numeros: \n--------------------------------" + listaNumeros2);
	}

	
	public static void rellenarArrayNumeros(Scanner scanner, int[] listaNumeros) {
		System.out.println("Rellenar array:\n--------------");
		for (int i = 0; i < listaNumeros.length; i++) {
			System.out.println((i + 1) + "#. Introduce numero");
			listaNumeros[i] = scanner.nextInt();
			System.out.println();
		}

		System.out.println("\nMostrando lista numeros: " + Arrays.toString(listaNumeros));
	}
	

	
}
