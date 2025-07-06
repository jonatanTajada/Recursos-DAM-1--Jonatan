package ejercicio2_SalaCine;

public class App {

    public static void main(String[] args) {
        
        // Crear una película
        Pelicula pelicula = new Pelicula("El Padrino", 175, 18, "Francis Ford Coppola");

        // Crear un cine
        Cine cine = new Cine(pelicula, 10.0, 8, 9);

        // Mostrar información del cine y la película
        System.out.println("Información del cine:");
        System.out.println(cine);
        System.out.println("\nInformación de la película:");
        System.out.println(pelicula);

        // Simular la llegada de espectadores
        for (int i = 0; i < 30; i++) {
            Espectador espectador = Espectador.generarEspectadorAleatorio();
            System.out.println("\nNuevo espectador: " + espectador);
        
            if (espectador.puedePermitirse(cine.getPreciosEntrada()) && espectador.getEdad() >= pelicula.getEdadMinima()) {
                if (cine.hayEspacioLibre()) {
                    Asiento asiento = cine.buscarAsientoLibre();
                    asiento.ocuparAsiento(espectador);
                    System.out.println("Asiento asignado: " + asiento.getFila() + asiento.getColumna() + ": Ocupado por " + espectador.getNombre());
                } else {
                    System.out.println("Lo siento, no hay asientos disponibles.");
                }
            } else {
                System.out.println("Lo siento, el espectador no cumple los requisitos para ver la película.");
            }
        }

        // Mostrar información del cine después de la simulación
        System.out.println("\nInformación del cine después de la simulación:");
        System.out.println(cine);
    }

}
