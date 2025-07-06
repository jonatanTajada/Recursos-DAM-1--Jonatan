package Ejercicios_De_Lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import javax.swing.JOptionPane;

/*
 * SumarNumerosArchivo
 */
@SuppressWarnings("unused")
public class SumarNumerosArchivo {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\numeros.txt";
        int suma = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                suma += Integer.parseInt(linea);
            }
            System.out.println("La suma de los numeros en el archivo '" + nombreArchivo + " es: " + suma);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo o formato de numero incorrecto: ");
            System.out.println(e.getMessage());
        }

    }

}
