package ejercicioAvion_2;



public class App_Gestion {

	
	
	
	
	public static void main(String[] args) {
		
		int numeroPasajerosTotales = 10;
		
		//crear pasajeros y avion
		Pasajeros pasajeros = new Pasajeros(numeroPasajerosTotales);
		Avion asientosAvion = new Avion(numeroPasajerosTotales);
		
		System.out.println();
		for (Pasajero pasajero : pasajeros.getListaPasajeros()) {
			System.out.println(pasajero.toString());
		}
		
		
		//crear y añadir pasajeros a la lista -- uno de ellos no podra embarcar 
		for (int i = 0; i <= numeroPasajerosTotales; i++) {
			Pasajero pasajero = new Pasajero("Pasajero_" + i, i);
			pasajeros.addPasajero(pasajero);
			System.out.println("------------------------------------");
		}
		
		
		// Desordenar la lista de pasajeros
		pasajeros.desordenarLista();
	
		// Mostrar la lista de pasajeros desordenada
		
		System.out.println("Lista de pasajeros desordenada:");
		System.out.println("----------------------------------");
		
		for (Pasajero pasajero : pasajeros.getListaPasajeros()) {
		    System.out.println(pasajero);
		    System.out.println();
		}
		
		
		// Asignar al pasajero que se encuentra en la posición 0 la tarjeta de embarque perdida.
		
		if (!pasajeros.getListaPasajeros().isEmpty()) {
			pasajeros.getListaPasajeros().get(0).setHaPerdidoTarjetaEmbarque(true);
		}
		
		// Llamar a la funcion de embarque del avion con la lista desordenada
		
		asientosAvion.pasajerosQueTienenQueEmbarcar(pasajeros);
		
		
		 // Calcular el último asiento libre
        int ultimoAsientoLibre = asientosAvion.getListaAsientosAvion().lastIndexOf(null);
		
        // Mostrar información del último pasajero y asiento libre
//        System.out.println("Información del último pasajero y asiento libre:");
//        asientosAvion.pasajerosQueTienenQueEmbarcar(pasajeros);
//        System.out.println(asientosAvion.mostrarInformacionUltimoPasajero(pasajeros, ultimoAsientoLibre));
//


	
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
