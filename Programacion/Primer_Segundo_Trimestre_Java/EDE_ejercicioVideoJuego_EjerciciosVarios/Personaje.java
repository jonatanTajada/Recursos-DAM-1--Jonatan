package EDE_ejercicioVideoJuego_EjerciciosVarios;

public class Personaje {

	 private int nivelEnergia;
	    private int numVidas;
	    private int capacidadOfensiva;
	    private List<ObjetoMueble> mochila;

	    public Personaje() {
	        mochila = new ArrayList<>();
	    }

	    public void recogerObjeto(ObjetoMueble obj) {
	        // Lógica para recoger un objeto y añadirlo a la mochila
	    }

	    public void usarObjeto() {
	        // Lógica para usar un objeto de la mochila
	    }
}
