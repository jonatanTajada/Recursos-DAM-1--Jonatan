package ejercicioZoologico;

public class Instalacion {
	private int numero;
	private Zona zona;
	private String descripcion;
	private int anoInstalacion;

	public Instalacion(int numero, Zona zona, String descripcion, int anoInstalacion) {
		this.numero = numero;
		this.zona = zona;
		this.descripcion = descripcion;
		this.anoInstalacion = anoInstalacion;
	}

	// Getters y setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAnoInstalacion() {
		return anoInstalacion;
	}

	public void setAnoInstalacion(int anoInstalacion) {
		this.anoInstalacion = anoInstalacion;
	}

	@Override
	public String toString() {
		return "Instalacion{" + "numero=" + numero + ", zona=" + zona + ", descripcion='" + descripcion + '\''
				+ ", anoInstalacion=" + anoInstalacion + '}';
	}
}
