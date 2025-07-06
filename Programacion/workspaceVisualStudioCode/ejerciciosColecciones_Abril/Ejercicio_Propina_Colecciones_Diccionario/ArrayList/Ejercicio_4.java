import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio_4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> listaPalabras = new ArrayList<>();

        int contador = 5;

        System.out.println("Ingresa " + contador + " palabras:");

        for (int i = 0; i < contador; i++) {
            System.out.print("Palabra " + (i + 1) + ": ");
            String palabra = scanner.nextLine();
            listaPalabras.add(palabra);
        }

        // ordenar las palabras
        Collections.sort(listaPalabras);

        // mostrar las palabras ordenadas
        System.out.println("\nPalabras ordenadas: ");
        for (String palabra : listaPalabras) {
            System.out.println(palabra);
        }

        scanner.close();

    }

}
