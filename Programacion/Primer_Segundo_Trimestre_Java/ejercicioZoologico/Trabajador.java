package ejercicioZoologico;

public class Trabajador {
	private String nombreApellido;
	private String especialidad;
	private String dni;

	public Trabajador(String nombreApellido, String especialidad, String dni) {
		this.nombreApellido = nombreApellido;
		this.especialidad = especialidad;
		this.dni = dni;
	}

	// Getters y setters
	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Trabajador{" + "nombreApellido='" + nombreApellido + '\'' + ", especialidad='" + especialidad + '\''
				+ ", dni='" + dni + '\'' + '}';
	}

}
