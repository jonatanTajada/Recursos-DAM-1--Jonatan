package ejercicioParking;

import java.util.Scanner;

public class App_Parking_2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Parking parkingCentro = new Parking("Parking Centro", 10);
        menu(parkingCentro);
        scanner.close(); // Cerrar el Scanner al final del programa
    }

    private static void menu(Parking parking) {
        int opcion = 0;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Entrada de coche");
            System.out.println("2. Salida de coche");
            System.out.println("3. Mostrar parking");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción (1-4): ");

            opcion = obtenerEntero();

            try {
                switch (opcion) {
                    case 1:
                        entradaCoche(parking);
                        break;
                    case 2:
                        salidaCoche(parking);
                        break;
                    case 3:
                        mostrarParking(parking);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa. Hasta luego!");
                        break;
                    default:
                        System.err.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Ingrese un número válido!");
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (opcion != 4);
    }

    private static int obtenerEntero() {
        while (!scanner.hasNextInt()) {
            System.err.println("Error: Ingrese un número válido.");
            System.out.print("Seleccione una opción (1-4): ");
            scanner.next(); // Consumir la entrada no válida
        }
        return scanner.nextInt();
    }

    private static void entradaCoche(Parking parking) {
        try {
            System.out.print("Introduzca la matrícula del coche: ");
            String matricula = scanner.nextLine();

            System.out.print("Introduzca la plaza donde se colocará el coche: ");
            int plaza = Integer.parseInt(scanner.nextLine());

            parking.entrada(matricula, plaza);
            System.out.println("Coche ingresado correctamente.");
            mostrarEstadoParking(parking);
        } catch (Exception e) {
            System.out.println("Error al ingresar el coche: " + e.getMessage());
        }
    }

    private static void salidaCoche(Parking parking) {
        try {
            System.out.print("Introduzca la matrícula del coche que sale: ");
            String matricula = scanner.nextLine();

            int plazaLiberada = parking.salida(matricula);
            
            System.out.println("Coche con matrícula " + matricula + " salió del parking. Plaza liberada: " + plazaLiberada);
            mostrarEstadoParking(parking);
        } catch (Exception e) {
            System.out.println("Error al sacar el coche: " + e.getMessage());
        }
    }

    private static void mostrarParking(Parking parking) {
        System.out.println(parking);
    }

    private static void mostrarEstadoParking(Parking parking) {
        System.out.println("Plazas totales: " + parking.getPlazasTotales());
        System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
        System.out.println("Plazas libres: " + parking.getPlazasLibres());
    }
}
