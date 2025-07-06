package ejerciciosFigurasGeometricas;

public class Rectangulo implements FiguraGeometrica {

	// Atributos
	private double base;
	private double altura;

	// Constructor

	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	// Setters and Getters
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	// **********METODOS******************

	// Calcular area
	@Override
	public double calcularArea() {
		return base * altura;
	}

	// Calcular perimetro
	@Override
	public double calcularPerimetro() {
		return 2 * (base + altura);
	}

}
