package ud_4EjerciciosPropuestosOct;

import java.util.Scanner;

public class Ejercicio_7_CalculadoraPolacaInversa {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		double resultado = 0.0,  num1, num2;
	
		System.out.print("Ingresa el primer operando (entero): ");
		num1 = scanner.nextInt();

		System.out.print("Ingresa el segundo operando (entero): ");
		num2 = scanner.nextInt();

		System.out.print("Ingresa el signo aritmético (+, -, *, /, ^, %): ");
		String operador = scanner.next();

		

		switch (operador) {
		case "+":
			resultado = num1 + num2;
			break;
		case "-":
			resultado = num1 - num2;
			break;
		case "*":
			resultado = num1 * num2;
			break;
		case "/":
			if (num2 != 0) {
				resultado = num1 / num2;
			} else {
				System.out.println("Error: División por cero.");
				System.exit(1);
			}
			break;
		case "^":
			resultado = Math.pow(num1, num2);
			break;
		case "%":
			resultado = num1 % num2;
			break;
		default:
			System.out.println("Operador no válido. Debes ingresar uno de los operadores especificados.");
			System.exit(1);
		}

		System.out.println("Resultado: " + resultado);

		scanner.close();
		
	}

}
