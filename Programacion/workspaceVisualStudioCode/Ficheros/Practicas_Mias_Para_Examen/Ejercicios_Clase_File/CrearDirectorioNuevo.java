package Ejercicios_Clase_File;

import java.io.File;


/*
 * Crear un directorio nuevo:
 * Enunciado: Crea un programa que cree un directorio nuevo en el directorio actual.
 */
public class CrearDirectorioNuevo {

    public static void main(String[] args) {

        File directorio = new File("nuevoDirectorioDesdeJava");

        if (directorio.mkdir()) {
            System.out.println("Directorio creado con exito!");
        } else {
            System.out.println("El directorio ya existe o no se pudo crear");
        }

    }

}
