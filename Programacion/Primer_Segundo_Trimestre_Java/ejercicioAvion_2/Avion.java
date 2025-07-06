package ejercicioAvion_2;

import ejercicioAvion_2.Pasajero;

import java.util.*;

public class Avion implements IEmbarque {

	// Atributos
	private List<Pasajero> listaAsientosAvion;

	
	// Constructor
	public Avion(int numeroAsientos) {
		listaAsientosAvion = new ArrayList<>(numeroAsientos);
		// Inicializar la lista de asientos con pasajeros nulos (sin asignar)
		for (int i = 0; i < numeroAsientos; i++) {
			listaAsientosAvion.add(null);
		}
	}

	//getters ands setters
//	public List<Pasajero> getListaAsientosAvion() {
//		return listaAsientosAvion;
//	}
	
	public List<Pasajero> getListaAsientosAvion() {
		if (listaAsientosAvion == null || listaAsientosAvion.isEmpty()) {
			System.out.println("La lista de asientos está vacía.");
		} else {
			for (Pasajero asiento : listaAsientosAvion) {
				if (asiento == null) {
					System.out.println("El asiento está vacío.");
					break; // Puedes detener la iteración si encuentras un asiento vacío
				}
			}
		}
		return listaAsientosAvion;
	}


	public void setListaAsientosAvion(List<Pasajero> listaAsientosAvion) {
		this.listaAsientosAvion = listaAsientosAvion;
		}
	
//------------------------------------------------
//			 *** METODOS ***
//--------------------------------------------------

	// Asignar un asiento aleatorio libre al pasajero
	private void asignarAsientoAleatorio(Pasajero pasajero) {
		int asientoAleatorio;
		do {
			asientoAleatorio = (int) (Math.random() * listaAsientosAvion.size());
		} while (listaAsientosAvion.get(asientoAleatorio) != null);

		listaAsientosAvion.set(asientoAleatorio, pasajero);
		pasajero.setNumeroAsientoPasajero(asientoAleatorio);
	}

	
	
	
	@Override
	public void pasajerosQueTienenQueEmbarcar(Pasajeros pasajeros) {
		for (Pasajero pasajero : pasajeros.getListaPasajeros()) {

			if (!pasajero.isHaPerdidoTarjetaEmbarque()) {

				// Si el pasajero tiene tarjeta de embarque
				int asiento = pasajero.getNumeroAsientoPasajero();

				if (listaAsientosAvion.get(asiento) == null) {
					// Si el asiento está libre, se asigna al pasajero
					listaAsientosAvion.set(asiento, pasajero);

				} else {
					// Si el asiento está ocupado, buscar un nuevo asiento aleatorio libre
					asignarAsientoAleatorio(pasajero);
				}
			} else {
				// Si el pasajero ha perdido la tarjeta de embarque, buscar un nuevo asiento
				// aleatorio libre
				asignarAsientoAleatorio(pasajero);
			}
		}

		// Mostrar si el último pasajero coincide con el ultimo asiento libre

		int ultimoAsientoLibre = listaAsientosAvion.lastIndexOf(null);
		
		if (!pasajeros.getListaPasajeros().isEmpty()) {
			
			Pasajero ultimoPasajero = pasajeros.getListaPasajeros().get(pasajeros.getListaPasajeros().size() - 1);
			
			int asientoUltimoPasajero = ultimoPasajero.getNumeroAsientoPasajero();
			
			System.out.println("El ultimo pasajero tiene el asiento: " + asientoUltimoPasajero);
			System.out.println("¿Coincide con el ultimo asiento libre? " + (asientoUltimoPasajero == ultimoAsientoLibre));
		}

	}

	
	// Muestra si coincide el ultimo asiento con el 
	public String mostrarInformacionUltimoPasajero(Pasajeros pasajeros, int ultimoAsientoLibre) {
		
	    if (!pasajeros.getListaPasajeros().isEmpty()) {
	    	
	        Pasajero ultimoPasajero = pasajeros.getListaPasajeros().get(pasajeros.getListaPasajeros().size() - 1);
	        int asientoUltimoPasajero = ultimoPasajero.getNumeroAsientoPasajero();

	        return "El último pasajero tiene el asiento: " + asientoUltimoPasajero +
	                "\n¿Coincide con el último asiento libre? " + (asientoUltimoPasajero == ultimoAsientoLibre);
	    } else {
	        return "No hay pasajeros para mostrar.";
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
