package ud_4EjerciciosPropuestosOct;

import java.util.Scanner;

public class CalcularAreasDiferentes {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("¿Qué figura quieres calcular (círculo, triángulo o cuadrado)? ");
		String figura = scanner.nextLine().toLowerCase(); 											

		double area = 0.0;

		if (figura.equals("círculo")) {
			System.out.print("Introduce el radio del círculo: ");
			double radio = scanner.nextDouble();
			
			area = calcularAreaCirculo(radio);
			
		} else if (figura.equals("triángulo")) {
			System.out.print("Introduce la base del triángulo: ");
			double base = scanner.nextDouble();
			
			System.out.print("Introduce la altura del triángulo: ");
			double altura = scanner.nextDouble();
			
			area = calcularAreaTriangulo(base, altura);
			
		} else if (figura.equals("cuadrado")) {
			System.out.print("Introduce el lado del cuadrado: ");
			double lado = scanner.nextDouble();
			
			area = calcularAreaCuadrado(lado);
			
		} else {
			System.out.println("Figura no válida. Debes elegir entre círculo, triángulo o cuadrado.");
			//System.exit(1);
		}

		System.out.println("El área del " + figura + " es: " + area);

		scanner.close();
	}
	
	
	// 2º opcion con un switch
	
//	String figura;
//	double area;
//	String continuar;
//	
//	do {
//		System.out.println("Que figuras deseas caluclar el area (triangulo - circulo + cuadrado)");
//		figura=scanner.next().toLowerCase();
//		
//		switch (figura) {
//		case "circulo":
//			System.out.println("Introduce el radio del circulo");
//			double radio = scanner.nextInt();
//			
//			area = calcularAreaCirculo(radio);
//			System.out.println("El area del circulo es: " + area);
//			break;
//			
//		case "triangulo":
//			System.out.println("Introduce la base dle rtiangul");
//			double base = scanner.nextDouble();
//			
//			System.out.println("Introduce la altura del triangulo");
//			double altura=scanner.nextDouble();
//			
//			area= calcularAreaTriangulo(base, altura);
//			System.out.println("El area del triangulo es: " + area);
//			break;
//			
//		case "cuadrado":
//			System.out.println("Introduce el lado numero 1 del cuadrado");
//			double lado1 = scanner.nextDouble();
//			
//			System.out.println("Introduce el lado numero 2 del cuadrado");
//			double lado2 = scanner.nextDouble();
//			
//			area = calcularAreaCuadrado(lado2);
//			System.out.println("El area del cuadrao es: " + area);
//			break;
//
//		default:
//			System.out.println("Por favor introduce una figura geometrica valida");
//			break;
//		}
//		
//		System.out.println("Deseas calcyular algun otro area: (si/no)");
//		continuar = scanner.next();
//		System.out.println();
//		
//		
//	} while (continuar.equalsIgnoreCase("si"));
//	
//	scanner.close();
	
	
	
	
	
	//Metodos

	public static double calcularAreaCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);
	}

	
	public static double calcularAreaTriangulo(double base, double altura) {
		return (base * altura) / 2;
	}

	
	public static double calcularAreaCuadrado(double lado) {
		return lado * lado;
	}

}
