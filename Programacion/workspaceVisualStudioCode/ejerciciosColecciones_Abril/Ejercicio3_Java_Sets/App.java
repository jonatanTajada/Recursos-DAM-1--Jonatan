package Ejercicio3_Java_Sets;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // Crear un conjunto para los jugadores del Athletic
        Set<String> jugadores = new HashSet<>();

        // añadir jugadores del Athletic en el conjunto
        jugadores.add("Unai Simon");
        jugadores.add("Kepa Aguirrezabala");
        jugadores.add("Ander Capa");
        jugadores.add("Yeray Alvarez");
        jugadores.add("Mikel Balenziaga");
        jugadores.add("Unai Nuñez");
        jugadores.add("Yuri Berchiche");
        jugadores.add("Dani Garcia");
        jugadores.add("Unai Lopez");
        jugadores.add("Mikel Vesga");
        jugadores.add("Raúl Garcia");
        jugadores.add("Iker Muniain");
        jugadores.add("Iñaki Williams");

        // Mostrar los nombres de los jugadores
        System.out.println("Jugadores del Athletic:");
        for (String nombre : jugadores) {
            System.out.println(nombre);
        }

        // Consultar si existe el jugador "Unai Simon"
        if (jugadores.contains("Unai Simon")) {
            System.out.println("El jugador 'Unai Simon' esta en el conjunto.");
        } else {
            System.out.println("El jugador 'Unai Simon' no esta en el conjunto.");
        }

        // Crear un segundo conjunto con jugadores2
        Set<String> jugadores2 = new HashSet<>();
        jugadores2.add("Guruzeta");
        jugadores2.add("Nico Williams");

        // Consultar si todos los elementos de jugadores2 existen en jugadores
        if (jugadores.containsAll(jugadores2)) {
            System.out.println("Todos los jugadores de jugadores2 existen en jugadores.");
        } else {
            System.out.println("No todos los jugadores de jugadores2 existen en jugadores.");
        }

        // Unir los conjuntos jugadores y jugadores2
        Set<String> union = new HashSet<>(jugadores);
        union.addAll(jugadores2);

        // Eliminar todos los jugadores del conjunto jugadores2
        jugadores2.clear();
        System.out.println("Numero de jugadores en jugadores2 despues de borrar: " + jugadores2.size());
    }
}
