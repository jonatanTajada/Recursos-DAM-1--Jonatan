package ejercicioAlquilerVehiculos_Herencia;



public class MicroBus extends VehiculoPasajero{

	//Atributos
	protected  double suplementoMicroBus = 2;
	protected  final double PRECIO_POR_PLAZA_Y_DIA_MICRO_BUS = Vehiculo.PRECIO_BASE + (suplementoCoche * plazas) + (suplementoCoche * dias)
													+ (suplementoMicroBus * plazas);
	//Constructor
	public MicroBus(String matricula, int dias, int plazas) {
		super(matricula, dias, plazas);
	}
	
	@Override
	public double precioAlquiler(int dias) {
		return PRECIO_POR_PLAZA_Y_DIA_MICRO_BUS;
	}
	
	//mostrar Micro Bus
	@Override
	public String toString() {
		return "-Datos del MicroBus: " + "\nMatricula: " + super.matricula + "\nCantidad plazas: " + this.plazas
				+ "\nImporte suplemento: " + suplementoMicroBus + "€." +  "\nDias de alquiler: " + super.dias;
	}

}
