package ud_5ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EjArrayList {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Integer> lista = leerValores();
		
		int suma = calcularSuma(lista);
		double media = (suma/lista.size());
		mostrarResultado(lista, suma, media);
		
	}
	//Metodos
	
	public static ArrayList<Integer> leerValores (){
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int numero;
		int contador = 1;
		do {
			System.out.print((contador) + ". Introduce un numero: ");
			numero = scanner.nextInt();
			
			if (numero != -99) {
				lista.add(numero);
			}
			contador++;
		} while (numero != -99);
		
		scanner.close();
		return lista;
	}
	
	public static int calcularSuma(ArrayList<Integer> lista) {
		
		int suma = 0;
		Iterator<Integer> iterator = lista.iterator();
		
		while (iterator.hasNext()) {
			suma += (Integer) iterator.next();
		}
		return suma;
	}
	
	public static void mostrarResultado(ArrayList<Integer> lista, int suma, double media) {
		
		int superiorMedia = 0;
		System.out.println("Mostrando lista: ");

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
			
			if (lista.get(i) > media) {
				superiorMedia++;
			}
		}
		
		System.out.println("La suma de la lista es: " + suma);
		System.out.println("La media de la lista es: " + media);
		System.out.println("Total de numeros superior a la media es: " + superiorMedia);
	}
	
	
	
}
