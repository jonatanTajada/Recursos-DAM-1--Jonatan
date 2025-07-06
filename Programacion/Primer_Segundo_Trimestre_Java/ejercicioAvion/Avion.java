package ejercicioAvion;

import java.util.ArrayList;
import java.util.List;

class Avion {
	
	private int numPlazas;
	private List<Integer> asientosOcupados;

	public Avion(int numPlazas) {
		this.numPlazas = numPlazas;
		this.asientosOcupados = new ArrayList<>();
	}

	// En la clase Avion
	
	public void embarque(Pasajeros pasajeros) {
		
		Pasajero pasajero = pasajeros.siguientePasajero();

		while (!"N/A".equals(pasajero.getNombre())) {
			System.out.println("Embarcando a " + pasajero.getNombre() + " en el asiento " + pasajero.getNumeroAsiento());

			if (pasajero.isTajertaPerdida() || asientosOcupados.contains(pasajero.getNumeroAsiento())) {
				// Pasajero sin tarjeta o asiento ocupado, buscar nuevo asiento aleatorio
				int nuevoAsiento = buscarAsientoAleatorio();
				System.out.println("Asiento ocupado. Buscando nuevo asiento: " + nuevoAsiento);
				pasajero.setNumeroAsiento(nuevoAsiento);
			}

			asientosOcupados.add(pasajero.getNumeroAsiento());
			pasajero = pasajeros.siguientePasajero();
		}

		System.out.println("El último pasajero tiene asiento N/A");
	}

	private int buscarAsientoAleatorio() {
		int nuevoAsiento;
		do {
			nuevoAsiento = (int) (Math.random() * numPlazas) + 1;
		} while (asientosOcupados.contains(nuevoAsiento));
		return nuevoAsiento;
	}
}
