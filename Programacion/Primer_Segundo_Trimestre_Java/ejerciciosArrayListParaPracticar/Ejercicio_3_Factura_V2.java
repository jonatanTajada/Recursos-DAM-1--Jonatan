package ejerciciosArrayListParaPracticar;

import java.text.NumberFormat;
import java.util.*;

public class Ejercicio_3_Factura_V2 {

	// cabecero sera la factura: y la fecha que se hace.
	// columnas con titulo de Producto Unidades Precio/Unidad Total
	// cuerpo datos
	// pie totalFactura: x€

	static ArrayList<String> listaProducto = new ArrayList<String>();
	static ArrayList<Integer> listaUnidades = new ArrayList<Integer>();
	static ArrayList<Double> listaPrecioUnidad = new ArrayList<Double>();
	static int cantidadProductos;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		introducirProductos();
		imprimirFactura();
		

	}

	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//        										*** METODOS ***
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	

	private static void introducirProductos() {

		System.out.print("Introduce la cantidad de productos que deseas introducir: ");
		cantidadProductos = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < cantidadProductos; i++) {
			System.out.println("- Ingrese los datos para el producto " + (i + 1));
			

			System.out.print("Nombre del producto: ");
			String nombreP = scanner.nextLine();
			listaProducto.add(nombreP);

			int unidades;
			while (true) {
				try {
					System.out.print("Unidades: ");
					unidades = Integer.parseInt(scanner.next());
					break; // Salir del bucle si la conversión fue exitosa
				} catch (NumberFormatException e) {
					System.out.println("Por favor, ingrese un número válido para las unidades.");
				}
			}
			listaUnidades.add(unidades);

			double precio;
			while (true) {
				try {
					System.out.print("Precio por unidad: ");
					precio = Double.parseDouble(scanner.next());
					break; // Salir del bucle si la conversión fue exitosa
				} catch (NumberFormatException e) {
					System.out.println("Por favor, ingrese un número válido para el precio por unidad.");
				}
			}
			listaPrecioUnidad.add(precio);
			scanner.nextLine();
		}
		System.out.println("Datos de la compra guardados con éxito!");
	}
	
	
	private static void imprimirFactura() {

		//cabecera
		System.out.println("\nFactura:" + new Date());
		System.out.println("--------------------------------------------------------");
		System.out.printf("%-20s %-10s %-15s %-10s\n", "Producto", "Unidades", "Precio/Unidad", "Total");
		System.out.println("--------------------------------------------------------");
		
		//cuerpo
		double totalFactura = 0.0;

		for (int i = 0; i < cantidadProductos; i++) {

			double totalProducto = listaPrecioUnidad.get(i) * listaPrecioUnidad.get(i);
			totalFactura += totalProducto;

			System.out.printf("%-20s %-10d %-15.2f %-10.2f\n", listaProducto.get(i), listaUnidades.get(i),listaPrecioUnidad.get(i), totalProducto);
		}

		//pie
		System.out.println("--------------------------------------------------------");
		//System.out.printf("%-46s %s\n", "Total Factura: ", String.format("%.2f", totalFactura) + " €.");
		
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());

		// Imprimir la factura con puntos de millares y dos decimales
		System.out.printf("%-46s %s\n", "Total Factura: ", formatoMoneda.format(totalFactura));

		// Cerrar el scanner
		scanner.close();

	}

}
