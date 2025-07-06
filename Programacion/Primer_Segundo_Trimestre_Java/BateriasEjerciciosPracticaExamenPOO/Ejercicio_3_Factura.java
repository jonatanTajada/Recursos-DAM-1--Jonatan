package BateriasEjerciciosPracticaExamenPOO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ejercicio_3_Factura {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);

		
		List<String> productos = new ArrayList<String>();
		List<Integer> unidades = new ArrayList<Integer>();
		List<Double> precioUnidad = new ArrayList<Double>();
		int cantidadProductos=0;

		//Pedir al usuario que introduzca productos
		System.out.println("Cuantos productos quieres comprar?");
		cantidadProductos = Integer.parseInt(scanner.next());
		
		for (int i = 0; i < cantidadProductos; i++) {
			System.out.println("\nIntroduce los datos de la compra:\n--------------------------------");
			
			System.out.println("Nombre producto:");
			String nombreProducto = scanner.nextLine();
			
			System.out.println("Introduce las unidades: ");
			int unidad = Integer.parseInt(scanner.next());
			
			System.out.println("Introduce el precio/unidad:");
			double precioUd = Double.parseDouble(scanner.next());
			
			productos.add(nombreProducto);
			unidades.add(unidad);
			precioUnidad.add(precioUd);

		}
		
//imprimir factura
		
		//cabecero
		 System.out.println("\nFactura:" + new Date());
		 System.out.println("-----------------------------------------------------");
		 System.out.printf("%-20s %-10s %-15s %-10s\n", "Producto", "Unidades", "Precio/Unidad", "Total");
		 System.out.println("-----------------------------------------------------");
		 
		 //cuerpo
		 
		 
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
}
