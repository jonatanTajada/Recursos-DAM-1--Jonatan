package ejercicio_diferencias_entre_ArrayList_LinkedList;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Random random = new Random();
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Introducir 5000 vehículos con tipos aleatorios
        for (int i = 0; i < 5000; i++) {

            int indiceAleatorio = random.nextInt(4);
            String tipo = "";
            switch (indiceAleatorio) {
                case 0:
                    tipo = "Coche";
                    break;
                case 1:
                    tipo = "Camion";
                    break;
                case 2:
                    tipo = "Furgoneta";
                    break;
                case 3:
                    tipo = "Moto";
                    break;
            }
            vehiculos.add(new Vehiculo(i, tipo));
        }

        // Resumen de la lista inicial
        int coches = 0, camiones = 0, furgonetas = 0, motos = 0;

        for (Vehiculo vehiculo : vehiculos) {
            switch (vehiculo.getTipo()) {
                case "Coche":
                    coches++;
                    break;
                case "Camion":
                    camiones++;
                    break;
                case "Furgoneta":
                    furgonetas++;
                    break;
                case "Moto":
                    motos++;
                    break;
            }
        }
        System.out.println("Resumen lista inicial: hay " + coches + " Coches, " + camiones + " Camiones, " +
                furgonetas + " Furgonetas y " + motos + " Motos");

        // // Eliminar vehículos que no sean de tipo Coche con expresion lambda
        // long inicioTiempo = System.nanoTime();
        // vehiculos.removeIf(v -> !v.getTipo().equals("Coche"));

        // Eliminar vehículos que no sean de tipo Coche
        long inicioTiempo = System.nanoTime();
        for (Iterator<Vehiculo> iterator = vehiculos.iterator(); iterator.hasNext();) {
            Vehiculo vehiculo = iterator.next();
            if (!vehiculo.getTipo().equals("Coche")) {
                iterator.remove();
            }
        }

        // Añadir vehículos de tipo Coche al final de la lista
        int size = vehiculos.size();
        for (int i = 0; i < size; i++) {
            vehiculos.add(new Vehiculo(i + size, "Coche"));
        }
        long finalTiempo = System.nanoTime();
        long tiempoTranscurrido
         = finalTiempo - inicioTiempo;

        // Resumen de la lista final
        coches = 0;
        camiones = 0;
        furgonetas = 0;
        motos = 0;
        for (Vehiculo vehiculo : vehiculos) {
            switch (vehiculo.getTipo()) {
                case "Coche":
                    coches++;
                    break;
                case "Camion":
                    camiones++;
                    break;
                case "Furgoneta":
                    furgonetas++;
                    break;
                case "Moto":
                    motos++;
                    break;
            }
        }
        System.out.println("Tiempo empleado en eliminacion-insercion (en nanosegundos): " + tiempoTranscurrido
        );
        System.out.println("Resumen lista final: hay " + coches + " Coches, " + camiones + " Camiones, " +
                furgonetas + " Furgonetas y " + motos + " Motos");
    }

}
