package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio_3ArrayMultiples {

//	Programa que genere un array de 20 número aleatorios entre 1 y 100 
//	y que se muestren por pantalla, 
//	después deben mostrarse cuales son múltiplos de 2, de 3 y de 5.
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		
		int[] numeros = new int[10];
		Random random = new Random();
		
		System.out.println("***Rellenar array con numeros aleatorio***");
		for (int i = 0; i < numeros.length; i++) {

			numeros[i] = random.nextInt(100) + 1;
			System.out.println("Numero " + (i+1) + numeros[i] + " ");
		}
		
		System.out.println("***Mostrar multiplos de 2***");
		for (int numero : numeros) {
			if (numero % 2 == 0) {
				System.out.println(numero + " ");
			}
		}
		
		
		System.out.println("***Mostrar multiplos de 3***");
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] % 3 == 0) {
				System.out.println(numeros[i] + " ");
			}
		}
		
		System.out.println("***Mostrar multiplo de 5***");
		for (int numero : numeros) {
			if (numero % 5 == 0) {
				System.out.println(numero + " ");
			}
		}
		
		
		// a usar con metodos
		
//		int[] lista = generarArrayAleatorio();
//		mostrarArray(lista);
//		System.out.println();
//		mostrarMultiplos(lista, 2);
//		mostrarMultiplos(lista, 3);
//		mostrarMultiplos(lista, 5);
		
	}
	
	//metodos
	
//	public static int[] generarArrayAleatorio() {
//		
//		Random  random = new Random();
//		System.out.println("Introduce la cantidad de elementos que deseas para tu array");
//		int cantidadElementos = scanner.nextInt();
//		int[] arrayAleatorio = new int[cantidadElementos];
//		
//		for (int i = 0; i < arrayAleatorio.length; i++) {
//			
//			arrayAleatorio[i] = random.nextInt(10);
//		}
//		
//		return arrayAleatorio;
//		
//	}
//	
// 	
//	public static void mostrarArray(int[] array) {
//		
//		System.out.println("MOSTRAR ARRAY");
//		for (int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + " ");
//		}
//	}
//	
//	public static void mostrarMultiplos(int[] array, int multiplo) {
//		System.out.println("Multiplos de " + multiplo );
//		
//		for (int i = 0; i < array.length; i++) {
//			if (array[i] % multiplo == 0) {
//				System.out.println(array[i]);
//			}
//		}
//	}
	
}
