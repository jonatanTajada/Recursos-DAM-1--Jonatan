package Ejercicios_Clase_File;

import java.io.File;
import java.io.IOException;

/*
 * Crear un archivo nuevo:
 *  Enunciado: Crea un programa que cree un archivo nuevo en el directorio actual.
 */
public class CrearArchivoNuevo {

    public static void main(String[] args) {

        File archivo = new File("nuevoCreadoConFile.txt");

        try {
            if (archivo.createNewFile()) {
                System.out.println("archivo creado con exito");
            } else {
                System.err.println("El archivo ya existe");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: ");
            System.err.println(e.getMessage());
        }

    }

}
