package ejercicios;

import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int cantidadNotas = 10;
		int notasAprobados=0, notasSuspendidos=0, notasSobresaliente=0;
		int nota;
		
		
		double notas[] = new double[cantidadNotas];
		
		for (int i = 0; i < notas.length; i++) {
			
			System.out.println((i+1) + ".Introduce nota del alumno: ");
			nota= scanner.nextInt();
			
			if (nota < 0 && nota > 10) {
				System.out.println("Nota introducida incorrecta, la nota tiene que ser entre 0-10");
			}else if(nota <5) {
				notasSuspendidos++;
			}else if(nota >5 && nota <= 10) {
				notasAprobados++;
			}
			
			if (nota >= 9 && nota <=10) {
				notasSobresaliente++;
			}
			
		}
		
		
		System.out.println("La cnatidad de alumnos suspendidos es: " + notasSuspendidos);
		System.out.println("La cantidad de alumnos aprobados es: " + notasAprobados);
		System.out.println("La cantidad de alumnos con nota sobresaliente es: " + notasSobresaliente);
		
		
	}
	
	
	
}
