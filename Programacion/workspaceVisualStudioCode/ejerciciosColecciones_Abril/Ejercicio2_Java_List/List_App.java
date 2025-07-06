package Ejercicio2_Java_List;

import java.util.*;


public class List_App {

    public static void main(String[] args) {

        // Crear la lista de los días de la semana
        List<String> listaDias = new ArrayList<>();

        listaDias.add("Lunes");
        listaDias.add("Martes");
        listaDias.add("Miercoles");
        listaDias.add("Jueves");
        listaDias.add("Viernes");
        listaDias.add("Sabado");
        listaDias.add("Domingo");

        // Insertar "Juernes" en la posición 4

        listaDias.add(3, "Juernes");

        // Copiar la lista a otra llamada listaDos

                 // List<String> listaDos = new ArrayList<>(listaDias);


        // Añadir el contenido de listaDos a listaDias

                    /* listaDias.addAll(listaDos); */

        // Mostrar el contenido de las posiciones 3 y 4 de la lista original
        System.out.println("Contenido de la posicion 3: " + listaDias.get(2));
        System.out.println("Contenido de la posicion 4: " + listaDias.get(3));

        // Mostrar el primer y último elemento de la lista original
        System.out.println("Primer elemento de la lista 'ListaDias': " + listaDias.get(0));
        System.out.println("Ultimo elemento de la lista 'ListaDias': " + listaDias.get(listaDias.size() - 1));

        // Eliminar el elemento "Juernes" de la lista y comprobar si se elimina

        if (listaDias.contains("Juernes")) {
            listaDias.remove("Juernes");
            System.out.println("Elemento eliminado correctamente!");
        } else {
            System.out.println("El elemento 'Juernes' no existe en la lista");
        }

        /*
         * if (listaDias.remove("Juernes")) {
         * System.out.println("El elemento 'Juernes' ha sido borrado.");
         * } else {
         * System.out.println("El elemento 'Juernes' no existe en la lista.");
         * }
         */

        // Crear un iterador y mostrar uno a uno los valores de la lista original
        System.out.println("Elementos de la lista original:");
        Iterator<String> iterator = listaDias.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Buscar si existe en la lista un elemento que se denomine "Lunes"

        System.out.println("Buscar si existe en la lista un elemento que se denomine Lunes");
        if (listaDias.isEmpty()) {
            System.out.println("La lista está vacía!");
        } else {

            if (listaDias.contains("Lunes") || listaDias.contains("lunes") || listaDias.contains("LUNES")) {

                int posicion = listaDias.indexOf("Lunes");
                System.out.println("El elemento a buscar si se encutra en la lista, en la posicion: " + posicion);
            } else {
                System.out.println("El elemento 'Lunes' no está en la lista.");
            }
        }

        // System.out.println("¿Existe 'Lunes' en la lista? " +
        // listaDias.contains("Lunes"));

        // Buscar si existe en la lista un elemento que se denomine "Lunes" (ignorando
        // mayúsculas y minúsculas)

        String dia = "Lunes";
        System.out.println("Buscar si existe en la lista un elemento que se denomine Lunes");
        if (listaDias.isEmpty()) {
            System.out.println("La lista está vacia!");
        } else {
            boolean encontrado = false;
            for (String elemento : listaDias) {
                if (elemento.equalsIgnoreCase(dia)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println("En la lista se encuentra el elemento 'Lunes'.");
            } else {
                System.out.println("El elemento 'Lunes' no esta en la lista.");
            }
        }

        // Ordenar la lista y mostrar su contenido
        System.out.println("\nOrdenando la lista de dias...");
        listaDias.sort(null); // Ordenar la lista de forma predeterminada (orden natural)
        System.out.println("Contenido de la lista despues de ordenar:");
        for (String diaa : listaDias) {
            System.out.println(diaa);
        }

        // Borrar todos los elementos de la lista
        listaDias.clear();
        System.out.println("Todos los elementos han sido eliminados de la lista.");

    }

}
