package ejerciciosFigurasGeometricas;

public class Cuadrado implements FiguraGeometrica {

	// Atributos
	private double lado;

	// Constructor

	public Cuadrado(double lado) {
		this.lado = lado;
	}

	// Setters and Getterss
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	// ******METODOS************

	// Calcula area
	@Override
	public double calcularArea() {
		return lado * lado;
	}

	// calcula perimetro
	@Override
	public double calcularPerimetro() {
		return 4 * lado;
	}

}
