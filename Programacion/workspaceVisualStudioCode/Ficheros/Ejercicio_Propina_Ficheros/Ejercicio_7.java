import java.io.*;
import java.util.*;

//OrdenarCSVPorNombre
public class Ejercicio_7 {
    public static void main(String[] args) {

        // Ruta del archivo de entrada
        String archivoEntrada = "datos.csv";
        // Ruta del archivo de salida ordenado
        String archivoSalida = "datos_ordenados.csv";

        try {
            // Crear un br para el archivo de entrada
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
            // Crear un escritor para el archivo de salida
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida));

            // Crear una lista para almacenar los datos
            List<String> lineas = new ArrayList<>();

            // Leer el archivo línea por línea y almacenarlas en la lista
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            // Cerrar el br
            br.close();

            // Ordenar la lista por nombre
            Collections.sort(lineas, new Comparator<String>() {
                @Override
                public int compare(String linea1, String linea2) {
                    String nombre1 = linea1.split(";")[1];
                    String nombre2 = linea2.split(";")[1];
                    return nombre1.compareTo(nombre2);
                }
            });

            // Escribir las líneas ordenadas en el archivo de salida
            for (String lineaOrdenada : lineas) {
                escritor.write(lineaOrdenada);
                escritor.newLine();
            }

            // Cerrar el escritor
            escritor.close();

            System.out.println("Datos ordenados y guardados en " + archivoSalida);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
