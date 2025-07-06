package ejercicioHotel;

import java.time.LocalDate;
import java.util.Date;

import java.util.Date;


	public class Reserva {
		
	//Atributos	
	private Cliente cliente;
	private Habitacion habitacion;
	private LocalDate fechaEntrada;
	private int numeroDias;

	//Constructor
	public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaEntrada, int numeroDias) {
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.fechaEntrada = fechaEntrada;
		this.numeroDias = numeroDias;
	}

	
	//getters
	public Cliente getCliente() {
		return cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	
	//toString
	@Override
	public String toString() {
		return "\nCliente: " + cliente +  "\nHabitacion: " + habitacion + "\nFecha entrada:" + fechaEntrada
				+ "\nNumero dias: " + numeroDias;
	}
	
	
	
}
