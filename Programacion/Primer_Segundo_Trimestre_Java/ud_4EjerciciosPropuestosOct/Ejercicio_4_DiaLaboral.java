package ud_4EjerciciosPropuestosOct;

import java.util.Scanner;

public class Ejercicio_4_DiaLaboral {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce un día de la semana: ");
		String dia = scanner.nextLine().toLowerCase();

		switch(dia)
		{
	        case "lunes":
	        case "martes":
	        case "miércoles":
	        case "jueves":
	        case "viernes":
	            System.out.println(dia + " es un día laboral.");
	            break;
	        case "sabado":
	        case "domingo":
	            System.out.println(dia + " no es un día laboral.");
	            break;
	        default:
	            System.out.println("Día no válido. Por favor, introduce un día de la semana válido.");
	    }

		scanner.close();
		
		
	}

}
