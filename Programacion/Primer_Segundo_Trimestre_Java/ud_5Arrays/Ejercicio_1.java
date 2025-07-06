package ud_5Arrays;

import java.util.Arrays;

public class Ejercicio_1 {

	
	public static void main(String[] args) {
		
		int sumaNumeros=0, cantidadFilas = 100;
		double media=0;
		
		int arrayNumeros[] = new int[cantidadFilas];
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			
			arrayNumeros[i]= i + 1;

		}
		

		for (int i = 0; i < arrayNumeros.length; i++) {
			sumaNumeros += arrayNumeros[i];
			
			System.out.printf("%-5s", arrayNumeros[i]);
		}
		
		System.out.println();
		
		media = (double) (sumaNumeros / cantidadFilas);
		
		System.out.println("La media del array es: " + media);
		
	}
	
	//metodos
	
	 public static void rellenarArrayYMostrar(int[] numeros) {
		 
			
		 for (int i = 0; i < numeros.length; i++) {
			numeros[i] = i;
		} 
		 
		 System.out.println(Arrays.toString(numeros));
	 }
	 
	 public static void sumarArray(int[] numeros) {
		 
		 int sumaTotal = 0;

		 for (int i = 0; i < numeros.length; i++) {
			
			numeros[i] = i;
			sumaTotal += i;
		}
		 System.out.println("La suma del array es: " + sumaTotal);
		 
	 }
	 
	 public static void mediaArray(int[] numeros) {
		 
		 double media=0;
		 int sumaTotal = 0;
		 for (int i = 0; i < numeros.length; i++) {
			numeros[i]= i;
			sumaTotal += i;
		}
		 
		 media = (sumaTotal/numeros.length);
		 System.out.println("La media es: " + media);
	 }
}
