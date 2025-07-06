package Ejercicios_Basicos_Stream;

import java.io.File;
import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo que deseas borrar:");
        String rutaArchivo = scanner.nextLine();
        scanner.close();

        File archivo = new File(rutaArchivo);

        if (archivo.exists()) {

            if (archivo.delete()) {
                System.out.println("El archivo se ha borrado exitosamente.");
            } else {
                System.out.println("No se pudo borrar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe en la ruta especificada.");
        }
    }
}
