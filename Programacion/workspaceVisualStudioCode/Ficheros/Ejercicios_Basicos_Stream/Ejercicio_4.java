package Ejercicios_Basicos_Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_4 {

    public static void main(String[] args) {
        String archivoCSVOriginal = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\tercerTrimestre\\ejercicios\\ficheros\\ejercicios_basicos\\Restaurants.csv"; // Ruta
        // original
        String archivoCSVCopia = "D:\\Users\\famil\\Desktop\\Restaurants2.csv";

        try {
            // Crear un bf para el archivo CSV original
            BufferedReader bf = new BufferedReader(new FileReader(archivoCSVOriginal));

            // Crear un fw para el archivo CSV de copia
            FileWriter fw = new FileWriter(archivoCSVCopia);

            // Leer la primera línea que contiene los encabezados y escribirla en el archivo
            // de copia
            String linea = bf.readLine();
            fw.write(linea + "\n");

            // Leer las líneas restantes del archivo original
            while ((linea = bf.readLine()) != null) {

                String[] campos = linea.split(","); // Dividir la línea en campos usando la coma como separador

                // Obtener el código postal del restaurante
                String codigoPostal = campos[4].trim(); // La columna del código postal es la quinta (índice 4)

                // Verificar si el código postal NO empieza por "6"
                if (!codigoPostal.startsWith("6")) {
                    // Si el código postal NO empieza por "6", escribir la línea en el archivo de
                    // copia
                    fw.write(linea + "\n");
                }
            }

            bf.close();
            fw.close();

            System.out.println("Se ha creado el archivo Restaurants2.csv con los datos filtrados correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
