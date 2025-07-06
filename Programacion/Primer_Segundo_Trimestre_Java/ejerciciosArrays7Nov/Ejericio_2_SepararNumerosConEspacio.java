package ejerciciosArrays7Nov;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejericio_2_SepararNumerosConEspacio {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

//		System.out.print("Introduce un número entero: ");
//		int numero = scanner.nextInt();
		
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));

		separarCifras(numero);

		scanner.close();
	}

	public static void separarCifras(int numero) {
		// Convertir el número a una cadena para facilitar la separación de cifras
		//como el parseInt pero al reves.. de numero a String
		String numeroStr = Integer.toString(numero);

		// Iterar a través de la cadena e imprimir cada cifra separada por un espacio
		for (int i = 0; i < numeroStr.length(); i++) {
			System.out.print(numeroStr.charAt(i) + " ");
		}
	}

}
