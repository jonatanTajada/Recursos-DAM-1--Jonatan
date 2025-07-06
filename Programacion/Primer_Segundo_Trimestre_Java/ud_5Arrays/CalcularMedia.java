package ud_5Arrays;

import java.util.Scanner;

public class CalcularMedia {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int cantidad = 3;
		double sumaPositivos = 0;
		double sumaNegativos = 0;
		int contadorPositivos = 0;
		int contadorNegativos = 0;
		
		int[] numeros = new int[cantidad];

		
		
		for (int i = 0; i < cantidad; i++) {
			System.out.print("Introduce el número " + (i + 1) + ": ");
			numeros[i] = scanner.nextInt();
		}

	
		for (int numero : numeros) {
			
			if (numero > 0) {
				
				sumaPositivos += numero;
				contadorPositivos++;
			} else if (numero < 0) {
				
				sumaNegativos += numero;
				contadorNegativos++;
			}
			
		}

		
		
		if (contadorPositivos > 0) {
			
			double mediaPositivos = sumaPositivos / contadorPositivos;
			System.out.println("Media de valores positivos: " + mediaPositivos);
		} else {
			
			System.out.println("No se introdujeron valores positivos.");
		}

		
		if (contadorNegativos > 0) {
			
			double mediaNegativos =  sumaNegativos / contadorNegativos;
			System.out.println("Media de valores negativos: " + mediaNegativos);
		} else {
			System.out.println("No se introdujeron valores negativos.");
		}
	}

	
	
}
