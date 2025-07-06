package ejerciciosParaExamenPrimerTrimestre;

import java.util.Scanner;

/**
 * @author Jonatan
 * comentario: Resuelva algunas operaciones matematicas como sumar, restar, multiplicar, dividir, raices cuadradas y potencias.
 */

public class ResuelveOperacionesMatematicasEjercicio_8 {

	
public static void main(String[] args) {
	
	 Scanner scanner = new Scanner(System.in);

 
     System.out.println("Introducir primer numero:");
     double x = scanner.nextDouble();

     System.out.println("Introducir segundo numero:");
     double y = scanner.nextDouble();

    
     System.out.println("x = " + x + "\ny = " + y +"\n");
     System.out.println("x + y = " + (x + y));
     System.out.println("x - y = " + (x - y));
     System.out.println("x * y = " + (x * y));
     
     
     if (y != 0) {
         System.out.println("x / y = " + (x / y));
     } else {
         System.out.println("No se puede dividir por cero.");
     }

     // Calcular la potencia de x y la raíz cuadrada de y
     System.out.println("x ^ 2 = " + Math.pow(x, 2));
     
     // Verificar si y es mayor o igual a cero antes de calcular la raíz cuadrada
     if (y >= 0) {
         System.out.println("√x = " + Math.sqrt(y));
     } else {
         System.out.println("No se puede calcular la raíz cuadrada de un número negativo."); 
     }

     scanner.close();
  }


}
	
	

