package Ejercicios_De_Escritura;

import java.io.*;


/*
 * Escribir datos en un archivo HTML: Crea un programa y archivo que escriba datos en un archivo HTML.
 */
public class EscribirDatosHTML {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\creacionYEscrituraHTMLDesdeJava.html";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("<html>");
            bw.newLine();
            bw.write("<head>");
            bw.newLine();
            bw.write("<title>Mi página web</title>");
            bw.newLine();
            bw.write("</head>");
            bw.newLine();
            bw.write("<body>");
            bw.newLine();
            bw.write("<h1>Bienvenido a mi página web</h1>");
            bw.newLine();
            bw.write("<p>Esta es una página de ejemplo.</p>");
            bw.newLine();
            bw.write("</body>");
            bw.newLine();
            bw.write("</html>");
            bw.newLine();
            System.out.println("Datos escritos en el archivo " + nombreArchivo + " con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
