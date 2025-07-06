package z_Proyectos_Mios_Pruebas;

import java.util.*;
import java.time.LocalDateTime;

public class App_Gestion_Inventario {

	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Producto> inventario = new ArrayList<>();

	public static void main(String[] args) {
		
		App_Gestion_Inventario gestionInventario = new App_Gestion_Inventario();
		gestionInventario.mostrarMenu();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//							*** METODOS ***
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void mostrarMenu() {
		int opcion;

		do {
			System.out.println("1. Mostrar inventario");
			System.out.println("2. Añadir producto");
			System.out.println("3. Actualizar stock");
			System.out.println("4. Salir");
			System.out.print("Selecciona opción: ");

			opcion = obtenerEntero();

			switch (opcion) {
			case 1:
				mostrarInventario();
				break;
			case 2:
				aniadirProducto();
				break;
			case 3:
				actualizarStock();
				break;
			case 4:
				salirPrograma();
				break;
			default:
				System.err.println("Error, introduce un número válido entre el 1 y 4.");
			}

		} while (opcion != 4);
	}

	public void mostrarInventario() {
		
		if (inventario.isEmpty()) {
	        System.err.println("No hay stock, lista de inventario vacía!");
	        return;  // Sale del método si el inventario está vacío
	    }

	    int contador = 1;
	    System.out.println("Inventario actual: " + java.time.LocalDateTime.now());
	    
	    for (Producto producto : inventario) {
	        System.out.println("# " + contador + ". Producto: " + producto);
	        contador++;
	    }

	    System.out.println();
	}

	public void aniadirProducto() {
		System.out.println("- Añadir producto: ");
		System.out.println("----------------------------------------------------------------------------------------------");

		System.out.print("Introduce nombre del producto: ");
		String nombre = scanner.next();

		System.out.print("Introduce la cantidad inicial de unidades: ");
		int cantidad = obtenerEntero();

		System.out.print("Ingrese el precio de compra: ");
		double precioCompra = obtenerDouble();

		System.out.print("Introduce el precio de venta: ");
		double precioVenta = obtenerDouble();

		inventario.add(new Producto(nombre, cantidad, precioCompra, precioVenta));
		System.out.println("Producto añadido al inventario con éxito.");
	}

	public void actualizarStock() {
		mostrarInventario();
		System.out.print("Introduce el índice del producto que desea actualizar: ");
		int indice = obtenerEntero();

		if (isIndiceValido(indice)) {
			System.out.print("Introduce la cantidad de unidades a añadir o restar: ");
			int cantidad = obtenerEntero();

			OperacionStock operacionStock = obtenerOperacion();

			inventario.get(indice - 1).actualizarStock(cantidad, operacionStock);
			System.out.println("Stock actualizado.\n");
		} else {
			System.out.println("Índice no válido. Intente nuevamente.\n");
		}
	}

	private int obtenerEntero() {
		while (!scanner.hasNextInt()) {
			System.err.println("Error, introduce un número entero válido.");
			scanner.next(); // Consumir entrada no válida
		}
		return scanner.nextInt();
	}

	private double obtenerDouble() {
		while (!scanner.hasNextDouble()) {
			System.err.println("Error, introduce un número decimal válido.");
			scanner.next(); // Consumir entrada no válida
		}
		return scanner.nextDouble();
	}

	private OperacionStock obtenerOperacion() {
		OperacionStock operacionStock = null;
		while (operacionStock == null) {
			System.out.print("\n¿Qué operación desea realizar; SUMAR o RESTAR? ");
			String operacion = scanner.next();

			if (operacion.equalsIgnoreCase("SUMAR")) {
				operacionStock = OperacionStock.SUMAR;
			} else if (operacion.equalsIgnoreCase("RESTAR")) {
				operacionStock = OperacionStock.RESTAR;
			} else {
				System.err.println("Operación no disponible, inténtelo de nuevo");
			}
		}
		return operacionStock;
	}

	private boolean isIndiceValido(int indice) {
		return indice >= 0 && indice < inventario.size();
	}
	
	private static void salirPrograma() {
		System.out.println("Saliendo del programa...\n¡Hasta luego!");
		return;

	}

}
