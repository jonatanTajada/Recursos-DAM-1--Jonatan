import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio_6 {

    public static void main(String[] args) {

        String palabraBuscada = "manzana";

        String rutaArchivo = "fichero.txt";

        int contador = 0;

        try {
            // Abre el archivo
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));

            // Lee cada línea del archivo
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Divide la línea en palabras
                String[] palabras = linea.split("\\s+"); // División por espacios

                // Compara cada palabra con la palabra buscada
                for (String palabra : palabras) {
                    if (palabra.equalsIgnoreCase(palabraBuscada)) { // Ignora mayúsculas y minúsculas
                        contador++;
                    }
                }
            }

            
            lector.close();

            System.out.println("La palabra \"" + palabraBuscada + "\" aparece " + contador + " veces en el archivo.");

        } catch (IOException e) {
            // Manejo de errores
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
