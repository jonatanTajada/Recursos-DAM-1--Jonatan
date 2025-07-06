package ejerciciosParaExamenPrimerTrimestre;

import java.util.Scanner;

/**
 * @author Jonatan comentario : solicitar al usuario que introduzca 5 numeros y
 *         despues mostrar por consola con un espacio entre numero y numero
 */
public class MostrarNumerosSeparadosEjercicio_9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		System.out.println("Introduce un número de 5 dígitos:");
		int numero = scanner.nextInt();

		
		if (numero >= 10000 && numero <= 99999) {
			// Separar los dígitos e imprimirlos
			System.out.println("Dígitos separados:");
			separarDigitos(numero);
		} else {
			System.out.println("El número no tiene 5 dígitos.");
		}

		scanner.close();
	}
	

	// Método para separar los dígitos de un número e imprimirlos
	public static void separarDigitos(int num) {
		int divisor = 10000;

		while (divisor > 0) {
			int digito = num / divisor;
			System.out.print(digito + " ");
			num %= divisor;
			divisor /= 10;
		}

		System.out.println(); 
	}
	
}






	//hacerlo sin metodo
	
//	if (numero >= 10000 && numero <= 99999) {
//        // Separar los dígitos e imprimirlos
//        System.out.println("Dígitos separados:");
//
//        int divisor = 10000;
//
//        while (divisor > 0) {
//            int digito = numero / divisor;
//            System.out.print(digito + " ");
//            numero %= divisor;
//            divisor /= 10;
//        }
//
//        System.out.println(); // Salto de línea al final
//    } else {
//        System.out.println("El número no tiene 5 dígitos.");
//    }


