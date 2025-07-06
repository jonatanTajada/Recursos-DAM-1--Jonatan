
/*     
necesitaremos realizar las siguientes acciones:
  1.  Leer el archivo linea por linea.
  2.  Dividir cada linea en palabras.
  3.  Comparar cada palabra con la palabra objetivo.
  4.  Contar las ocurrencias. 
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContadorDePalabras {

    public static void main(String[] args) {

        String palabraBuscada = "manzana";

        String rutaArchivo = "./fichero.txt";

        int contador = 0;

        try {
            // Abre el archivo
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            // Lee cada linea del archivo
            String linea;
            while ((linea = br.readLine()) != null) {
                // Divide la linea en palabras
                String[] palabras = linea.split("\\s+"); // Division por espacios y el '+' busca mas ocurrencias

                // Compara cada palabra con la palabra buscada
                for (String palabra : palabras) {
                    if (palabra.equalsIgnoreCase(palabraBuscada)) {
                        contador++;
                    }
                }
            }

            br.close();

            System.out.println("La palabra \"" + palabraBuscada + "\" aparece " + contador + " veces en el archivo.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
