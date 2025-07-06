package ejercicioBibliotecaFebrero;

import java.util.List;

public class Usuario {

	//atributos
	private String dni;
	private String nombre;
	private int prestamosMaximosSimultaneos;
	
	
	//constructor
	public Usuario(String dni, String nombre, int prestamosMaximosSimultaneos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.prestamosMaximosSimultaneos = prestamosMaximosSimultaneos;
	}
	
	
	//setters and getters
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrestamosMaximosSimultaneos() {
		return prestamosMaximosSimultaneos;
	}

	public void setPrestamosMaximosSimultaneos(int prestamosMaximosSimultaneos) {
		this.prestamosMaximosSimultaneos = prestamosMaximosSimultaneos;
	}


	public int obtenerPrestamosActivos(List<Prestamo> prestamos) {
		int prestamosActivos = 0;
		for (Prestamo prestamo : prestamos) {
			if (prestamo.getUsuario().equals(this)) {
				prestamosActivos++;
			}
		}
		return prestamosActivos;
	}
	
	@Override
	//to string
	public String toString() {
		return "\nD.N.I.: " + this.dni + "\nNombre: " + this.nombre;
	}
	

}
