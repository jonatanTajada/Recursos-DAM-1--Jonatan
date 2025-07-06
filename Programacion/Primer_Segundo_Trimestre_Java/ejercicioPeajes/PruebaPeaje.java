package ejercicioPeajes;

import java.util.ArrayList;
import java.util.List;

public class PruebaPeaje {
	public static void main(String[] args) {
		
		// crear listas
		List<Estacion> estaciones = new ArrayList<>();
		List<Vehiculo> vehiculos = new ArrayList<>();

		// Crear  estacion
		Estacion estacion = new Estacion("Llodio", "General");
		estaciones.add(estacion);
		
		// Crear  vehiculos
		Vehiculo coche = new Coche("ABC123");
		Vehiculo moto = new Moto("XYZ789");
		Vehiculo camion = new Camion("DEF456", 3);
		Vehiculo coche2 = new Coche("ABC222");
		Vehiculo moto2 = new Moto("XYZ777");
		Vehiculo camion2 = new Camion("ABC123", 6);

		// Añadir los vehiculos a la lista
		vehiculos.add(coche);
		vehiculos.add(moto);
		vehiculos.add(camion);
		vehiculos.add(coche2);
		vehiculos.add(moto2);
		vehiculos.add(camion2);

		// Cobrar peajes en la estacion
		for (Vehiculo vehiculo : vehiculos) {
			estacion.cobrarPeaje(vehiculo);
		}

		// Mostrar el reporte de la estacion
		estacion.mostrarReporte();
	}
}