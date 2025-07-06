package ejerciciosParaExamenPrimerTrimestre;

import java.util.Scanner;

/**
 *  @author Jonatan
 * comentario : este ejericio lo que hace es saber si los numeros a introducir son multiplos entre si
 */

public class NumerosMultiplosEjercicio_5 {

	public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Intorduce el primer número: ");
        int numero1 = scanner.nextInt();

        
        System.out.print("Introduce el segundo número: ");
        int numero2 = scanner.nextInt();

        
        if (esMultiplo(numero1, numero2)) {
            System.out.println(numero1 + " es múltiplo de " + numero2);
            
        } else {
            System.out.println(numero1 + " no es múltiplo de " + numero2);
        }

        
        scanner.close();
    }

    
    private static boolean esMultiplo(int num1, int num2) {
       
        return num1 % num2 == 0;
    }
	
	
	
}
