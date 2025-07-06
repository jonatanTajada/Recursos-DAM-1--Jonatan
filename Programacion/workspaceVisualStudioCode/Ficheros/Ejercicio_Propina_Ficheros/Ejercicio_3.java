import java.io.*;

public class Ejercicio_3 {


    public static void main(String[] args) {
        String nombreFichero1 = "fichero1.txt"; 
        String nombreFichero2 = "fichero2.txt"; 
        String nombreFicheroResultado = "mezcla.txt"; 
        
        try {
            // Abre los dos ficheros de entrada
            BufferedReader br1 = new BufferedReader(new FileReader(nombreFichero1));
            BufferedReader br2 = new BufferedReader(new FileReader(nombreFichero2));
            // Crea el fichero de salida
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreFicheroResultado));
            
            String lineaFichero1, lineaFichero2;
            boolean finFichero1 = false, finFichero2 = false;
            
           
            while (!finFichero1 || !finFichero2) {
                // Lee una línea del primer fichero
                lineaFichero1 = br1.readLine();
                if (lineaFichero1 != null) {
                    escritor.write(lineaFichero1);
                    escritor.newLine(); // Escribir la línea en el fichero de salida
                } else {
                    finFichero1 = true; // Marcar que se ha llegado al final del primer fichero
                }
                
                // Lee una línea del segundo fichero
                lineaFichero2 = br2.readLine();
                if (lineaFichero2 != null) {
                    escritor.write(lineaFichero2);
                    escritor.newLine(); // Escribir la línea en el fichero de salida
                } else {
                    finFichero2 = true; // Marcar que se ha llegado al final del segundo fichero
                }
            }
            
            // Cerrar los lectores y escritor
            br1.close();
            br2.close();
            escritor.close();
            
            System.out.println("Se han mezclado los ficheros correctamente en " + nombreFicheroResultado);
            
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
