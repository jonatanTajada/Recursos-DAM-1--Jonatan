package Ejercicios_Clase_File;

import java.io.File;

/*
 * Eliminar un archivo:
 * Enunciado: Crea un programa que elimine un archivo existente.
 */
public class EliminarArchivo {

    public static void main(String[] args) {

        File archivo = new File(
                "D:\\\\Users\\\\famil\\\\Desktop\\\\PROGRAMACION\\\\DAM ORDUÑA 2023_2024\\\\Programacion\\\\workspaceVisualStudioCode\\\\Ficheros\\\\datos.csv");

        if (archivo.delete()) {
            System.out.println("Archivo eliminado con exito!");
        } else {
            System.err.println("El archivo no se ha podido eliminar o no existe");
        }

    }
}
