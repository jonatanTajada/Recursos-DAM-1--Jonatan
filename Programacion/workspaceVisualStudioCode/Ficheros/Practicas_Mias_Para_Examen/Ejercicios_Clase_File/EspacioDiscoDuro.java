package Ejercicios_Clase_File;

import java.io.File;

/*
 * Para obtener el espacio de disco duro de cada unidad en Java, 
 * puedes utilizar la clase File y el método getTotalSpace() y getUsableSpace()
 */
public class EspacioDiscoDuro {

    public static void main(String[] args) {

        File[] roots = File.listRoots();

        for (File root : roots) {
            System.out.println("Unidad: " + root);
            System.out.println("Espacio total: " + formatBytes(root.getTotalSpace()));
            System.out.println("Espacion disponible: " + formatBytes(root.getUsableSpace()));
            System.out.println();
        }

    }

    // metodo para formatear bytes en KB, MB, GB, etc.
    public static String formatBytes(long bytes) {
        if (bytes < 1024) {
            return bytes + " bytes";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.2f KB", bytes / 1024.0);
        } else if (bytes < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", bytes / (1024.0 * 1024));
        } else {
            return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
        }
    }

}
