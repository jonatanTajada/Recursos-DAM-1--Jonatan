package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Scanner;

public class Ejercicio_1 {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
//		Programa que te pide 10 números por teclado y
//		te hace la media de los números primos introducidos y 
//		si no se introduce ninguno te dice que no puede hacerte la media.

		
		rellenarArray();
		
	}
	
	private static int[] numeros = new int[10];
	private static int contadorPrimos = 0;
	private static int sumaPrimos = 0;
	
	
	//metodo para rellenar array de nuymeros primos
	public static void rellenarArray() {
		
		System.out.println("Introduce 10 numeros ");
		
		for (int i = 0; i < numeros.length; i++) {
			
			System.out.println("Numero " + (i+1) + ": ");
			numeros[i] = scanner.nextInt();
			
			if (esPrimo(numeros[i])) {
				contadorPrimos++;
				sumaPrimos += numeros[i];
			}
		}
		
		
		if (contadorPrimos > 0) {
			double mediaPrimos = (double) sumaPrimos / contadorPrimos;
			System.out.println("La media de los numeros primos introducidos es: " + mediaPrimos);
			
		}else {
			System.out.println("No se puede realizar la suma porque no hay numeros primos en el array");
		}
		
		scanner.close();
		
	}
	

	   // Función para verificar si un número es primo
	    private static boolean esPrimo(int numero) {
	        if (numero <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(numero); i++) {
	            if (numero % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    
}

	
	

