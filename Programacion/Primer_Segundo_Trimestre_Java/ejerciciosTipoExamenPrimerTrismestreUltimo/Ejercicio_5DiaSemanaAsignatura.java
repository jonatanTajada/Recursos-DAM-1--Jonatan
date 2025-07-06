package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Scanner;

public class Ejercicio_5DiaSemanaAsignatura {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String dia;
		
		System.out.println("Introduce un dia de la semana para ver que asignatura toca");
		dia = scanner.next().toLowerCase();
		
		switch (dia) {
		case "lunes":
		case "martes":
		case "miercoles":
			System.out.println("Toca estudiar Programacion");
			break;
			
		case "jueves":
			System.out.println("Toca estudiar base de datos");
		break;
		
		case "viernes":
			System.out.println("Toca estudiar lenguaje3 de marcas y sistemas informaticos");
			break;
		default:
			System.out.println("Por favor introduce un dia de la semana de L-V");
			break;
		}
		
	}
	
	
}
