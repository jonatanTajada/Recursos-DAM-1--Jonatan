package ejercicioAlquilerVehiculos_Herencia;

//SUPERCLASE-CLASE PADRE

public   class Vehiculo {

	
	//Atributos
	protected   final static double PRECIO_BASE = 50;
	protected  String matricula;
	protected int dias;
	
	//Constructor
	public Vehiculo(String matricula, int dias) {
		this.matricula = matricula;
		this.dias = dias;
	}
	
	//gettes and setters
	public int getDias() {
		return dias;
	}


	public void setDias(int dias) {
		this.dias = dias;
	}


	public static double getPrecioBase() {
		return PRECIO_BASE;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public  double getPrecioPorDia() {
		return PRECIO_BASE;
	}
	
	// obtener precioAlquiler por dias
//	public double calcularPrecio(int dias) {
//		return PRECIO_POR_DIA * dias;
//	}
	
	public  double precioAlquiler(int dias) {
		return PRECIO_BASE * dias;
	};


	@Override
	public String toString() {
		return "- Datos del Vehiculo: " + matricula;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
