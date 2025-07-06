package ejercicio_Tipo_Examen_2_Evaluacion;

import java.text.*;
import java.util.*;

public class Factura {
	
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			
			// Solicitar entrada del usuario
			System.out.print("Introduce fecha inicial (dd/MM/yyyy): ");
			String fechaStr = scanner.nextLine();

			System.out.print("Introduce Nombre: ");
			String nombreComprador = scanner.nextLine();

			System.out.print("Introduce Importe: ");
			double importe = Double.parseDouble(scanner.nextLine());

			// Crear objeto Factura
			Factura factura = new Factura(nombreComprador, importe);

			// Llenar el Calendar con la fecha ingresada
			Calendar fechaCalendar = factura.llenarCalendar(fechaStr);

			// Imprimir la factura
			factura.imprimirFactura(fechaCalendar);
			
		} catch (ParseException e) {
			System.out.println("Error al procesar la fecha: " + e.getMessage());
			
		} catch (NumberFormatException e) {
			System.out.println("Error: Ingrese un importe valido.");
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			
		}
	}

	
	//Atributos
	private String comprador;
	private double importe;
	
	
	//Cosntructor
	public Factura(String nuevoComprador, double nuevoImporte) {
		this.comprador=nuevoComprador;
		this.importe=nuevoImporte;
	}
	
	
	
// 						---------------
//						 *** METODOS ***
// 						----------------

		
	//llenar Calendar a partir de una cadena
	public Calendar llenarCalendar(String cad) throws ParseException{
		
		Date fecha;
		Calendar fechafactura = Calendar.getInstance();
		
		//1ºCrear formato fecha
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");	
		formatoFecha.setLenient(false);
		
		//2º Se llena fecha tipo Date con una cadena
		fecha = formatoFecha.parse(cad);	
		
		//3º Se asigna fecha tipo Date a fecha tipo Calendar
		fechafactura.setTime(fecha);		
		return fechafactura;
	}
	

	//mostrar factura
	public void imprimirFactura(Calendar fecha) {
		double iva = 0.18;
		double total = importe + (importe * iva);

		System.out.println("------------ F A C T U R A --------------");
		System.out.println("Fecha: " + fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/"
				+ fecha.get(Calendar.YEAR));
		System.out.println("Factura a nombre de: " + this.comprador);
		System.out.println("Importe de la factura: " + this.importe);
		System.out.println("IVA (18%): " + (this.importe * iva));
		System.out.println("Total de la factura: " + total);
	}
	
	
	
	
	
	
	
}
