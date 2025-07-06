import java.io.*;

public class ModificarFichero {

    public static void main(String[] args) {

        System.out.print("Introduce la palabra a buscar: ");
        String palabra = "";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            palabra = br.readLine();
        } catch (IOException e) {
            System.err.println("Error al leer la entrada del teclado: " + e.getMessage());
            System.exit(1);
        }

        // Abrir el fichero de texto
        File file = new File("texto.txt");

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) { // rw - para abrir en modo lectura y escritura
            String linea;
            StringBuilder contenido = new StringBuilder();

            while ((linea = raf.readLine()) != null) {
                // Guardar la linea original para imprimir si se modifica
                String lineaOriginal = linea;
                // Comprobar si la linea contiene la palabra buscada
                if (linea.contains(palabra)) {
                    // Modificar la línea: reemplazar la palabra con su versión en mayúsculas
                    linea = linea.replaceAll(palabra, palabra.toUpperCase());

                    System.out.println("Linea original: " + lineaOriginal);
                    System.out.println("Linea modificada: " + linea);
                }
                // Agregar la linea (modificada o no) al contenido
                contenido.append(linea).append("\n");
            }
            // Posicionar el puntero al inicio del archivo y escribir todo el contenido
            // modificado
            raf.setLength(0); // Limpiar el archivo
            raf.writeBytes(contenido.toString());
        } catch (IOException e) {
            System.out.println("Error al leer/escribir en el fichero: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Proceso completado.");
    }
}
