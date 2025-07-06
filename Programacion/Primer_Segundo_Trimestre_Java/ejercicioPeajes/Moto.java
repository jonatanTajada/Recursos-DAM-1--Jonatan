package ejercicioPeajes;
//implementa de Vehiculo
public class Moto implements Vehiculo {
	private String placa;

	public Moto(String placa) {
		this.placa = placa;
	}

	@Override
	public double calcularPeaje() {
		return 5.0; 
	}

	@Override
	public String getPlaca() {
		return placa;
	}

	@Override
	public String toString() {
		return "Numero de placa de la moto es: " + placa;
	}
}
