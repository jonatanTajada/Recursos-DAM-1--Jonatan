package ejercicioAlquilerVehiculos_Herencia;

public class Coche extends VehiculoPasajero {

	//Atributos
	//los heredo de la clase padre
	

	//Constructor
	public Coche(String matricula, int dias,  int plazas) {
		super(matricula, dias, plazas);
	}
	
	//mostrar coche
	@Override
	public String toString() {
		return "-Datos del coche: " + "\nMatricula: " + super.matricula + "\nCantidad plazas: " + this.plazas
				+ "\nImporte suplemento: " + super.suplementoCoche + "€." +  "\nDias de alquiler: " + super.dias;
	}
	

}
