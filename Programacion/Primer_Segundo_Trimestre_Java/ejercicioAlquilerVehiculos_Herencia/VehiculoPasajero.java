package ejercicioAlquilerVehiculos_Herencia;

public class VehiculoPasajero extends Vehiculo{

	
	//Atributos
	protected  double suplementoCoche = 1.5;
	protected  int plazas;
	protected  final double PRECIO_POR_PLAZA_Y_DIA_VEHICULOS_PASAJERO = Vehiculo.PRECIO_BASE + (suplementoCoche * plazas) + (suplementoCoche * dias);

	


	//Constructor
	public VehiculoPasajero(String matricula, int dias,  int plazas) {
		super(matricula, dias);
		this.plazas = plazas;	
	}


	// getters and setters
	public double getSuplemento() {
		return suplementoCoche;
	}

	public void setSuplemento(double suplemento) {
		this.suplementoCoche = suplemento;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public double getPRECIO_POR_PLAZA_Y_DIA() {
		return PRECIO_POR_PLAZA_Y_DIA_VEHICULOS_PASAJERO;
	}
	 
	public int getDias() {
		return dias;
	}


	public void setDias(int dias) {
		this.dias = dias;
	}
	
	//obtener precio
	@Override
	public double precioAlquiler(int dias) {
		return PRECIO_POR_PLAZA_Y_DIA_VEHICULOS_PASAJERO;

	}
	
	//mostrar vehiculo
	@Override
	public String toString() {
		return "-Datos del Vehiculo pasajero: " + "\nMatricula: " + super.matricula + "\nCantidad plazas: " + this.plazas
				+ "\nImporte suplemento: " + this.suplementoCoche + "€." +  "\nDias de alquiler: " + super.dias;
	}
	
	
	

}
