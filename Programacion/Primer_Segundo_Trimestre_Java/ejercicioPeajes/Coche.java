package ejercicioPeajes;
//implementa de Vehiculo
public class Coche implements Vehiculo{
	
	private String placa;

	public Coche(String placa) {
		this.placa = placa;
	}

	@Override
	public double calcularPeaje() {
		return 15.0; 
	}

	@Override
	public String getPlaca() {
		return placa;
	}

	@Override
	public String toString() {
		return "Numero de placa del coche es: " + placa;
	}
}
