package Ejercicios_De_Escritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Escribir números en un archivo: Crea un programa que cree y  escriba una serie de números en un archivo.
 */
public class EscribirNumerosEnArchivo {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\numerosEscritura.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i <= 10; i++) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
            System.out.println("Se ha escrito todos los numeros con exito!");
        } catch (IOException e) {
            System.err.println("Error no se pudo escribir en el archivo: ");
            System.err.println(e.getMessage());
        }

        // leer los numeros y sumarlos
        String linea;
        int suma = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((linea = br.readLine()) != null) {
                suma += Integer.parseInt(linea);
            }
            System.out.println("La suma total es: " + suma);
        } catch (Exception e) {
            System.out.println("no se pudo escribir el total de la suma de los numeros");
        }

    }

}
