package ud_4Metodos;

import java.util.Scanner;

public class Ejercicio_4 {

	private static final double DESCUENTO = 0.20;

	enum Area {
		FRUTAS, VERDURAS, DULCES, CONGELADOS, FRESCOS, OTROS
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese el nombre del cliente: ");
		String nombreCliente = scanner.nextLine();

		double totalCompra = 0;

		//pedir informacion
		while (true) {
			System.out.print("Ingrese el nombre del producto (o 'fin' para finalizar): ");
			String nombreProducto = scanner.next();

			if (nombreProducto.equalsIgnoreCase("fin")) {
				break;
			}

			System.out.print("Ingrese el precio del producto: ");
			double precioProducto = scanner.nextDouble();

			System.out.print("Ingrese la cantidad de productos: ");
			int cantidad = scanner.nextInt();

			double subtotal = precioProducto * cantidad;
			totalCompra +=  subtotal;

			System.out.print("Ingrese el área del producto (FRUTAS, VERDURAS, DULCES, CONGELADOS, FRESCOS, OTROS): ");
			String areaProductoStr = scanner.next();
			
			Area areaProducto = Area.valueOf(areaProductoStr.toUpperCase());

			//saber si se le aplica el dscto
			if (totalCompra > 100 && (areaProducto == Area.FRUTAS || areaProducto == Area.VERDURAS || areaProducto == Area.DULCES)) {
				double descuento = DESCUENTO * totalCompra;
				totalCompra -= descuento;
			}
		}

		System.out.println("Nombre del cliente: " + nombreCliente);
		System.out.println("Total a pagar (con descuento si corresponde):" + totalCompra + "€");

		scanner.close();
	}

}
