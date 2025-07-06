package ejercicioPeajes;

import java.util.ArrayList;
import java.util.List;
// esta clase tiene una relacion de asociacion con la interfaz Vehiculo. 

public class Estacion {
	
	private String nombre;
	private String departamento;
	private double totalPeajes;
	private List<Vehiculo> vehiculos;

	public Estacion(String nombre, String departamento) {
		this.nombre = nombre;
		this.departamento = departamento;
		this.totalPeajes = 0.0;
		this.vehiculos = new ArrayList<>();
	}

	public void cobrarPeaje(Vehiculo vehiculo) {
		
		double peaje = vehiculo.calcularPeaje();
		totalPeajes += peaje;
		vehiculos.add(vehiculo);
	}

	public void mostrarReporte() {
		
		System.out.println("*** Reporte de la estacion " + nombre + " en " + departamento +": ***");
		
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo.toString() + "\n- Peaje: " + vehiculo.calcularPeaje() + " €.");
		}
		System.out.println("Total acumulado de peajes: " + totalPeajes + "€");
	}
}
