package Ejercicios_De_Escritura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Escribir varias líneas en un archivo: Crea un programa que escriba varias líneas de texto en un archivo, que ya exista.
 */
public class EscribirLineasEnArchivo {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\textoEscritura.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write("estoy escribiendo al final del texto y varias lineas, esta es la linea:1");
            bw.newLine();
            bw.write("Esta es la linea:2");
            bw.newLine();
            bw.write("Esta es la linea:3.");
            bw.newLine();
            System.out.println("Se ha escrito con exito en el archivo!");
        } catch (IOException e) {
            System.err.println("No se pudo escribir en el archivo: ");
            System.err.println(e.getMessage());
        }

    }
}
