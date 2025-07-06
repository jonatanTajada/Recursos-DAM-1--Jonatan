package ejercicioAvion;

import java.util.*;
//Representa al conjunto de pasajeros que se subirán al avión
public class Pasajeros {

	// Atributos
	private List<Pasajero> listaPasajeros;
	private int numPasajerosTotales;

	//Constructor
	public Pasajeros(int numPasajerosTotales) {
        listaPasajeros = new ArrayList<>(numPasajerosTotales);
        
        for (int i = 1; i <= numPasajerosTotales; i++) {
            listaPasajeros.add(new Pasajero("Pasajero_" + i, i));
            System.out.println("------------------------------------++");
        }
     
    }

	// nos permitirá saber si tenemos más pasajeros en la lista.
	public boolean tieneMasPasajeros() {
		return !listaPasajeros.isEmpty();
	}



	public void setNumPasajerosTotales(int numPasajerosTotales) {
		this.numPasajerosTotales = numPasajerosTotales;
	}

	//getters
	public List<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}
	
	public int getNumPasajerosTotales() {
		return numPasajerosTotales;
	}

	
	// nos devolverá el siguiente pasajero de la lista y elimina pasajero para
	// garantizar que no haya duplicados
	public Pasajero siguientePasajero() {
	    if (!listaPasajeros.isEmpty()) {
	        return listaPasajeros.remove(0);
	    }
	    return new Pasajero("no hay mas pasajeros", -1); // Pasajero ficticio que indica que no hay más pasajeros
	}

	// nos permitirá añadir pasajeros a la lista.
	public void addPasajero(Pasajero pasajero) {
		if (listaPasajeros.size() < numPasajerosTotales) {
			listaPasajeros.add(pasajero);
		} else {
			System.err.println("No es posible añadir mas pasajero, estan todas las plazas ocupadas.");
		}
	}

	// nos desordenará la lista de pasajeros.
	 public void desordenar() {
	        Collections.shuffle(listaPasajeros);
	        
	        // Asignar tarjeta perdida al primer pasajero desordenado
	        if (!listaPasajeros.isEmpty()) {
	            listaPasajeros.get(0).setTajertaPerdida(true);
	        }
	    }

}
