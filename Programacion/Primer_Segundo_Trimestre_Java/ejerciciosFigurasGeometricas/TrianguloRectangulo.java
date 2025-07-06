package ejerciciosFigurasGeometricas;

public class TrianguloRectangulo implements FiguraGeometrica {

	// Atributos
	private double base;
	private double altura;

	// Constructor

	public TrianguloRectangulo(double base, double altura) {
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
		return 0.5 * base * altura;
	}

	// Calcular perimetro
	@Override
	public double calcularPerimetro() {
		double hipotenusa = calcularHipotenusa();
		return base + altura + hipotenusa;
	}

	// Calcular hipotenusa
	public double calcularHipotenusa() {
		return Math.sqrt(base * base + altura * altura);
	}

	// Determinar tipo de triangulo (Equilatero or Isosceles or Escaleno)
	public String determinarTipoTriangulo() {
		
		if (base == altura) {
			return "Triangulo Equilatero";
		} else if (base == altura || base == calcularHipotenusa() || altura == calcularHipotenusa()) {
			return "Triangulo Isosceles";
		} else {
			return "Triangulo Escaleno";
		}
	}
	
	//dudas de cual es la formula correcta!!
//	public String determinarTipoTriangulo() {
//	    if (base == altura && altura == calcularHipotenusa()) {
//	        return "Triángulo Equilátero";
//	    } else if (base == altura || base == calcularHipotenusa() || altura == calcularHipotenusa()) {
//	        return "Triángulo Isósceles";
//	    } else {
//	        return "Triángulo Escaleno";
//	    }
//	}


}
