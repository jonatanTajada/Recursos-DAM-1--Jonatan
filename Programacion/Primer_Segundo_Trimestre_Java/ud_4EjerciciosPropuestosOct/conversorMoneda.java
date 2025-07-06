package ud_4EjerciciosPropuestosOct;

import java.util.Scanner;

public class conversorMoneda {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce la cantidad en euros:");
		double cantidadEuros = scanner.nextDouble();

		scanner.nextLine(); // Consumir la nueva línea después de leer el número

		System.out.println("Selecciona la moneda a la que quieres convertir (USD, JPY, GBP):");
		String monedaDestino = scanner.nextLine().toUpperCase();

		convertirMoneda(cantidadEuros, monedaDestino);
		
		//2ºopcion
		//	conversorMonedas(100, "yen");
		
	}

	
	public static void convertirMoneda(double cantidadEuros, String monedaDestino) {
		
		double tipoCambio = 0.0;

		switch (monedaDestino) {
		
		case "USD":
			tipoCambio = 1.28611;
			break;
		case "JPY":
			tipoCambio = 129.852;
			break;
		case "GBP":
			tipoCambio = 0.86;
			break;
		default:
			System.out.println("Moneda no válida.");
			return;
		}

		double cantidadConvertida = cantidadEuros * tipoCambio;

		System.out.println(cantidadEuros + " euros equivalen a " + cantidadConvertida + " " + monedaDestino);
	}
	
	
	//2º opcion
	
//public static void conversorMonedas(double cantidadEuros, String monedaDestino) {
//		
//		System.out.println("introduce la cantidad de monedas en euros");
//		cantidadEuros = scanner.nextDouble();
//	
//		switch (monedaDestino) {
//		
//		
//		case "libra":
//			double libra = 0.86;
//			double conversionLibra = cantidadEuros *  libra;
//			System.out.println("La cantidad de " + cantidadEuros + "€ en " + monedaDestino + " es: " +  conversionLibra);
//			break;
//			
//		case "$":
//			double dolar = 1.28611;
//			double conversionDolar = cantidadEuros *  dolar;
//			System.out.println("La cantidad de " + cantidadEuros + "€ en " + monedaDestino + " es: " + conversionDolar );
//			break;
//			
//		case "yen":
//			double yen = 129.852;
//			double conversionYen = cantidadEuros *  yen;
//			System.out.println("La cantidad de " + cantidadEuros + "€ en " + monedaDestino + " es: " +  conversionYen);
//			break;
//
//		default:
//			System.out.println("Introduce una moneda valida");
//			break;
//		}
//		
//		
//		
//	}
//	
//	
//	}


}
