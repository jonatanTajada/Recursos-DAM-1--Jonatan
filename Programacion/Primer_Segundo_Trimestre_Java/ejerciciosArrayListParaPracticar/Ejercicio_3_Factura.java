package ejerciciosArrayListParaPracticar;
import java.util.*;
import java.util.Scanner;

public class Ejercicio_3_Factura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // crear arrayList
        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Integer> unidades = new ArrayList<>();
        ArrayList<Double> precioUnidad = new ArrayList<>();

        // Pedir al usuario datos para tres productos
        for (int i = 0; i < 3; i++) {
        	
        	
            System.out.println("- Ingrese los datos para el producto " + (i + 1));
            
            System.out.print("Nombre del producto: ");
            productos.add(scanner.nextLine());
            System.out.print("Unidades: ");
            unidades.add(Integer.parseInt(scanner.nextLine()));
            System.out.print("Precio por unidad: ");
            precioUnidad.add(Double.parseDouble(scanner.nextLine()));
        }

// Imprimir la factura
        
        //cabecero
        System.out.println("\nFactura:" + new Date());
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-20s %-10s %-15s %-10s\n", "Producto", "Unidades", "Precio/Unidad", "Total");
        System.out.println("--------------------------------------------------------");

        double totalFactura = 0.0;

        //cuerpo
        for (int i = 0; i < 3; i++) {
        	
            double totalProducto = unidades.get(i) * precioUnidad.get(i);
            totalFactura += totalProducto;

            System.out.printf("%-20s %-10d %-15.2f %-10.2f\n", productos.get(i), unidades.get(i), precioUnidad.get(i),
                    totalProducto);
        }

        //pie
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-46s %s\n", "Total Factura: ", String.format("%.2f", totalFactura) + " €.");

      
        scanner.close();
    }
}
