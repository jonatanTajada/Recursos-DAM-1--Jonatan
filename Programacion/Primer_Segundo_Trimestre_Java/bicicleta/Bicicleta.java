package bicicleta;

import java.util.Scanner;

public class Bicicleta {

	static Scanner scanner = new Scanner(System.in);

	//ATRIBUTOS
	private int velocidadActual;
	private int platoActual;
	private int pinionActual;
	private static final int MAX_PLATO = 3;
	private static final int MAX_PINION = 7;
	private boolean datosIncorrectos;

	
	//CONSTRUCTORES
	public Bicicleta(int velocidadActual, int platoActual, int pinionActual) {

		this.velocidadActual = velocidadActual;

		if (platoActual >= 1 && platoActual <= MAX_PLATO) {
			this.platoActual = platoActual;
		} else {
			System.err.println("Plato no válido. Elige un valor entre 1 y " + MAX_PLATO);
			this.platoActual = 1;
			datosIncorrectos = true;
		}

		if (pinionActual >= 1 && pinionActual <= MAX_PINION) {
			this.pinionActual = pinionActual;
		} else {
			System.err.println("Piñon no válido. Elige un valor entre 1 y " + MAX_PINION);
			this.pinionActual = 1;
			datosIncorrectos = true;
		}

	}

	public Bicicleta() {
		velocidadActual = 0;
		platoActual = 1;
		pinionActual = 1;
	}

	
	//SETTERS AND GETTERS
	public int getVelocidadActual() {
		return velocidadActual;
	}

	public void setVelocidadActual(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}

	public int getPlatoActual() {
		return platoActual;
	}

	public void setPlatoActual(int platoActual) {
		this.platoActual = platoActual;
	}

	public int getPinionActual() {
		return pinionActual;
	}

	public void setPinionActual(int pinionActual) {
		this.pinionActual = pinionActual;
	}

	//METODOS
	public int acelerar() {
		this.velocidadActual *= 2;
		return this.velocidadActual;
	}

	public int frenar() {
		this.velocidadActual /= 2;
		return this.velocidadActual;
	}

	public int cambiarPlato(int plato) {

		if (plato >= 1 && plato <= MAX_PLATO) {
			this.platoActual = plato;
		} else {
			System.err.println("Plato no válido. Elige un valor entre 1 y " + MAX_PLATO);
		}
		
		return this.platoActual;
	}

	public int cambiarPinion(int pinion) {

		if (pinion >= 1 && pinion <= MAX_PINION) {
			this.pinionActual = pinion;
		} else {
			System.err.println("Piñón no válido. Elige un valor entre 1 y " + MAX_PINION);
		}
		return this.pinionActual;
	}

	@Override
	public String toString() {
		String estado = "Datos de la bicicleta:\n";
		
		estado += "Velocidad Actual: " + velocidadActual + "\n";
		estado += "Plato actual: " + platoActual + "\n";
		estado += "Piñón actual: " + pinionActual + "\n";

		if (datosIncorrectos) {
			estado += "Nota: Algunos datos de la bicicleta son incorrectos.\n";
		}

		return estado;
	}

	public static void main(String[] args) {

		Bicicleta miBicicleta = new Bicicleta(150, 2, 1);

		System.out.println(miBicicleta.toString());
		
		System.out.println();
		
		miBicicleta.acelerar();
		miBicicleta.setPlatoActual(3);
		miBicicleta.setPinionActual(3);
		System.out.println(miBicicleta.toString());
		
		System.out.println();
		
		miBicicleta.frenar();
		miBicicleta.cambiarPinion(2);
		miBicicleta.cambiarPlato(1);
		System.out.println(miBicicleta.toString());
		
		System.out.println("*********SIGUIENTE OBJETO************");
		
		Bicicleta tuBicicleta = new Bicicleta(15, 2, 1);

		System.out.println(tuBicicleta.toString());
		
		System.out.println();
		
		tuBicicleta.acelerar();
		tuBicicleta.setPlatoActual(3);
		System.out.println(tuBicicleta.toString());
		
		System.out.println();
		
		tuBicicleta.frenar();
		tuBicicleta.cambiarPinion(2);
		tuBicicleta.cambiarPlato(25);
		System.out.println(tuBicicleta.toString());
		

	}

}
