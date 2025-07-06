package Ejercicios_De_Escritura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Escribir datos separados por comas en un archivo CSV: Crea un programa y archivo que escriba datos en un archivo CSV.
 */
public class EscribirDatosCSV {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\datosEscritura.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("Nombre, Edad, Ciudad");
            bw.newLine();
            bw.write("Jonatan, 36, Sodupe");
            bw.newLine();
            bw.write("Aitor, 22, Bilbao");
            bw.newLine();
            System.out.println("Se ha escrito correctamente en el archivo csv");
        } catch (IOException e) {
            System.err.println("No se pudo escribir en el archivo: ");
            System.err.println(e.getMessage());
        }

    }
}
