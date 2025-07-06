package Ejercicios_Basicos_Stream;

import java.io.File;

public class Ejercicio_6 {

    public static void main(String[] args) {

        // Obtener todas las unidades de disco disponibles
        // Se llama al método estático listRoots() de la clase File, que devuelve un
        // array de objetos File,
        // cada uno representando una raíz de unidad de disco en el sistema.
        File[] unidades = File.listRoots();

        // Mostrar información para cada unidad de disco

        for (File unidad : unidades) {
            System.out.println("Unidad: " + unidad.getPath());
            System.out.println("Tamaño total: " + formatSize(unidad.getTotalSpace())); // Se muestra el tamaño total de
                                                                                       // la unidad de disco actual,
                                                                                       // formateado de manera legible,
                                                                                       // utilizando el método
                                                                                       // getTotalSpace() de la clase
                                                                                       // File. La cantidad devuelta
                                                                                       // está en bytes.
            System.out.println("Espacio disponible: " + formatSize(unidad.getFreeSpace()));
            System.out.println("--------------------------------------------");
        }
    }

    // Método para formatear el tamaño en bytes a un formato legible
    private static String formatSize(long bytes) {
        long kiloBytes = bytes / 1024;
        long megaBytes = kiloBytes / 1024;
        long gigaBytes = megaBytes / 1024;

        if (gigaBytes > 0) {
            return String.format("%d GB", gigaBytes);
        } else if (megaBytes > 0) {
            return String.format("%d MB", megaBytes);
        } else if (kiloBytes > 0) {
            return String.format("%d KB", kiloBytes);
        } else {
            return String.format("%d bytes", bytes);
        }
    }

}
