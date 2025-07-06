package ejerciciosTipoExamenPrimerTrismestreUltimo;

import java.util.Arrays;

public class Ejercicio_8_TiendaVentasAnuales {

	public static void main(String[] args) {

		int ventas[] = { 100, 250, 25, 68, 40 };
		double sumaTotalVentas = 0;

		// Venta mayor
		int ventaMayor = ventas[0];
		for (int i = 1; i < ventas.length; i++) {
			if (ventas[i] > ventaMayor) {
				ventaMayor = ventas[i];
			}
		}
		System.out.println("La venta mayor es: " + ventaMayor);

		// Venta menor
		int ventaMenor = ventas[0];
		for (int i = 1; i < ventas.length; i++) {
			if (ventas[i] < ventaMenor) {
				ventaMenor = ventas[i];
			}
		}
		System.out.println("La venta menor es: " + ventaMenor);

		
		for (int i = 0; i < ventas.length; i++) {
			sumaTotalVentas += ventas[i];
		}
		System.out.println("La suma total de las ventas es de: " + sumaTotalVentas + "€.");

		
		Arrays.sort(ventas);
		System.out.println("Ventas ordenadas de forma ascendente: " + Arrays.toString(ventas));

		// Posición del valor 40 en el array
		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i] == 40) {
				System.out.println("El valor 40 se encuentra en la posición " + i);
				break; 
			}
		}
	}

}
