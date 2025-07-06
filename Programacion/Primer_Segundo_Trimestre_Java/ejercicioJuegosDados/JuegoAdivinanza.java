package ejercicioJuegosDados;

import java.util.Random;
import java.util.Scanner;

// tipico juego de adivina numero

public class JuegoAdivinanza implements Juego {

	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	private int numeroAdivinar;
	private int intentos;

	// Método para iniciar el juego, genera un número aleatorio entre 1 y 100
	@Override
	public void iniciar() {
		numeroAdivinar = random.nextInt(100) + 1;
		intentos = 0;
	}

	// Método principal del juego que permite al jugador adivinar el número
	@Override
	public void jugar() {
		
		System.out.println("Juega y adivina el numero!!!");
		int intento;

		do {
			System.out.print("\nAdivina un numero entre el 1 y 100: ");
			intento = scanner.nextInt();
			intentos++;

			if (intento < numeroAdivinar) {
				System.out.println("Introduce un numero mayor.");
			} else if (intento > numeroAdivinar) {
				System.out.println("Introduce un numero menor.");
			} else {
				System.out.println("Ganaste despues de " + intentos + " intentos.");
			}
			
			
		} while (intento != numeroAdivinar);
	}

	// Método para finalizar el juego
	@Override
	public void finalizar() {
		System.out.println("Fin del juego adivina numero, hasta la proxima!!");
	}

}
