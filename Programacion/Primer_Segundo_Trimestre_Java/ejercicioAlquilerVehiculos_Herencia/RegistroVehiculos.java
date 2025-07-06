package ejercicioAlquilerVehiculos_Herencia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RegistroVehiculos {
	
	//Atributos
	private int numVehiculos;
	public ArrayList<Vehiculo> listaVehiculosPasajeros = new ArrayList<Vehiculo>();
	public ArrayList<Vehiculo> listaVehiculosCarga = new ArrayList<Vehiculo>();

	public void registraVehiculo(ArrayList<Vehiculo> listaVehiculos) {
		int opcion;
		String salir;

		System.out.println("-Registrar vehiculo:");
		System.out.println("------------------------------------");

		do {

			do {
				JOptionPane.showMessageDialog(null, "Que clase de vehiculo quieres quieres registrar?:");
				opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Coche\n2. MicroBus\n3. Furgoneta\nCamion"));

				System.err.println("Introduce un valor entre 1 y 3.");

			} while (opcion < 1 || opcion > 3);

			
			// ----------Switch--------------------------------
			switch (opcion) {
			case 1:
				registrarCoche();
				seguirRegistrandoVehiculosPasajeros();
				break;

			case 2:
				registrarMicroBus();
				seguirRegistrandoVehiculosPasajeros();
				break;

			case 3:
				registrarFurgoneta();
				seguirRegistrandoVehiculosCarga();
				break;
				
			case 4:
				registrarCamion();
				seguirRegistrandoVehiculosCarga();
				break;
			default:
				System.err.println("Introduzca un opcion valida si deseas registrar un vehiculo!");
				break;
			}
			
			salir= JOptionPane.showInputDialog("Deseas salir?: (s/n)");
			

		} while (salir.equalsIgnoreCase("si"));

	}

	// ----------------------------------------------------------------------------------------------------------------------------------------
	// METODOS PARA INSTANCIAS VEHICULOS PASAJEROS
	// ----------------------------------------------------------------------------------------------------------------------------------------

	// registrar coche
	public void registrarCoche() {

		numVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de coches que quieres registrar?"));
		
		for(int i = 0; i < numVehiculos; i++) {
			
			JOptionPane.showMessageDialog(null, "Registro del coche " + (i+1) + "#:");
			String matricula = JOptionPane.showInputDialog("introduce la matricula: ");
			int dias = Integer.parseInt(JOptionPane.showInputDialog("Introduce los dias que quieres alquilar el coche: "));
			int plazas = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de plazas que dispone el coche:"));

			listaVehiculosPasajeros.add(new Coche(matricula, dias, plazas));
			System.out.println("Has registrado correctamente los datos del coche!");	
		}
		
		
		
	}

	// registrar Micro Bus
	public void registrarMicroBus() {

		numVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de MicroBuses que quieres registrar?"));
	
		for(int i = 0; i < numVehiculos;i++) {
			JOptionPane.showMessageDialog(null, "Registro del MicroBus " + (i+1) + "#:");
			String matricula = JOptionPane.showInputDialog("introduce la matricula: ");
			int dias = Integer
					.parseInt(JOptionPane.showInputDialog("Introduce los dias que quieres alquilar el MicroBus: "));
			int plazas = Integer
					.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de plazas que dispone el MicroBus:"));

			listaVehiculosPasajeros.add(new MicroBus(matricula, dias, plazas));
			System.out.println("Has registrado correctamente los datos del MicroBus!");
		}
	}

	// pregunta para seguir añadiendo objetos de tipo vehiculo pasajero
	public void seguirRegistrandoVehiculosPasajeros() {
		String continuar = "s";
		continuar = JOptionPane.showInputDialog("Quieres registrar algun otro Vehiculo? (s/n)");
		if (continuar.equalsIgnoreCase("si")) {
			registraVehiculo(listaVehiculosPasajeros);
		}
	}

//----------------------------------------------------------------------------------------------------------------------------------------
//				METODOS PARA INSTANCIAS VEHICULOS DE CARGA
//----------------------------------------------------------------------------------------------------------------------------------------

	// pregunta para seguir añadiendo objetos de tipo vehiculo carga
	public void seguirRegistrandoVehiculosCarga() {
		String continuar = "s";
		continuar = JOptionPane.showInputDialog("Quieres registrar algun otro Vehiculo? (s/n)");
		if (continuar.equalsIgnoreCase("si")) {
			registraVehiculo(listaVehiculosCarga);
		}
	}

	// registrar Furgoneta
	public void registrarFurgoneta() {

		numVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de furgonetas que quieres registrar?"));
		
		for (int i = 0; i < numVehiculos; i++) {
			String matricula = JOptionPane.showInputDialog("introduce la matricula: ");
			int dias = Integer
					.parseInt(JOptionPane.showInputDialog("Introduce los dias que quieres alquilar la furgoneta: "));
			double pesoMaximoAutorizado = Double
					.parseDouble(JOptionPane.showInputDialog("Introduce el Peso Máximo Autorizado (PMA):"));

			listaVehiculosCarga.add(new Furgoneta(matricula, dias, pesoMaximoAutorizado));
			System.out.println("Has registrado correctamente los datos de la furgoneta!");
		}
		

	}

	// registrar Furgoneta
	public void registrarCamion() {

		numVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de camiones que quieres registrar?"));
		
		for (int i = 0; i < numVehiculos; i++) {
			String matricula = JOptionPane.showInputDialog("introduce la matricula: ");
			int dias = Integer
					.parseInt(JOptionPane.showInputDialog("Introduce los dias que quieres alquilar el camion: "));
			double pesoMaximoAutorizado = Double
					.parseDouble(JOptionPane.showInputDialog("Introduce el Peso Máximo Autorizado (PMA):"));

			listaVehiculosCarga.add(new Camion(matricula, dias, pesoMaximoAutorizado));
			System.out.println("Has registrado correctamente los datos del camion!");
		}
		
	}

	
//----------------------------------------------------------------------------------------------------------------------------------------
//	METODOS BUSQUEDA DE VEHICULOS (PASAJEROS/CARGA) Y TO_STRING
//----------------------------------------------------------------------------------------------------------------------------------------
	
	public Vehiculo buscaVehiculoPasajeros(String matricula) {
		
		for (Vehiculo vehiculo : listaVehiculosPasajeros) {
			if (!listaVehiculosPasajeros.isEmpty()) {
				vehiculo.getMatricula().equalsIgnoreCase(matricula);
				JOptionPane.showMessageDialog(null, vehiculo.toString());
				return vehiculo;
			}
		}
		
		 JOptionPane.showMessageDialog(null, "Vehículo con matrícula " + matricula + " no encontrado");
		    return null;
	}
	
	public Vehiculo buscaVehiculosCarga(String matricula) {
		
		for (Vehiculo vehiculo : listaVehiculosCarga) {
			if (!listaVehiculosPasajeros.isEmpty()) {
				vehiculo.getMatricula().equalsIgnoreCase(matricula);
				JOptionPane.showMessageDialog(null, vehiculo.toString());
				return vehiculo;
			}
		}
		
		 JOptionPane.showMessageDialog(null, "Vehículo con matrícula " + matricula + " no encontrado");
		    return null;
	}
	
	
	//muestra los precios de los diferente vehiculos
	public void mostrarPrecios() {

		int seleccionarTipoVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Que tipo de vehiculo deseas ver el precio:"
						+ "\n 1. Vehiculo pasajero" + "\n2. Vehiculo carga" + "\n3. Ambas lista de vehiculos"));
		
		if (seleccionarTipoVehiculo == 1) {
			if (!listaVehiculosPasajeros.isEmpty()) {

				for (Vehiculo vehiculo : listaVehiculosPasajeros) {
					JOptionPane.showMessageDialog(null, vehiculo.toString());
				}
			} else {
				JOptionPane.showMessageDialog(null, "La lista esta vacia!");
			}
		} else if (seleccionarTipoVehiculo == 2) {
			if (!listaVehiculosCarga.isEmpty()) {

				for (Vehiculo vehiculo : listaVehiculosCarga) {
					JOptionPane.showMessageDialog(null, vehiculo.toString());
				}
			} else {
				JOptionPane.showMessageDialog(null, "La lista esta vacia");
			}
		} else if (seleccionarTipoVehiculo == 3) {
			for (Vehiculo vehiculo : listaVehiculosPasajeros) {
				JOptionPane.showMessageDialog(null, vehiculo.toString());
			}

			for (Vehiculo vehiculo : listaVehiculosCarga) {
				JOptionPane.showMessageDialog(null, vehiculo.toString());
			}
		}else {
			JOptionPane.showMessageDialog(null, "Error: selecciona un opcion valida");
		}

	}
	
}
