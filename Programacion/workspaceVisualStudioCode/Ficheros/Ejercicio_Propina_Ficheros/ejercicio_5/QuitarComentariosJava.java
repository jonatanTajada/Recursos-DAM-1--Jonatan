package ejercicio_5;

//para ejecutarlo desde la terminal
// java ejercicio_5.QuitarComentariosJava ejercicio_5/Hola.java

import java.io.*;

public class QuitarComentariosJava {
    /**
     * Elimina los comentarios de un archivo Java y guarda el código sin comentarios
     * en un nuevo archivo.
     * 
     * @param args El nombre del archivo Java con comentarios.
     */
    public static void main(String[] args) {
        // Verificar que se ha pasado el nombre del fichero de entrada
        if (args.length < 1) {
            System.out.println("Uso: java QuitarComentariosJava <nombre_fichero>");
            return;
        }

        String nombreFicheroEntrada = args[0];
        String nombreFicheroSalida = "Holav2.java";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreFicheroEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreFicheroSalida));

            String linea;

            while ((linea = lector.readLine()) != null) {
                linea = quitarComentarios(linea); // Llamamos a la función para quitar comentarios
                escritor.write(linea);
                escritor.newLine();
            }

            lector.close();
            escritor.close();

            System.out.println("Comentarios eliminados correctamente. Se ha creado el archivo " + nombreFicheroSalida);
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }

    /**
     * Elimina los comentarios de una línea de código Java.
     * 
     * @param linea La línea de código con comentarios.
     * @return La línea de código sin comentarios.
     */
    public static String quitarComentarios(String linea) {
        // Si la línea contiene "//", eliminamos todo desde ese punto
        if (linea.contains("//")) {
            linea = linea.substring(0, linea.indexOf("//"));
        }
        // Si la línea contiene "/*" y "*/", eliminamos todo lo que está entre ellos
        if (linea.contains("/*") && linea.contains("*/")) {
            linea = linea.replaceAll("/\\*.*?\\*/", "");
        }
        // Si la línea contiene "/*" pero no "*/", marcamos que estamos dentro de un
        // comentario
        if (linea.contains("/*") && !linea.contains("*/")) {
            linea = linea.substring(0, linea.indexOf("/*"));
        }
        // Si estamos dentro de un comentario, retornamos una cadena vacía
        if (linea.trim().equals("") || linea.trim().startsWith("*")) {
            return "";
        }
        return linea;
    }
}
