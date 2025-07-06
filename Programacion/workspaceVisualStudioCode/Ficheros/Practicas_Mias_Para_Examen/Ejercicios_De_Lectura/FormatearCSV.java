package Ejercicios_De_Lectura;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FormatearCSV {
    public static void main(String[] args) {
        String nombreArchivo = "datos.csv";

        // Datos para escribir en el archivo 
        String[][] datos = {
                { "Alumnos", "Centro de estudio", "Grado de estudio" },
                { "Jonatan", "Orduña", "DAM" },
                { "Aitor", "Elorrieta", "DAM" },
                { "Janire", "Portugalete", "DAW" }
        };

        // Escribir datos en el archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (String[] fila : datos) {
                StringBuilder linea = new StringBuilder();
                for (String valor : fila) {
                    linea.append("\"").append(valor).append("\",");
                }
                linea.deleteCharAt(linea.length() - 1); // Eliminar la última coma
                writer.println(linea);
            }
            System.out.println("Datos escritos en el archivo " + nombreArchivo + " con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Leer y mostrar los datos del archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
