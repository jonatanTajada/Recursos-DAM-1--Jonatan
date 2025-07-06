package ejercicioAvion;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Paso 1: Crear una lista de pasajeros con capacidad para 5 pasajeros
        Pasajeros listaPasajeros = new Pasajeros(5);

        // Paso 2: Crear 7 pasajeros
        Pasajero pasajero1 = new Pasajero("Pasajero1", 1);
        Pasajero pasajero2 = new Pasajero("Pasajero2", 2);
        Pasajero pasajero3 = new Pasajero("Pasajero3", 3);
        Pasajero pasajero4 = new Pasajero("Pasajero4", 4);
        Pasajero pasajero5 = new Pasajero("Pasajero5", 5);
        Pasajero pasajero6 = new Pasajero("Pasajero6", 6);
        Pasajero pasajero7 = new Pasajero("Pasajero7", 7);

        // Paso 3: Introducir esos pasajeros en la lista
        listaPasajeros.addPasajero(pasajero1);
        listaPasajeros.addPasajero(pasajero2);
        listaPasajeros.addPasajero(pasajero3);
        listaPasajeros.addPasajero(pasajero4);
        listaPasajeros.addPasajero(pasajero5);
        listaPasajeros.addPasajero(pasajero6);
        listaPasajeros.addPasajero(pasajero7);

        // Mostrar lista de pasajeros antes del embarque
        System.out.println("Lista de pasajeros antes del embarque:");
        System.out.println("-------------------------------------------");
        for (Pasajero pasajero : listaPasajeros.getListaPasajeros()) {
            System.out.println(pasajero);
        }
        
        // Crear un objeto de la clase Avion con capacidad para 5 pasajeros
        Avion avion = new Avion(5);

        
        // Clonar la lista original antes de realizar el embarque
        List<Pasajero> listaPasajerosAntesEmbarque = new ArrayList<>(listaPasajeros.getListaPasajeros());
        
        
        // Realizar el embarque en el avión
        avion.embarque(listaPasajeros);

        // Mostrar lista de pasajeros después del embarque
        System.out.println("\nLista de pasajeros después del embarque:");
        for (Pasajero pasajero : listaPasajeros.getListaPasajeros()) {
            System.out.println(pasajero.toString());
        }
    }
}

































