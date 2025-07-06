import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio_4 {
    public static void main(String[] args) {
        
        // Verificar que se ha pasado el nombre del fichero como argumento
        if (args.length < 1) {
            System.out.println("Uso: java OrdenarPalabras <nombre_fichero>");
            return;
        }

        String nombreFicheroEntrada = args[0]; // Nombre del fichero de entrada
        String nombreFicheroSalida = nombreFicheroEntrada.replace(".txt", "_sort.txt"); // Nombre del fichero de salida

        try {
            // Abrir el fichero de entrada
            BufferedReader lector = new BufferedReader(new FileReader(nombreFicheroEntrada));

            // Leer las palabras y almacenarlas en una lista
            ArrayList<String> palabras = new ArrayList<>();
            String linea;
            while ((linea = lector.readLine()) != null) {
                palabras.add(linea);
            }

            // Cerrar el lector
            lector.close();

            // Ordenar alfabéticamente la lista de palabras
            Collections.sort(palabras);

            // Abrir el fichero de salida
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreFicheroSalida));

            // Escribir las palabras ordenadas en el fichero de salida
            for (String palabra : palabras) {
                escritor.write(palabra);
                escritor.newLine();
            }

            // Cerrar el escritor
            escritor.close();

            System.out.println("Las palabras han sido ordenadas alfabéticamente y guardadas en " + nombreFicheroSalida);

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
