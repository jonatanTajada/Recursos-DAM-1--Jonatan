package examen_Programacion_2º_Trimestre_Jonatan_Tajada_Rico;

import java.time.LocalDate;

public abstract class Servicio {

	// atributos
	protected String nombreApellidosTrabajador;
	protected LocalDate fechaInicioServicio;
	protected String nombreApellidosCliente;

	// constructor
	public Servicio(String nombreApellidosTrabajador, LocalDate fechaInicioServicio, String nombreApellidosCliente) {
		this.nombreApellidosTrabajador = nombreApellidosTrabajador;
		this.fechaInicioServicio = fechaInicioServicio;
		this.nombreApellidosCliente = nombreApellidosCliente;
	}

	// setters and getters
	public String getNombreApellidosTrabajador() {
		return nombreApellidosTrabajador;
	}

	public void setNombreApellidosTrabajador(String nombreApellidosTrabajador) {
		this.nombreApellidosTrabajador = nombreApellidosTrabajador;
	}

	public LocalDate getFechaInicioServicio() {
		return fechaInicioServicio;
	}

	public void setFechaInicioServicio(LocalDate fechaInicioServicio) {
		this.fechaInicioServicio = fechaInicioServicio;
	}

	public String getNombreApellidosCliente() {
		return nombreApellidosCliente;
	}

	public void setNombreApellidosCliente(String nombreApellidosCliente) {
		this.nombreApellidosCliente = nombreApellidosCliente;
	}

	// ------Metodos------------------------

	// costeMaterial
	public abstract double costeMaterial();

	// costeManoObra
	public abstract double costeManoObra();

	// coste total
	public abstract double costeTotal();

	// detalle servicio
	public abstract double detalleServicio();

	// tostring
	@Override
	public String toString() {
		return "\nNombre y apellidos del trabajador que realiza servicio: " + this.nombreApellidosTrabajador
				+ "\nFecha de inicio del servicio: " + this.fechaInicioServicio
				+ "\nNombre y apellidos del cliente que contrata servicio: " + this.nombreApellidosCliente;
	}

}
