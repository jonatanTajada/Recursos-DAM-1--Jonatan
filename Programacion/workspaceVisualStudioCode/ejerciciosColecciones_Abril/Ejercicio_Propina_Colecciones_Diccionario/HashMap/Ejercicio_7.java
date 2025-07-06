package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio_7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Crear el diccionario español-ingles

        Map<String, String> diccionario = new HashMap<>();
        diccionario.put("casa", "house");
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("mesa", "table");
        diccionario.put("libro", "book");
        diccionario.put("coche", "car");
        diccionario.put("computadora", "computer");
        diccionario.put("ventana", "window");
        diccionario.put("manzana", "apple");
        diccionario.put("naranja", "orange");
        diccionario.put("plátano", "banana");
        diccionario.put("agua", "water");
        diccionario.put("leche", "milk");
        diccionario.put("sol", "sun");
        diccionario.put("luna", "moon");
        diccionario.put("flor", "flower");
        diccionario.put("árbol", "tree");
        diccionario.put("playa", "beach");
        diccionario.put("montaña", "mountain");
        diccionario.put("cielo", "sky");

        System.out.println("Bienvenido al mini-diccionario español-ingles");

        do {
            System.out.print("Introduce una palabra en español (o 'salir' para terminar): ");
            String palabraEspañol = scanner.nextLine().toLowerCase();

            if (palabraEspañol.equals("salir")) {
                System.out.println("¡Hasta luego!");
                break;
            }

            // Buscar la palabra en el diccionario
            if (diccionario.containsKey(palabraEspañol)) {
                String traduccion = diccionario.get(palabraEspañol);
                System.out.println("La traducción de ' " + palabraEspañol + " '  es: " + traduccion);
            } else {
                System.out.println("La palabra \"" + palabraEspañol + "\" no se encuentra en el diccionario.");
            }
        } while (true);

        scanner.close();
    }
}
