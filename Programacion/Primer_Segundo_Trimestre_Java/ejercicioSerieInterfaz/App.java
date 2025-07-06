package ejercicioSerieInterfaz;

public class App {

	public static void main(String[] args) {

		// Crear arrays de Series y Videojuegos
		Entregable[] seriesArray = new SerieClase[5];
		//SerieClase[] seriesArray = new SerieClase[5];
		
		VideoJuego[] videojuegosArray = new VideoJuego[5];
		

		// Crear objetos en cada posición del array
		seriesArray[0] = new SerieClase("Era aquello", 15, "Drama", "Carmen Lalla");
		seriesArray[1] = new SerieClase("Marvel", "Primos Lopez");

		videojuegosArray[0] = new VideoJuego("Splinter Cell", 50, "Sigilo+", "JuegosProd");
		videojuegosArray[1] = new VideoJuego("Metal Gears", 15, "Sigilo", "Mi empresa");

		// Entregar algunos Videojuegos y Series
		seriesArray[0].entregar();
		seriesArray[1].entregar();
		videojuegosArray[0].entregar();

		// Contar y devolver Series y Videojuegos entregados
		int seriesEntregadas = contarEntregados(seriesArray);
		int videojuegosEntregados = contarEntregados(videojuegosArray);

		System.out.println("Cantidad de Series entregadas: " + seriesEntregadas);
		System.out.println("Cantidad de Videojuegos entregados: " + videojuegosEntregados);
		System.out.println();

		// Encontrar Videojuego y Serie con mas horas estimadas y Serie con mas temporadas
		VideoJuego videojuegoMasHoras = (VideoJuego) encontrarMaximo(videojuegosArray);
		Serie serieMasTemporadas = (Serie) encontrarMaximo(seriesArray);

		// Mostrar informacion de los objetos encontrados
		System.out.println("Caracterisitcas del videojuego con mas horas estimadas: " + videojuegoMasHoras.toString());
		System.out.println("***************************************************************************");
		System.out.println("Caracteristicas de la serie con mas temporadas: " + serieMasTemporadas.toString());
	}
	
	
	
	//**********METODOS*****************************

	// Método para contar objetos entregados en un array de Entregables
	private static int contarEntregados(Entregable[] array) {
	    int count = 0;
	    for (Entregable entregable : array) {
	        if (entregable != null && entregable.isEntregado()) {
	            count++;
	        }
	    }
	    return count;
	}
	
	// Metodo para encontrar el objeto con el valor maximo en un array de tipo Entregables
	private static Entregable encontrarMaximo(Entregable[] array) {
	    Entregable maximo = null;  // Inicializamos maximo como null
	    for (Entregable objeto : array) {
	        if (objeto != null) {
	            // Verificamos que el objeto no sea null antes de llamar a compareTo
	            if (maximo == null || objeto.compareTo(maximo) > 0) {
	                maximo = objeto;
	            }
	        }
	    }
	    return maximo;
	}


}
