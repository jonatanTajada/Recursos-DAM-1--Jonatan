package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Scanner;

public class Ejercicio_7EsDigito {

	//tambien lo puedo hacer con un switch o con los if-else.
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        long numero = scanner.nextLong();

        // Calcular y mostrar la cantidad de dígitos
        int cantidadDigitos = contarDigitos(numero);
        System.out.println("El número " + numero + " tiene " + cantidadDigitos + " dígitos.");

        scanner.close();
    }

    
    private static int contarDigitos(long numero) {
    	
        // Convertir el número a cadena y calcular la longitud de la cadena
        // Esto también funciona para números negativos
        return String.valueOf(Math.abs(numero)).length();
    }
		
		
}
	

