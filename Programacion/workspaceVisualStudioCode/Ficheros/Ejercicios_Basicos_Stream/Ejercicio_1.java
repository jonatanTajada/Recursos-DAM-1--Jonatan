package Ejercicios_Basicos_Stream;

import java.io.File;

public class Ejercicio_1 {

    public static void main(String[] args) {

        // Ruta del fichero o directorio
        String ruta = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ejercicios_Basicos_Stream\\prueba.txt";

        // Crear un objeto File con la ruta especificada
        File archivo = new File(ruta);

        // Comprobar si el archivo o directorio existe

        if (archivo.exists()) {

            if (archivo.isDirectory()) { // Mostrar si es un directorio o un fichero
                System.out.println("La ruta indicada es un directorio.");
            } else {
                System.out.println("La ruta indicada es un fichero.");

                System.out.println("Nombre: " + archivo.getName()); // Mostrar el nombre del fichero

                System.out.println("Tamaño: " + archivo.length() + " bytes"); // Mostrar el tamaño del fichero

                // Mostrar permisos de lectura y escritura
                System.out.println("Permisos de lectura: " + (archivo.canRead() ? "Sí" : "No"));
                System.out.println("Permisos de escritura: " + (archivo.canWrite() ? "Sí" : "No"));
            }
        } else {
            System.out.println("La ruta indicada no existe.");
        }
    }

}
