package ud_4EjerciciosPropuestosOct;

import java.util.Scanner;

public class Ejercicio_4_DiaLaboralArray {

	public static void main(String[] args) {

	//	arreglar esta clase, le quiedan cosillas por hjacer entre ellas
		//hacer un do while o while, enrte otras cosas..
		
		
		Scanner scanner = new Scanner(System.in);
		
		String[] diaDeLaSemana = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
		String diaIngresado;
		
		
	
			System.out.println("Introduce un dia de la semana con letras");
			diaIngresado = scanner.nextLine().toLowerCase();
			
			for (int i = 0; i < diaDeLaSemana.length; i++) {
				
				if (esValido(diaIngresado, diaDeLaSemana)) {
					
					switch (diaIngresado) {
					case "lunes":
					case "martes":
					case "miercoles":
					case "jueves":
					case "viernes":
						System.out.println("Dia laborable");
						break;

					case "sabado":
					case "domingo":
						System.out.println("Esto no es un dia laborable");
						break;
					}
					
				}else {
					System.err.println("Introduce un dia valido, el dato introducido no corresponde con un dia de la semana");
				}
			}
	
		
	}

	
	//los dias validos solo son de lunes a viernes
	public static boolean esValido(String dia, String diasValidos []) {
		String diaValido = " ";
		for (int i = 0; i < diasValidos.length; i++) {
			if (diaValido.equals(dia)) {
				return true;
			}
		}
		return false;
	}
	
}
