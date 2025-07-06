package ejercicioAlquilerVehiculos_Herencia;

import javax.swing.JOptionPane;

public class AppGestionVehiculos {

	public static void main(String[] args) {

		RegistroVehiculos registro = new RegistroVehiculos();

		int opcion;

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1:
				registro.registrarCoche();
				break;
			case 2:
				registro.registrarMicroBus();
				break;
			case 3:
				registro.registrarFurgoneta();
				break;
			case 4:
				registro.registrarCamion();
				break;
			case 5:
				registro.mostrarPrecios();
				break;
			case 6:
				buscarVehiculo(registro);
				break;
			case 7:
				System.out.println("Gracias por usar el sistema de alquiler de vehículos.");
				break;
			default:
				System.out.println("Error: por favor, introduzca una de las opciones del menú.");
			}

		} while (opcion != 7);
	}

	private static int mostrarMenu() {
		String menu = "Menu Principal\n" + "1. Registrar Coche\n" + "2. Registrar MicroBus\n"
				+ "3. Registrar Furgoneta\n" + "4. Registrar Camion\n" + "5. Mostrar Precios\n"
				+ "6. Buscar Vehiculo por Matricula\n" + "7. Salir\n\n" + "Ingrese el numero de la opcion deseada:";

		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	private static void buscarVehiculo(RegistroVehiculos registro) {
		String matriculaBuscada = JOptionPane.showInputDialog("Ingrese la matricula del vehiculo a buscar:");
		Vehiculo vehiculoEncontrado = registro.buscaVehiculoPasajeros(matriculaBuscada);

		if (vehiculoEncontrado != null) {
			System.out.println("Vehiculo encontrado:\n" + vehiculoEncontrado.toString());
		} else {
			System.out.println("Vehiculo con matricula " + matriculaBuscada + " no encontrado");
		}
	}
}
