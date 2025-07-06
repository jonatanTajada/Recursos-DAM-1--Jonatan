package ejercicioHotel;
import java.time.LocalDate;
import java.util.*;

public class App_GestionHotel_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservaHotel reservaHotel = new ReservaHotel();

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarHabitacion(reservaHotel, scanner);
                    break;
                case 2:
                    consultarHabitacionesDisponibles(reservaHotel, scanner);
                    break;
                case 3:
                    preguntarPrecioHabitacion(reservaHotel, scanner);
                    break;
                case 4:
                    preguntarDescuentoClienteHabitual(reservaHotel);
                    break;
                case 5:
                    preguntarPrecioTotal(reservaHotel, scanner);
                    break;
                case 6:
                    dibujarFotoHabitacion(reservaHotel, scanner);
                    break;
                case 7:
                    reservarHabitacion(reservaHotel, scanner);
                    break;
                case 8:
                    eliminarReserva(reservaHotel, scanner);
                    break;
                case 9:
                    cambiarPrecioHabitacion(reservaHotel, scanner);
                    break;
                case 10:
                    cambiarDescuentoClienteHabitual(reservaHotel, scanner);
                    break;
                case 11:
                    calcularGananciasMes(reservaHotel, scanner);
                    break;
                case 12:
                    consultarReservasPorCliente(reservaHotel, scanner);
                    break;
                case 13:
                    consultarHabitacionesOcupadasEnFecha(reservaHotel, scanner);
                    break;
                case 14:
                    modificarDatosCliente(reservaHotel, scanner);
                    break;
                case 15:
                    generarReporteGananciasPorTipoHabitacion(reservaHotel, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú ===");
        System.out.println("1. Agregar Habitación");
        System.out.println("2. Consultar Habitaciones Disponibles");
        System.out.println("3. Preguntar Precio Habitación");
        System.out.println("4. Preguntar Descuento Cliente Habitual");
        System.out.println("5. Preguntar Precio Total");
        System.out.println("6. Dibujar Foto Habitación");
        System.out.println("7. Reservar Habitación");
        System.out.println("8. Eliminar Reserva");
        System.out.println("9. Cambiar Precio Habitación");
        System.out.println("10. Cambiar Descuento Cliente Habitual");
        System.out.println("11. Calcular Ganancias Mes");
        System.out.println("12. Consultar Reservas por Cliente");
        System.out.println("13. Consultar Habitaciones Ocupadas en un Rango de Fechas");
        System.out.println("14. Modificar Datos del Cliente");
        System.out.println("15. Generar Reporte Ganancias por Tipo Habitación");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarHabitacion(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para agregar una habitación
        System.out.print("Ingrese el tipo de habitación: ");
        String tipo = scanner.next();
        System.out.print("Ingrese el número de habitación: ");
        int numero = scanner.nextInt();
        System.out.print("Ingrese el precio de la habitación: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la foto de la habitación: ");
        String foto = scanner.next();

        Habitacion habitacion = new Habitacion(numero, precio, tipo,  foto);
        reservaHotel.agregarHabitacion(habitacion);

        System.out.println("Habitación agregada con éxito.");
    }

    private static void consultarHabitacionesDisponibles(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para consultar habitaciones disponibles
        System.out.print("Ingrese el tipo de habitación a consultar: ");
        String tipo = scanner.next();

        List<Habitacion> habitacionesDisponibles = reservaHotel.obtenerHabitacionesDisponibles(tipo);

        if (habitacionesDisponibles.isEmpty()) {
            System.out.println("No hay habitaciones disponibles de tipo " + tipo);
        } else {
            System.out.println("Habitaciones disponibles de tipo " + tipo + ":");
            for (Habitacion habitacion : habitacionesDisponibles) {
                System.out.println(habitacion);
            }
        }
    }

    private static void preguntarPrecioHabitacion(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para preguntar precio de una habitación
        System.out.print("Ingrese el tipo de habitación a consultar: ");
        String tipo = scanner.next();

        double precio = reservaHotel.preguntarPrecioHabitacion(tipo);

        if (precio != 0.0) {
            System.out.println("El precio de la habitación " + tipo + " es: " + precio + "€");
        } else {
            System.out.println("No se encontró la habitación " + tipo);
        }
    }

    private static void preguntarDescuentoClienteHabitual(ReservaHotel reservaHotel) {
        // Implementar la lógica para preguntar descuento para cliente habitual
        double descuento = reservaHotel.preguntarDescuentoClienteHabitual();

        if (descuento != 0.0) {
            System.out.println("El descuento para clientes habituales es: " + descuento * 100 + "%");
        } else {
            System.out.println("No hay descuento para clientes habituales");
        }
    }

    private static void preguntarPrecioTotal(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para preguntar precio total
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scanner.next();
        System.out.print("Ingrese el tipo de habitación: ");
        String tipoHabitacion = scanner.next();
        System.out.print("Ingrese el número de noches: ");
        int numeroNoches = scanner.nextInt();

        double precioTotal = reservaHotel.preguntarPrecioTotal(dni, tipoHabitacion, numeroNoches);

        if (precioTotal != 0.0) {
            System.out.println("El precio total para la reserva es: " + precioTotal + "€");
        } else {
            System.out.println("Cliente o habitación no encontrados");
        }
    }

    private static void dibujarFotoHabitacion(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para dibujar foto de una habitación
        System.out.print("Ingrese el tipo de habitación a mostrar: ");
        String tipo = scanner.next();

        reservaHotel.dibujarFotoHabitacion(tipo);
    }

    private static void reservarHabitacion(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para reservar una habitación
        System.out.print("Ingrese el número de habitación a reservar: ");
        int numeroHabitacion = scanner.nextInt();
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scanner.next();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.next();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.next();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.next();

        reservaHotel.reservarHabitacion(numeroHabitacion, dni, nombreCliente, direccion, telefono);
    }

    private static void eliminarReserva(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para eliminar una reserva
        System.out.print("Ingrese el número de habitación de la reserva a eliminar: ");
        int numeroHabitacion = scanner.nextInt();

        reservaHotel.eliminarReserva(numeroHabitacion);
    }

    private static void cambiarPrecioHabitacion(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para cambiar el precio de una habitación
        System.out.print("Ingrese el tipo de habitación a modificar: ");
        String tipo = scanner.next();
        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();

        reservaHotel.cambiarPrecioHabitacion(tipo, nuevoPrecio);
    }

    private static void cambiarDescuentoClienteHabitual(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para cambiar el descuento de un cliente habitual
        System.out.print("Ingrese el DNI del cliente habitual a modificar: ");
        String dni = scanner.next();
        System.out.print("Ingrese el nuevo descuento: ");
        double nuevoDescuento = scanner.nextDouble();

        reservaHotel.cambiarDescuentoClienteHabitual(dni, nuevoDescuento);
    }

    private static void calcularGananciasMes(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para calcular las ganancias de un mes
        System.out.print("Ingrese el número del mes a consultar: ");
        int mes = scanner.nextInt();

        double ganancias = reservaHotel.calcularGananciasMes(mes);

        System.out.println("Las ganancias para el mes " + mes + " son: " + ganancias + "€");
    }

    private static void consultarReservasPorCliente(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para consultar las reservas de un cliente
        System.out.print("Ingrese el DNI del cliente a consultar: ");
        String dni = scanner.next();

        List<Reserva> reservasCliente = reservaHotel.consultarReservasPorCliente(dni);

        if (reservasCliente.isEmpty()) {
            System.out.println("No hay reservas para el cliente con DNI " + dni);
        } else {
            System.out.println("Reservas del cliente con DNI " + dni + ":");
            for (Reserva reserva : reservasCliente) {
                System.out.println(reserva);
            }
        }
    }

    private static void consultarHabitacionesOcupadasEnFecha(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para consultar las habitaciones ocupadas en un rango de fechas
        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicioStr = scanner.next();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);

        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFinStr = scanner.next();
        LocalDate fechaFin = LocalDate.parse(fechaFinStr);

        List<Habitacion> habitacionesOcupadas = reservaHotel.obtenerHabitacionesOcupadasEnFecha(fechaInicio, fechaFin);

        if (habitacionesOcupadas.isEmpty()) {
            System.out.println("No hay habitaciones ocupadas en el rango de fechas especificado");
        } else {
            System.out.println("Habitaciones ocupadas en el rango de fechas especificado:");
            for (Habitacion habitacion : habitacionesOcupadas) {
                System.out.println(habitacion);
            }
        }
    }

    private static void modificarDatosCliente(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para modificar los datos de un cliente
        System.out.print("Ingrese el DNI del cliente a modificar: ");
        String dni = scanner.next();
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.next();
        System.out.print("Ingrese la nueva dirección: ");
        String nuevaDireccion = scanner.next();
        System.out.print("Ingrese el nuevo teléfono: ");
        String nuevoTelefono = scanner.next();

        reservaHotel.modificarDatosCliente(dni, nuevoNombre, nuevaDireccion, nuevoTelefono);

        System.out.println("Datos del cliente modificados con éxito.");
    }

    private static void generarReporteGananciasPorTipoHabitacion(ReservaHotel reservaHotel, Scanner scanner) {
        // Implementar la lógica para generar un reporte de ganancias por tipo de habitación en un mes
        System.out.print("Ingrese el número del mes a consultar: ");
        int mes = scanner.nextInt();

        Map<String, Double> gananciasPorTipo = reservaHotel.generarReporteGananciasPorTipoHabitacion(mes);

        if (gananciasPorTipo.isEmpty()) {
            System.out.println("No hay ganancias para el mes " + mes);
        } else {
            System.out.println("Reporte de ganancias por tipo de habitación para el mes " + mes + ":");
            for (Map.Entry<String, Double> entry : gananciasPorTipo.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + "€");
            }
        }
    }
}
