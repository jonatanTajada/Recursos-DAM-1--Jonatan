package ejercicioAvion_2;

import java.util.*;


//	Esta clase gestiona una lista de pasajeros y proporciona metodos para agregar pasajeros,
//	verificar y marcar su embarque, verificar si hay mas pasajeros por embarcar, y desordenar la lista de pasajeros.

public class Pasajeros {

	//Atributos
	private ArrayList<Pasajero> listaPasajeros;
	private int numeroPasajerosTotales;
	
	
	//Constructor
	public Pasajeros(int numeroPasajerosTotales) {
		this.numeroPasajerosTotales=numeroPasajerosTotales;
		listaPasajeros = new ArrayList<Pasajero>(numeroPasajerosTotales);
	}
	
	//setters and getters
	public ArrayList<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}

	public void setListaPasajeros(ArrayList<Pasajero> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}

	public int getNumeroPasajerosTotales() {
		return numeroPasajerosTotales;
	}

	public void setNumeroPasajerosTotales(int numeroPasajerosTotales) {
		this.numeroPasajerosTotales = numeroPasajerosTotales;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	// 							***  METODOS ****
	//------------------------------------------------------------------------------------------------------------------------------

	// añadir pasajero a la lista pasajeros
	public void addPasajero(Pasajero pasajero) {
		
		if (listaPasajeros.size() < numeroPasajerosTotales) {
			listaPasajeros.add(pasajero);
			System.out.println("Pasajero agregado a la lista correctamente!");
		}else {
			System.err.println("No es posible agregar al pasajero, todas las plazas del avion estan ocupadas.");
			System.out.println("Datos del pasajero que no puede embarcar:");
	        System.out.println(pasajero);
		}
	}
	
	
	// va verficando cada embarque y añade true a isHaembarcado
	public Pasajero siguientePasajero() {
		for (Pasajero pasajero : listaPasajeros) {
			if (!pasajero.isHaEmbarcado()) { // Verifica si el pasajero no ha embarcado
				pasajero.setHaEmbarcado(true);  // Marca el pasajero como embarcado
				listaPasajeros.remove(pasajero);  // Elimina el pasajero de la lista después de confirmar el embarque
				System.out.println("Pasajero ' " + pasajero.getNombrePasajero() + " ', ha embarcado correctamente.");
				return pasajero;
			}
		}
		System.out.println("No hay mas pasajeros para embarcar.");
		return null;
	}
	
	
	//tiene mas pasajeros
	public Pasajero tieneMasPasajeros() {
		for (Pasajero pasajero : listaPasajeros) {
			if (!pasajero.isHaEmbarcado()) {
				return pasajero;
			}
		}
		return null;
	}
	
	
	
	//desordenar lista pasajeros
	public void desordenarLista() {
		Collections.shuffle(listaPasajeros);
	}



}
