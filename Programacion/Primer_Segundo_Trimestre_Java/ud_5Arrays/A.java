package ud_5Arrays;

import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

	
public class A {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		
		introducirDatos(listaNumeros);
		System.out.println("Lsita original");
		mostrarDatos(listaNumeros);
		
		intercambiarDatos(listaNumeros, 1, 3);
		
		System.out.println("Mostrar lista cambiada");
		mostrarDatos(listaNumeros);
		
		System.out.println("Mostrar lista ordenada");
		Collections.sort(listaNumeros);
		System.out.println(listaNumeros);
		
	}
	
	
	
	
	
	
	
	private static void introducirDatos(ArrayList<Integer> lista) {
		
		System.out.print("Introduce un numero: ");
		
		while (true) {
			
			int numero = scanner.nextInt();
			if (numero < 0) {
				break;
			}
			
			lista.add(numero);
		}
		scanner.close();
	}
	
	private static void mostrarDatos(ArrayList<Integer> lista) {
		
		System.out.println("Mostrando lista:");
		for (Integer list : lista) {
			System.out.println(list + " ");
		}
		System.out.println();
	}
	
	 private static void intercambiarDatos(ArrayList<Integer> lista, int pos1, int pos2) {
		 
		 if (pos1 >= 0 && pos1 < lista.size() && pos2 >= 0 && pos2 < lista.size()) {
			
			 int aux = lista.get(pos1);
			 lista.set(pos1, lista.get(pos2));
			 lista.set(pos2, aux);
			 
		}else {
			System.out.println("posicion invlaida");
		}
	 }
	 
	 private static int sumaLista(ArrayList<Integer> lista) {
		 
		 int sumaTotal=0;
		 
		 Iterator<Integer> iterator = lista.iterator();
		 
		 while (scanner.hasNext()) {
			sumaTotal += iterator.next();
			
		}
		 
		 return sumaTotal;
	 }
}	
	
	
	

