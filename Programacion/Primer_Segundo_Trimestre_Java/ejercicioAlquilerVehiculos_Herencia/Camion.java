package ejercicioAlquilerVehiculos_Herencia;

public class Camion extends VehiculoCarga {

	protected double suplementoCamion = 40; 
	protected  final double PRECIO_VEHICULO_CAMION = Vehiculo.PRECIO_BASE 
							+ (suplementoVehiculoCarga * pesoMaximoAutorizada)  + suplementoCamion;
	
	
	
	
	public Camion(String matricula, int dias, double pesoMaximoAutorizada) {
		super(matricula, dias, pesoMaximoAutorizada);
	}

	
	
	//obtener precio
		@Override
		public double precioAlquiler(int dias) {
			return PRECIO_VEHICULO_CAMION;
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
