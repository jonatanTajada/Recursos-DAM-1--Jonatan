package ejercicioAlquilerVehiculos_Herencia;

public class Furgoneta extends VehiculoCarga {

	
	//Atributos...heredo de la clase padre
	

	//Constructor
	public Furgoneta(String matricula, int dias, double pesoMaximoAutorizada) {
		super(matricula, dias, pesoMaximoAutorizada);
	}

	
	
	// el precio de la furgoneta esta implementado direcrtamente en el padre....
	
	
	@Override
	public String toString() {
		return "-Datos del Vehiculo furgoneta: " + "\nMatricula: " + super.matricula 
				+ "\nImporte suplemento vehiculo de carga: " + super.suplementoVehiculoCarga
				+ "\nPeso Maximo Autorizada vehiculo de carga es: " + super.pesoMaximoAutorizada 
				+ "€." +  "\nDias de alquiler: " + super.dias;
	}
	
	
	
	
	
	
}
