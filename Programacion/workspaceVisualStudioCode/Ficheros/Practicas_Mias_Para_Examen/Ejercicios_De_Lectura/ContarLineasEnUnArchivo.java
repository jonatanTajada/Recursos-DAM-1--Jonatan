package Ejercicios_De_Lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Contar líneas en un archivo: Crea un programa que lea un archivo de texto y cuente el número de líneas que contiene.
 */

public class ContarLineasEnUnArchivo {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\texto.txt";
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while (br.readLine() != null) {
                contador++;
            }
            System.out.println("\nEl archivo '" + nombreArchivo + "' tiene " + contador + " lineas");
        } catch (IOException e) {
            System.err.println("Error: NO se puede leer el archivo: " + e.getMessage());
        }

    }

}
