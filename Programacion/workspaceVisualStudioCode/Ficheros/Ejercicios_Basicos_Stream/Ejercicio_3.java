package Ejercicios_Basicos_Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio_3 {

    public static void main(String[] args) {
        String archivoCSV = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\tercerTrimestre\\ejercicios\\ficheros\\ejercicios_basicos\\Restaurants.csv";

        // Solicitar datos de nuevo restaurante al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del restaurante:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la dirección del restaurante:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese la ciudad del restaurante:");
        String ciudad = scanner.nextLine();
        System.out.println("Ingrese el estado del restaurante:");
        String estado = scanner.nextLine();
        System.out.println("Ingrese el código postal del restaurante:");
        String codigoPostal = scanner.nextLine();
        scanner.close();

        String nuevaLinea = nombre + "," + direccion + "," + ciudad + "," + estado + "," + codigoPostal;

        try {
            // escribir en archivo al final del archivo sin machacar nada
            FileWriter fw = new FileWriter(archivoCSV, true);
            fw.write("\n" + nuevaLinea);
            fw.close();

            System.out.println("Los datos se han añadido correctamente al archivo.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // -------------------------------------------------------------------

        // leer csv despues de añadir restarurante nuevo

        try {
            // Abrir el archivo
            FileWriter fw = new FileWriter(archivoCSV, true);

            // Escribir la nueva línea en el archivo
            fw.write("\n" + nuevaLinea);
            fw.close();

            System.out.println("Los datos se han añadido correctamente al archivo.");

            // Leer el archivo CSV y mostrar su contenido
            System.out.println("\nContenido del archivo CSV después de la adición:");
            mostrarContenidoCSV(archivoCSV);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Método para mostrar el contenido de un archivo CSV
    private static void mostrarContenidoCSV(String archivoCSV) {
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}