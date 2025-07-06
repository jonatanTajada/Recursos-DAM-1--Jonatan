package ejercicioHotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AppGestionHotel {
    public static void main(String[] args) {
    	
        // Crear objeto ReservaHotel
        ReservaHotel hotel = new ReservaHotel();

        // Agregar habitaciones al hotel
        hotel.agregarHabitacion(new Habitacion(101, 100.0, "Doble", "doble.jpg"));
        hotel.agregarHabitacion(new Habitacion(102, 80.0, "Individual", "individual.jpg"));


        // Simular reservas
        hotel.reservarHabitacion(101, "12345678", "Juan Perez", "Calle A", "123456789");
        hotel.reservarHabitacion(102, "98765432", "Ana Rodriguez", "Calle B", "987654321");

        // Consultar habitaciones disponibles
        List<Habitacion> disponibles = hotel.obtenerHabitacionesDisponibles("Doble");
        System.out.println("Habitaciones dobles disponibles: " + disponibles);

        // Consultar precio de habitación
        double precioHabitacion = hotel.preguntarPrecioHabitacion("Individual");
        System.out.println("Precio de habitación individual: " + precioHabitacion);

        // Consultar descuento cliente habitual
        double descuentoHabitual = hotel.preguntarDescuentoClienteHabitual();
        System.out.println("Descuento para cliente habitual: " + descuentoHabitual);

        // Consultar precio total de reserva
        double precioTotal = hotel.preguntarPrecioTotal("12345678", "Doble", 2);
        System.out.println("Precio total de la reserva: " + precioTotal);

        // Dibujar foto de habitacion
        hotel.dibujarFotoHabitacion("Doble");

        // Eliminar reserva
        hotel.eliminarReserva(101);

        // Cambiar precio de habitacion
        hotel.cambiarPrecioHabitacion("Individual", 90.0);

        // Cambiar descuento cliente habitual
        hotel.cambiarDescuentoClienteHabitual("98765432", 0.1);

        // Calcular ganancias del mes
        double gananciasMes = hotel.calcularGananciasMes(LocalDate.now().getMonthValue());
        System.out.println("Ganancias del mes: " + gananciasMes);

        // Metodos adicionales
        List<Reserva> reservasCliente = hotel.consultarReservasPorCliente("98765432");
        System.out.println("Reservas del cliente: " + reservasCliente);

        LocalDate fechaInicio = LocalDate.now().minusDays(5);
        LocalDate fechaFin = LocalDate.now();
        List<Habitacion> habitacionesOcupadas = hotel.obtenerHabitacionesOcupadasEnFecha(fechaInicio, fechaFin);
        System.out.println("Habitaciones ocupadas en el rango de fechas: " + habitacionesOcupadas);

        hotel.modificarDatosCliente("98765432", "Ana Maria Rodriguez", "Calle C", "555555555");

        Map<String, Double> reporteGananciasPorTipo = hotel.generarReporteGananciasPorTipoHabitacion(LocalDate.now().getMonthValue());
        System.out.println("Reporte de ganancias por tipo de habitación: " + reporteGananciasPorTipo);
    }
}
