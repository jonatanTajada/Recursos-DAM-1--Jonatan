package ejerciciosParaExamenPrimerTrimestre;

import java.util.Scanner;

/**
 * @author Jonatan
 * comentario: este programa lo que hace es resolver una ecuacion de primer grado
 */
public class EcuacionPrimerGradoEjercicio_7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		
		double c1, c2,x;
		
		
		System.out.println("Introduce el primer coeficiente");
		c1 = scanner.nextDouble();
		
		System.out.println("Introduce el segundo coeficiente");
		c2 = scanner.nextDouble();
		
		//verificar si la ecuacion es de 1º grado
		if (c1 == 0) {
			System.out.println("La ecuacion no es de pimer grado, el primer numero no puede ser un cero ");
		}else {
			//calculamos el valor de x
			x = -c2 / c1;
			
			//mostramos la solucion
			System.out.println("La solucion de la exuacion " + c1 + " x + " + c2 + " = 0 es: ");
			System.out.println("x = " + x);
			
		}
		
		scanner.close();
		
	}
	
	
}
