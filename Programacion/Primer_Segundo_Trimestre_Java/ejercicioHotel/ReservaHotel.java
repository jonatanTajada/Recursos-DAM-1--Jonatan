package ejercicioHotel;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ReservaHotel {
//	private List<Habitacion> habitaciones;
//	private List<Reserva> reservas;
//	private Map<Integer, Double> descuentos;
//
//	public ReservaHotel() {
//		habitaciones = new ArrayList<>();
//		reservas = new ArrayList<>();
//		descuentos = new HashMap<>();
//	}
//
//	// Métodos para el recepcionista
//	public List<Habitacion> obtenerHabitacionesDisponibles(String tipo) {
//		List<Habitacion> habitacionesDisponibles = new ArrayList<>();
//		for (Habitacion habitacion : habitaciones) {
//			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
//				habitacionesDisponibles.add(habitacion);
//			}
//		}
//		return habitacionesDisponibles;
//	}
//
//	public double preguntarPrecioHabitacion(String tipo) {
//		for (Habitacion habitacion : habitaciones) {
//			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
//				return habitacion.getPrecio();
//			}
//		}
//		return 0.0; // Precio por defecto si no se encuentra la habitación
//	}
//
//	public double preguntarDescuentoClienteHabitual() {
//		// Implementación simplificada: devuelve el primer descuento encontrado
//		if (!descuentos.isEmpty()) {
//			return descuentos.values().iterator().next();
//		} else {
//			return 0.0; // Sin descuento por defecto
//		}
//	}
//
//	public double preguntarPrecioTotal(String rut, String tipoHabitacion, int numeroNoches) {
//		
//		for (Reserva reserva : reservas) {
//			if (reserva.getCliente().getDni().equalsIgnoreCase(rut)
//					&& reserva.getHabitacion().getTipo().equalsIgnoreCase(tipoHabitacion)) {
//				double precioHabitacion = reserva.getHabitacion().getPrecio();
//				double descuentoCliente = 0.0; // Se asume que el cliente no tiene descuento por defecto
//
//				if (reserva.getCliente() instanceof ClienteHabitual) {
//					descuentoCliente = ((ClienteHabitual) reserva.getCliente()).getDescuento();
//				}
//
//				double precioTotal = precioHabitacion * numeroNoches * (1 - descuentoCliente);
//				return precioTotal;
//			}
//		}
//		return 0.0; // Cliente o habitación no encontrados
//	}
//
//	public void dibujarFotoHabitacion(String tipo) {
//		
//		for (Habitacion habitacion : habitaciones) {
//			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
//				System.out.println("Mostrando foto de la habitación " + tipo + ": " + habitacion.getFoto());
//				return;
//			}
//		}
//		System.out.println("No se encontró la habitación " + tipo);
//	}
//
//	public void reservarHabitacion(int numeroHabitacion, String dni, String nombreCliente, String direccion, String telefono) {
//		
//	    for (Habitacion habitacion : habitaciones) {
//	    	
//	        if (habitacion.getNumero() == numeroHabitacion) {
//	        	
//	            Cliente cliente = null;
//	            if (descuentos.containsKey(dni)) {
//	                // Cliente habitual
//	                double descuento = descuentos.get(dni);
//	                cliente = new ClienteHabitual(dni, nombreCliente, direccion, telefono, descuento);
//	            } else {
//	                // Cliente esporádico
//	                cliente = new ClienteEsporadico(dni, nombreCliente, direccion, telefono, true); // Se asume true para recibir ofertas
//	            }
//
//	            Date fechaEntrada = new Date(); // Obtener la fecha actual
//	            Reserva reserva = new Reserva(cliente, habitacion, fechaEntrada, 1); // Por simplicidad, asumimos una reserva de 1 día
//	            reservas.add(reserva);
//	            System.out.println("Reserva realizada con éxito:\n" + reserva);
//	            return;
//	        }
//	    }
//	    System.out.println("No se encontró la habitación con número " + numeroHabitacion);
//	}
//
//
//
//
//	public void eliminarReserva(int numeroHabitacion) {
//		Reserva reservaEliminar = null;
//		for (Reserva reserva : reservas) {
//			if (reserva.getHabitacion().getNumero() == numeroHabitacion) {
//				reservaEliminar = reserva;
//				break;
//			}
//		}
//
//		if (reservaEliminar != null) {
//			reservas.remove(reservaEliminar);
//			System.out.println("Reserva eliminada con éxito:\n" + reservaEliminar);
//		} else {
//			System.out.println("No se encontró reserva para la habitación con número " + numeroHabitacion);
//		}
//	}
//
//	// Métodos para el administrador
//	public void cambiarPrecioHabitacion(String tipo, double nuevoPrecio) {
//		for (Habitacion habitacion : habitaciones) {
//			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
//				habitacion.setPrecio(nuevoPrecio);
//				System.out.println("Precio de la habitación " + tipo + " cambiado a " + nuevoPrecio);
//				return;
//			}
//		}
//		System.out.println("No se encontró la habitación " + tipo);
//	}
//
//	public void cambiarDescuentoClienteHabitual(int dni, double nuevoDescuento) {
//		descuentos.put(dni, nuevoDescuento);
//		System.out.println("Descuento para cliente habitual con DNI " + dni + " cambiado a " + nuevoDescuento);
//	}
//
//	public double calcularGananciasMes(int mes) {
//		
//	    double ganancias = 0.0;
//	    for (Reserva reserva : reservas) {
//	    	
//	        LocalDate fechaEntrada = reserva.getFechaEntrada().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//	        int mesReserva = fechaEntrada.getMonthValue();
//	        if (mesReserva == mes) {
//	            Habitacion habitacion = reserva.getHabitacion();
//	            ganancias += habitacion.getPrecio() * reserva.getNumeroDias();
//	        }
//	    }
//	    return ganancias;
//	}
//	
//}

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

import java.util.*;
import java.time.*;

	public class ReservaHotel {
		
		//atributos	
	private List<Habitacion> habitaciones;
	private List<Reserva> reservas;
	private Map<String, Double> descuentos;

	//constructor
	public ReservaHotel() {
		habitaciones = new ArrayList<>();
		reservas = new ArrayList<>();
		descuentos = new HashMap<>();
	}
	
// ---------------------------------------------------------------------------------------------------------------------------------------	
	 public void agregarHabitacion(Habitacion habitacion) {
	        habitaciones.add(habitacion);
	    }
// ---------------------------------------------------------------------------------------------------------------------------------------
	// Métodos para el recepcionista
	public List<Habitacion> obtenerHabitacionesDisponibles(String tipo) {
		
		List<Habitacion> habitacionesDisponibles = new ArrayList<>();
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
				habitacionesDisponibles.add(habitacion);
			}
		}
		return habitacionesDisponibles;
	}

// ---------------------------------------------------------------------------------------------------------------------------------------
	
	public double preguntarPrecioHabitacion(String tipo) {
		
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
				return habitacion.getPrecio();
			}
		}
		return 0.0; // Precio por defecto si no se encuentra la habitación
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	
	public double preguntarDescuentoClienteHabitual() {
		
		if (!descuentos.isEmpty()) {
			return descuentos.values().iterator().next();
		} else {
			return 0.0; // Sin descuento por defecto
		}
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	
	public double preguntarPrecioTotal(String dni, String tipoHabitacion, int numeroNoches) {
		
	    for (Reserva reserva : reservas) {
	    	
	        Cliente cliente = reserva.getCliente();
	        
	        if (cliente != null && cliente.getDni() != null
	                && cliente.getDni().equalsIgnoreCase(dni)
	                && reserva.getHabitacion().getTipo().equalsIgnoreCase(tipoHabitacion)) {
	            double precioHabitacion = reserva.getHabitacion().getPrecio();
	            double descuentoCliente = 0.0;

	            if (cliente instanceof ClienteHabitual) {
	                descuentoCliente = ((ClienteHabitual) cliente).getDescuento();
	            }

	            double precioTotal = precioHabitacion * numeroNoches * (1 - descuentoCliente);
	            return precioTotal;
	        }
	    }
	    return 0.0; // Cliente o habitación no encontrados
	}
// ---------------------------------------------------------------------------------------------------------------------------------------

	public void dibujarFotoHabitacion(String tipo) {
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
				System.out.println("Mostrando foto de la habitación " + tipo + ": " + habitacion.getFoto());
				return;
			}
		}
		System.out.println("No se encontro la habitación " + tipo);
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	
	public void reservarHabitacion(int numeroHabitacion, String dni, String nombreCliente, String direccion, String telefono) {
	    for (Habitacion habitacion : habitaciones) {
	        if (habitacion.getNumero() == numeroHabitacion) {
	            Cliente cliente = obtenerCliente(dni, nombreCliente, direccion, telefono);
	            
	            // Obtener la fecha actual
	            LocalDate fechaEntrada = LocalDate.now();

	            Reserva reserva = new Reserva(cliente, habitacion, fechaEntrada, 1);
	            reservas.add(reserva);
	            System.out.println("Reserva realizada con exito:\n" + reserva);
	            return;
	        }
	    }
	    System.out.println("No se encontro la habitacion con numero " + numeroHabitacion);
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	
	public void eliminarReserva(int numeroHabitacion) {
		Reserva reservaEliminar = null;
		for (Reserva reserva : reservas) {
			if (reserva.getHabitacion().getNumero() == numeroHabitacion) {
				reservaEliminar = reserva;
				break;
			}
		}

		if (reservaEliminar != null) {
			reservas.remove(reservaEliminar);
			System.out.println("Reserva eliminada con exito:\n" + reservaEliminar);
		} else {
			System.out.println("No se encontro reserva para la habitacion con numero " + numeroHabitacion);
		}
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	
	// Métodos para el administrador
	public void cambiarPrecioHabitacion(String tipo, double nuevoPrecio) {
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
				habitacion.setPrecio(nuevoPrecio);
				System.out.println("Precio de la habitación " + tipo + " cambiado a " + nuevoPrecio);
				return;
			}
		}
		System.out.println("No se encontro la habitacion " + tipo);
	}

	public void cambiarDescuentoClienteHabitual(String dni, double nuevoDescuento) {
		descuentos.put(dni, nuevoDescuento);
		System.out.println("Descuento para cliente habitual con DNI " + dni + " cambiado a " + nuevoDescuento);
	}

	public double calcularGananciasMes(int mes) {
	    double ganancias = 0.0;
	    for (Reserva reserva : reservas) {
	        LocalDate fechaEntrada = reserva.getFechaEntrada();
	        int mesReserva = fechaEntrada.getMonthValue();
	        if (mesReserva == mes) {
	            Habitacion habitacion = reserva.getHabitacion();
	            ganancias += habitacion.getPrecio() * reserva.getNumeroDias();
	        }
	    }
	    return ganancias;
	}
	
//-------------------------------------------------------------------------------------------------------
//		*** -- METODOS ADICIONALES -- ***
//----------------------------------------------------------------------------------------------------------

	public Cliente obtenerCliente(String dni, String nombre, String direccion, String telefono) {
		
	    if (descuentos.containsKey(dni)) {
	        double descuento = descuentos.get(dni);
	        return new ClienteHabitual(dni, nombre, direccion, telefono, descuento);
	    } else {
	        return new ClienteEsporadico(dni, nombre, direccion, telefono, true);
	    }
	}
	
// ---------------------------------------------------------------------------------------------------------------------------------------	

	// 1. Consulta de Reservas por Cliente
	public List<Reserva> consultarReservasPorCliente(String dni) {
		
	    List<Reserva> reservasCliente = new ArrayList<>();
	    
	    for (Reserva reserva : reservas) {
	        Cliente cliente = reserva.getCliente();
	        if (cliente != null && cliente.getDni() != null && cliente.getDni().equalsIgnoreCase(dni)) {
	            reservasCliente.add(reserva);
	        }
	    }
	    return reservasCliente;
	}

// ---------------------------------------------------------------------------------------------------------------------------------------
	// 2. Consulta de Habitaciones Ocupadas en un Rango de Fechas
	public List<Habitacion> obtenerHabitacionesOcupadasEnFecha(LocalDate fechaInicio, LocalDate fechaFin) {
		List<Habitacion> habitacionesOcupadas = new ArrayList<>();
		for (Reserva reserva : reservas) {
			LocalDate fechaReserva = reserva.getFechaEntrada();
			if ((fechaReserva.isEqual(fechaInicio) || fechaReserva.isAfter(fechaInicio))
					&& (fechaReserva.isEqual(fechaFin) || fechaReserva.isBefore(fechaFin))) {
				habitacionesOcupadas.add(reserva.getHabitacion());
			}
		}
		return habitacionesOcupadas;
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	// 3. Método para Modificar Datos del Cliente
	public void modificarDatosCliente(String dni, String nuevoNombre, String nuevaDireccion, String nuevoTelefono) {
	    for (Reserva reserva : reservas) {
	        Cliente cliente = reserva.getCliente();
	        if (cliente != null && cliente.getDni() != null && cliente.getDni().equalsIgnoreCase(dni)) {
	            cliente.setNombre(nuevoNombre);
	            cliente.setDireccion(nuevaDireccion);
	            cliente.setTelefono(nuevoTelefono);
	            System.out.println("Datos del cliente modificados con exito:\n" + cliente);
	            return;
	        }
	    }
	    System.out.println("Cliente con DNI " + dni + " no encontrado o el DNI es nulo.");
	}

// ---------------------------------------------------------------------------------------------------------------------------------------
	// 4. Reporte de Ganancias por Tipo de Habitacion
	public Map<String, Double> generarReporteGananciasPorTipoHabitacion(int mes) {
		Map<String, Double> gananciasPorTipo = new HashMap<>();
		for (Reserva reserva : reservas) {
			LocalDate fechaEntrada = reserva.getFechaEntrada();
			if (fechaEntrada.getMonthValue() == mes) {
				String tipoHabitacion = reserva.getHabitacion().getTipo();
				double gananciaReserva = reserva.getHabitacion().getPrecio() * reserva.getNumeroDias();
				gananciasPorTipo.put(tipoHabitacion,
						gananciasPorTipo.getOrDefault(tipoHabitacion, 0.0) + gananciaReserva);
			}
		}
		return gananciasPorTipo;
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	public List<Reserva> obtenerTodasLasReservas() {
		return reservas;
	}

	// Método para obtener la lista de todas las habitaciones
	public List<Habitacion> obtenerTodasLasHabitaciones() {
		return habitaciones;
	}

	// Método para obtener el descuento de un cliente habitual por DNI
	public Double obtenerDescuentoClienteHabitual(String dni) {
		return descuentos.getOrDefault(dni, 0.0);
	}

	// Método para obtener la cantidad total de reservas
	public int obtenerCantidadTotalDeReservas() {
		return reservas.size();
	}

	// Método para obtener la cantidad total de habitaciones
	public int obtenerCantidadTotalDeHabitaciones() {
		return habitaciones.size();
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	// Método para obtener la cantidad total de habitaciones disponibles de un tipo
	public int obtenerCantidadHabitacionesDisponiblesPorTipo(String tipo) {
		int count = 0;
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
				count++;
			}
		}
		return count;
	}
// ---------------------------------------------------------------------------------------------------------------------------------------
	// Método para obtener un reporte de ocupación por mes
	public Map<Integer, Integer> obtenerReporteOcupacionPorMes() {
		Map<Integer, Integer> ocupacionPorMes = new HashMap<>();
		for (Reserva reserva : reservas) {
			LocalDate fechaEntrada = reserva.getFechaEntrada();
			int mesReserva = fechaEntrada.getMonthValue();
			ocupacionPorMes.put(mesReserva, ocupacionPorMes.getOrDefault(mesReserva, 0) + 1);
		}
		return ocupacionPorMes;
	}
// ---------------------------------------------------------------------------------------------------------------------------------------	
	
}
