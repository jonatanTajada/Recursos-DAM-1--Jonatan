package ejercicio4_ArrayList_LinkedList_E_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        // Definir las dos tablas de colores
        String colores[] = { "negro", "amarillo", "verde", "azul", "violeta", "plateado" };
        String colores2[] = { "dorado", "blanco", "café", "azul", "gris", "plateado" };

        // Crear el primer objeto ArrayList y añadir los colores
        ArrayList<String> listaColores = new ArrayList<>();
        for (String color : colores) {
            listaColores.add(color);
        }
        System.out.println();
        // Crear el segundo objeto ArrayList y añadir los colores
        ArrayList<String> listaColores2 = new ArrayList<>();
        for (String color : colores2) {
            listaColores2.add(color);
        }
        System.out.println();
        // Mostrar el contenido inicial de ambos ArrayList
        System.out.println("Contenido inicial de listaColores:");
        System.out.println(listaColores);
        System.out.println("Contenido inicial de listaColores2:");
        System.out.println(listaColores2);

        // Utilizar un Iterator para eliminar los elementos de listaColores2 en
        // listaColores
        Iterator<String> iterator = listaColores2.iterator();
        while (iterator.hasNext()) {
            String color = iterator.next();
            if (listaColores.contains(color)) {
                iterator.remove();
            }
        }

        // Mostrar el contenido de listaColores2 después de la eliminación
        System.out.println("Contenido de listaColores2 despues de eliminar los elementos que coinciden:");
        System.out.println(listaColores2);
    }
}
