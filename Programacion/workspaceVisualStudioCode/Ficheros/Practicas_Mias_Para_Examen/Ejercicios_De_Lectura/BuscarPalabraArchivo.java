package Ejercicios_De_Lectura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Buscar una palabra en un archivo (txt) y contar cuantas veces aparece
 */
public class BuscarPalabraArchivo {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\texto.txt";
        int contador = 0;
        String palabraBuscar = "Jonatan";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    if (palabra.equalsIgnoreCase(palabraBuscar)) {
                        contador++;
                    }
                }
                System.out.println(linea); // mostrar el archivo
            }
            System.out.println("La palabra a buscar '" + palabraBuscar + "' aparece " + contador + " veces.");

        } catch (IOException e) {
            System.err.println("No se ha podido acceder al archivo: ");
            System.out.println(e.getMessage());
        }

    }

}
