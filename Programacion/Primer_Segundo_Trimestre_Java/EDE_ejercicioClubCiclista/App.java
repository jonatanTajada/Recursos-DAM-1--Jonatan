package EDE_ejercicioClubCiclista;

public class App {

	public static void main(String[] args) {

		// Crear velocistas
		Velocista velocista1 = new Velocista(1, "Velocista1", 40, 300);
		Velocista velocista2 = new Velocista(4, "Velocista2", 42, 320);

		// Crear escaladores
		Escalador escalador1 = new Escalador(2, "Escalador1", 10.5f, 15.0f);
		Escalador escalador2 = new Escalador(5, "Escalador2", 11.0f, 17.0f);

		// Crear contrarrelojistas
		ContraRelojista contraRelojista1 = new ContraRelojista(3, "Contrarrelojista1", 50);
		ContraRelojista contraRelojista2 = new ContraRelojista(6, "Contrarrelojista2", 55);

		// Establecer tiempos para velocistas
		velocista1.setTiempo(300);
		velocista2.setTiempo(320);

		// Establecer tiempos para escaladores y contrarrelojistas
		escalador1.setTiempo(150);
		escalador2.setTiempo(200);

		contraRelojista1.setTiempo(50);
		contraRelojista2.setTiempo(55);

		// Crear equipos
		Equipo equipo1 = new Equipo("Euskaltel", "España");
		equipo1.agregarCiclista(velocista1);
		equipo1.agregarCiclista(escalador1);
		equipo1.agregarCiclista(contraRelojista1);

		Equipo equipo2 = new Equipo("Movistar", "Francia");
		equipo2.agregarCiclista(velocista2);
		equipo2.agregarCiclista(escalador2);
		equipo2.agregarCiclista(contraRelojista2);

		// Imprimir datos de los equipos
		System.out.println("Datos del Equipo 1:\n------------------");
		equipo1.imprimirDatosEquipo();

		System.out.println("\nDatos del Equipo 2:\n----------------");
		equipo2.imprimirDatosEquipo();

		// Calcular y mostrar el tiempo total de los equipos
		equipo1.calcularTiempoTotal();
		equipo2.calcularTiempoTotal();

		System.out.println("\nTiempo total del Equipo 1: " + equipo1.getTiempoTotal() + " minutos");
		System.out.println("Tiempo total del Equipo 2: " + equipo2.getTiempoTotal() + " minutos");

		// Listar nombres de ciclistas de un equipo
		System.out.println("\nCiclistas del Equipo 1:");
		equipo1.listarNombresCiclistas();

		// Buscar e imprimir datos de un ciclista por ID
		int idBuscado = 5;
		Ciclista ciclistaEncontrado = equipo2.buscarCiclistaPorId(idBuscado);

		if (ciclistaEncontrado != null) {
			System.out.println("\nDatos del ciclista encontrado:");
			ciclistaEncontrado.imprimirDatos();
		} else {
			System.out.println("\nCiclista con ID " + idBuscado + " no encontrado.");
		}
	}
}
