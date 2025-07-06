package ejercicioZoologico;

public class Animal {
	private String codigo;
	private String nombre;
	private String especie;
	private int anoNacimiento;
	private Instalacion instalacion;

	public Animal(String codigo, String nombre, String especie, int anoNacimiento, Instalacion instalacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.especie = especie;
		this.anoNacimiento = anoNacimiento;
		this.instalacion = instalacion;
	}

	// Getters y setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getAnoNacimiento() {
		return anoNacimiento;
	}

	public void setAnoNacimiento(int anoNacimiento) {
		this.anoNacimiento = anoNacimiento;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	
	
		@Override
		public String toString() {
			return "Animal{" + "codigo='" + codigo + '\'' + ", nombre='" + nombre + '\'' + ", especie='" + especie
					+ '\'' + ", anoNacimiento=" + anoNacimiento + ", instalacion=" + instalacion + '}';
		}

}
