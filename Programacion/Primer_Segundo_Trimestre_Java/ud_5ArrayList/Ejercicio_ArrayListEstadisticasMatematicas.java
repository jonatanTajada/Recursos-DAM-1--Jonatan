package ud_5ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_ArrayListEstadisticasMatematicas {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Integer> valores = leerValores();
		
		int suma = calcularSuma(valores);
		
		double media = (double) suma / valores.size();
		
		mostarResultados(valores, suma, media);
	}
	
	
	
	//*********************************************************************************
	
	//Metodo para leer los valores desde el teclado y almacenarlos en el ArrayList
	private static ArrayList<Integer> leerValores(){
		ArrayList<Integer> valores = new ArrayList<Integer>();
		
		System.out.println("Introduce numero, si deseas finalizar introduce -99 ");
		
		int valor;
		int contador = 1;
		
		do {
			System.out.println("Numero " + contador + ": ");
			valor = scanner.nextInt();
			
			if (valor != -99) {
				valores.add(valor);
				contador++;
			}
		} while (valor != -99);
		
		scanner.close();
		return valores;
	}
	
	
	//Realiza la suma de todos los elemntos del arraylist
	private static int calcularSuma(ArrayList<Integer> valores) {
		
		int suma = 0;
		
		for (Integer valor : valores) {
			suma += valor;
		}
		
		return suma;
	}
	
	
	private static void mostarResultados(ArrayList<Integer> valores, int suma, double media) {
		
		System.out.println("Numero de valores leidos en el array: " + valores.size());
		System.out.println("La suma de los valores del array es: " + suma);
		System.out.println("La media de los valores es: " + media);
		
		//contar cuantos valores osn mayores que la media
		int mayoresQueMedia = 0;
		
		for (Integer valor : valores) {
			if (valor > media) {
				mayoresQueMedia++;
			}
		}
		
		System.out.println("Numero total de valores mayor que la media: " + mayoresQueMedia);
		
		
		//mostrar todos los valores
		System.out.println("Mostrando datos del array: ");
		for (Integer valor : valores) {
			System.out.println(valor + " ");
		}
		
		
	}
	
	
	
}
