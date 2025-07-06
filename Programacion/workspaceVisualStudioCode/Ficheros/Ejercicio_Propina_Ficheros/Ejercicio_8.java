import java.io.*;
import java.util.*;

//OrdenarLibrosPorNombre
public class Ejercicio_8 {

    public static void main(String[] args) {

        // Ruta del archivo de entrada
        String archivoEntrada = "books.csv";
        // Ruta del archivo de salida ordenado
        String archivoSalida = "libros_ordenados.csv";

        try {
            // Crear un br para el archivo de entrada
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
            // Crear un escritor para el archivo de salida
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

            // Leer la cabecera y almacenarla
            String cabecera = br.readLine();

            // Crear una lista para almacenar los datos
            List<String> lineas = new ArrayList<>();

            // Leer el archivo línea por línea y almacenarlas en la lista
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            br.close();

            // Ordenar la lista por nombre de autor
            Collections.sort(lineas, new Comparator<String>() {
                @Override
                public int compare(String linea1, String linea2) {
                    String autor1 = linea1.split(";")[2];
                    String autor2 = linea2.split(";")[2];
                    return autor1.compareTo(autor2);
                }
            });

            // Escribir la cabecera en el archivo de salida
            escritor.write(cabecera);
            escritor.newLine();

            // Escribir las líneas ordenadas en el archivo de salida
            for (String lineaOrdenada : lineas) {
                escritor.write(lineaOrdenada);
                escritor.newLine();
            }

            escritor.close();

            System.out.println("Libros ordenados y guardados en " + archivoSalida);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
