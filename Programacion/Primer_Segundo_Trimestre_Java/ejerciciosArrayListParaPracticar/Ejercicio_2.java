package ejerciciosArrayListParaPracticar;

import java.util.ArrayList;
import java.util.Scanner;


public class Ejercicio_2 {

	static Scanner scanner = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		int cantidadElementos = 10;
		int numPositivos = 0, numNegativos = 0, cantidadNumCero = 0;
		
		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		
		
		//rellenar array
		for(int i = 0; i < cantidadElementos; i++) {
			System.out.print("Introduce un numero: ");
			int numUsuario = Integer.parseInt(scanner.nextLine());
			listaNumeros.add(numUsuario);
		}
		
		
	
		
		
		// contar numeros positivos, negativos y ceros.
		for (int i = 0; i < listaNumeros.size(); i++) {
			
			if (listaNumeros.get(i) > 0) {
				numPositivos++;
			}else if(listaNumeros.get(i) < 0) {
				numNegativos++;
			}else {
				cantidadNumCero++;
			}
		}
		

		
		// Mostrar array
		if (!listaNumeros.isEmpty()) {
			
		    for (int i = 0; i < listaNumeros.size(); i++) {
		        System.out.println("#" + (i + 1) + ". Numero: " + listaNumeros.get(i));
		    }
		} else {
		    System.out.println("La lista está vacia.");
		}

		
		System.out.println("Numero total de numeros positivos es: " + numPositivos);
		System.out.println("Numero total de numeros negativo es: " + numNegativos);
		System.out.println("Numero total de numeros igual a cero es: " + cantidadNumCero);
	}
	
	
	
	
	
	
	
	
	
	
	
}
