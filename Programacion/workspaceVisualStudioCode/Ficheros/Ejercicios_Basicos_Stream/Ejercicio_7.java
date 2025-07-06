package Ejercicios_Basicos_Stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de caracteres a escribir:");
        int numCaracteres = scanner.nextInt();

        scanner.close();

        String rutaArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\tercerTrimestre\\ejercicios\\ficheros\\ejercicios_basicos";

        try {
            // Crear un objeto FileWriter para escribir en el archivo
            FileWriter fw = new FileWriter(rutaArchivo);
            // Crear un BufferedWriter para escribir de forma eficiente
            BufferedWriter bufferEscritura = new BufferedWriter(fw);

            // Objeto para generar caracteres aleatorios
            Random random = new Random();

            // Caracteres válidos: letras de la A a la Z (mayúsculas y minúsculas), la letra
            // ñ y espacios en blanco
            String caracteresValidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZÑabcdefghijklmnopqrstuvwxyz ";

            // Generar y escribir caracteres aleatorios en el archivo
            for (int i = 0; i < numCaracteres; i++) {
                // Obtener un caracter aleatorio
                char caracter = caracteresValidos.charAt(random.nextInt(caracteresValidos.length()));
                // Escribir el caracter en el archivo
                bufferEscritura.write(caracter);
            }

            bufferEscritura.close();

            System.out.println(
                    "Se ha creado el archivo 'caracteres.txt' correctamente en la carpeta 'ficheros' en la unidad C.");

        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

}
