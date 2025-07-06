package Ejercicios_Clase_File;

import java.io.File;

/*
 * Verificar si un archivo existe:
 * Enunciado: Crea un programa que verifique si un archivo existe en el directorio actual.
 */
public class VerificarExistenciaArchivo {

    public static void main(String[] args) {

        File archivo = new File(
                "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\verificarExistencia.txt");

        if (archivo.exists()) {
            System.out.println("el archivo si existe, en la ruta: ");
            System.out.println(archivo.getPath());
        } else {
            System.err.println("El archivo no existe en la ruta especificada");
        }
    }
}
