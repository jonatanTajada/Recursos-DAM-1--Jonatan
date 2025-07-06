package ejerciciosFigurasGeometricas;

public class Trapecio implements FiguraGeometrica {

	// Atributos
	private double baseMayor;
    private double baseMenor;
    private double ladoIzquierdo;
    private double ladoDerecho;
    private double altura;

	// Constructor
    
    public Trapecio(double baseMayor, double baseMenor, double ladoIzquierdo, double ladoDerecho, double altura) {
		this.baseMayor = baseMayor;
		this.baseMenor = baseMenor;
		this.ladoIzquierdo = ladoIzquierdo;
		this.ladoDerecho = ladoDerecho;
		this.altura = altura;
	}

	
	// Setters and Getters
    
    public double getBaseMayor() {
		return baseMayor;
	}


	public void setBaseMayor(double baseMayor) {
		this.baseMayor = baseMayor;
	}


	public double getBaseMenor() {
		return baseMenor;
	}


	public void setBaseMenor(double baseMenor) {
		this.baseMenor = baseMenor;
	}


	public double getLadoIzquierdo() {
		return ladoIzquierdo;
	}


	public void setLadoIzquierdo(double ladoIzquierdo) {
		this.ladoIzquierdo = ladoIzquierdo;
	}


	public double getLadoDerecho() {
		return ladoDerecho;
	}


	public void setLadoDerecho(double ladoDerecho) {
		this.ladoDerecho = ladoDerecho;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}

	// **********METODOS******************

	// Calcular area
	public double calcularArea() {
        return ((baseMayor + baseMenor) / 2) * altura;
    }

    @Override
    public double calcularPerimetro() {
        return baseMayor + baseMenor + ladoIzquierdo + ladoDerecho;
    }

}
