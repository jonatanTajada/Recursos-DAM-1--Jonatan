package ejercicioAlquilerVehiculos_Herencia;

public class VehiculoCarga  extends Vehiculo{

	
	//Atributos
	protected double suplementoVehiculoCarga = 20;
	protected double pesoMaximoAutorizada;
	protected  final double PRECIO_POR_TONELADA_VEHICULOS_CARGA = Vehiculo.PRECIO_BASE + (suplementoVehiculoCarga * pesoMaximoAutorizada) ;
	
	//Constructor
	public VehiculoCarga(String matricula, int dias, double pesoMaximoAutorizada) {
		super(matricula, dias);
		this.pesoMaximoAutorizada = pesoMaximoAutorizada;
	}
	
	//obtener precio
	public double precioAlquiler(int dias) {
		return PRECIO_POR_TONELADA_VEHICULOS_CARGA;
	}
	
	//mostrar vehiculo carga
	
	@Override
	public String toString() {
		return "-Datos del Vehiculo de carga: " + "\nMatricula: " + super.matricula 
				+ "\nImporte suplemento vehiculo de carga: " + suplementoVehiculoCarga
				+ "\nPeso Maximo Autorizada vehiculo de carga es: " + this.pesoMaximoAutorizada 
				+ "€." +  "\nDias de alquiler: " + super.dias;
	}

}
