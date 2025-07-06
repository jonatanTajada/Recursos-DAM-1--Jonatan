package ejerciciosFigurasGeometricas;

public class Circulo implements FiguraGeometrica {

	// Atributos
	private double radio;

	// Constructor
	public Circulo(double radio) {
		this.radio = radio;
	}

	// Setters and Getters

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	//// ********METODOS******

	// Calcular Area
	public double calcularArea() {
		return Math.PI * radio * radio;
	}

	// Calcular Perimetro
	public double calcularPerimetro() {
		return 2 * Math.PI * radio;
	}

}
