package Ejercicios_Clase_File;

import java.io.File;

/*
 * Listar archivos de un directorio:
 * Enunciado: Crea un programa que liste todos los archivos y directorios en el directorio actual.
 */
public class ListarArchivosDirectorio {

    public static void main(String[] args) {

        File directorio = new File(".");
        File[] archivos = directorio.listFiles();

        System.out.println("Archivos en el directorio actual: ");
        for (File archivo : archivos) {
            System.out.println(archivo.getName());
        }

    }
}
