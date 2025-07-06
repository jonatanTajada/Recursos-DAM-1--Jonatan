package ejerciciosFigurasGeometricas;

public class Rombo implements FiguraGeometrica {

	// Atributos
	private double diagonalMayor;
	private double diagonalMenor;

	// Constructor

	public Rombo(double base, double altura) {
		this.diagonalMayor = base;
		this.diagonalMenor = altura;
	}

	// Setters and Getters
	public double getBase() {
		return diagonalMayor;
	}

	public void setBase(double base) {
		this.diagonalMayor = base;
	}

	public double getAltura() {
		return diagonalMenor;
	}

	public void setAltura(double altura) {
		this.diagonalMenor = altura;
	}

	// **********METODOS******************

	// Calcular area
	public double calcularArea() {
		return (diagonalMayor * diagonalMenor) / 2;
	}

	// Calcular perimetro
	public double calcularPerimetro() {
		return 4 * Math.sqrt((Math.pow(diagonalMayor / 2, 2)) + (Math.pow(diagonalMenor / 2, 2)));
	}

}
