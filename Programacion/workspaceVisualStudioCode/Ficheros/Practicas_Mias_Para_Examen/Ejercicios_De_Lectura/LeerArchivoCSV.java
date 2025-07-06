package Ejercicios_De_Lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Leer un archivo CSV:
 */
public class LeerArchivoCSV {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\datos2.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                for (String dato : datos) {
                    System.out.println(dato + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }

}
