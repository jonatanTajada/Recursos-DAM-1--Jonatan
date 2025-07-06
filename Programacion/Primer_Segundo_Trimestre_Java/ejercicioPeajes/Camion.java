package ejercicioPeajes;
//implementa de Vehiculo
public class Camion implements Vehiculo {
	private String placa;
	private int numEjes;

	public Camion(String placa, int numEjes) {
		this.placa = placa;
		this.numEjes = numEjes;
	}

	@Override
	public double calcularPeaje() {
		return 5.0 * numEjes; // Valor * eje para camiones
	}

	@Override
	public String getPlaca() {
		return placa;
	}

	@Override
	public String toString() {
		return "Numero de placa del camion es: " + placa + "\nNumero de ejes: " + numEjes;
	}
}
