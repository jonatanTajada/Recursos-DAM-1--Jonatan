package ejercicioJuegosDados;

import java.util.Random;
import java.util.Scanner;

// clase que se implementa para un juego de 2 personas con 2 dados y numero > gana.

public class JuegoDados implements Juego {
	
	 Scanner scanner = new Scanner(System.in);
	 Random random = new Random();

	private String jugador1;
    private String jugador2;
    private int valorDadoJugador1;
    private int valorDadoJugador2;

    // Método para iniciar el juego, solicita los nombres de los jugadores
    public void iniciar() {
      
        System.out.print("Ingrese el nombre del primer jugador: ");
        jugador1 = scanner.nextLine();

        System.out.print("Ingrese el nombre del segundo jugador: ");
        jugador2 = scanner.nextLine();
    }
    
	
 // Método jugar  dados.
    public void jugar() {
      
        valorDadoJugador1 = random.nextInt(6) + 1;
        valorDadoJugador2 = random.nextInt(6) + 1;

        System.out.println(jugador1 + " le ha salido el valor: " + valorDadoJugador1);
        System.out.println(jugador2 + " le ha salido el valor: " + valorDadoJugador2);

        if (valorDadoJugador1 > valorDadoJugador2) {
            System.out.println("***Ha ganado el jugador 1: " + jugador1  + " , con el numero: " + valorDadoJugador1);
        } else if (valorDadoJugador1 < valorDadoJugador2) {
        	System.out.println("***Ha ganado el jugador 2: " + jugador2 + " ,con el numero: " + valorDadoJugador2);
        } else {
            System.out.println("***Empate!! Ambos jugadores tienen el numero: " + valorDadoJugador1);
        }
    }
    
    
 // Método para finalizar el juego
    public void finalizar() {
        System.out.println("Fin del juego dados, hasta la proxima!!!");
    }
	
}
