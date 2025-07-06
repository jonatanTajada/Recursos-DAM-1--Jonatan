package ejercicioJuegosDados;

// el main de los juegos
public class App {

	public static void main(String[] args) {

		 // Juego de dados
        JuegoDados juegoDados = new JuegoDados();
        juegoDados.iniciar();
        juegoDados.jugar();
        juegoDados.finalizar();

        System.out.println();

        // Juego de adivinanza
        JuegoAdivinanza juegoAdivinanza = new JuegoAdivinanza();
        juegoAdivinanza.iniciar();
        juegoAdivinanza.jugar();
        juegoAdivinanza.finalizar();
		
	}

}
