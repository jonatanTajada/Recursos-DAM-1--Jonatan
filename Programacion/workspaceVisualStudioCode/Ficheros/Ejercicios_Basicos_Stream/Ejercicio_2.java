package Ejercicios_Basicos_Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio_2 {

    public static void main(String[] args) {

        String archivoCSV = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\tercerTrimestre\\ejercicios\\ficheros\\ejercicios_basicos\\Restaurants.csv";

        try {
            // Crear un bf para el archivo CSV
            BufferedReader bf = new BufferedReader(new FileReader(archivoCSV));

            // Leer la primera línea que contiene los encabezados
            String linea = bf.readLine();

            // Leer las líneas restantes
            while ((linea = bf.readLine()) != null) {
                // Dividir la línea en campos usando la coma como separador
                String[] campos = linea.split(",");

                // Obtener el código postal del restaurante (suponiendo que está en la última
                // columna)
                String codigoPostal = campos[4].trim(); // La columna del código postal es la quinta (índice 4)

                // Verificar si el código postal empieza por "6"
                if (codigoPostal.startsWith("6")) {
                    // Si el código postal empieza por "6", mostrar los datos del restaurante
                    System.out.println("Nombre: " + campos[0]); // Nombre del restaurante
                    System.out.println("Dirección: " + campos[1]); // Dirección del restaurante
                    System.out.println("Ciudad: " + campos[2]); // Ciudad del restaurante
                    System.out.println("Estado: " + campos[3]); // Estado del restaurante
                    System.out.println("Código Postal: " + codigoPostal);
                    System.out.println("---------------------------");
                }
            }

            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
