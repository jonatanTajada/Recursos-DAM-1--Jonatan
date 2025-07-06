import java.io.*;

public class Ejercicio_2 {
    public static void main(String[] args) {

        String nombreArchivo = "primos.dat";

        try {

            FileReader lector = new FileReader(nombreArchivo);
            BufferedReader bufferLector = new BufferedReader(lector);

            String linea;

            // Leer y mostrar los numeros primos en el archivo
            System.out.println("Numeros primos en el archivo " + nombreArchivo + ":");
            while ((linea = bufferLector.readLine()) != null) {
                System.out.println(linea);
            }

            bufferLector.close();
            lector.close();

        } catch (FileNotFoundException e) {
            System.err.println("El archivo " + nombreArchivo + " no se encuentra.");
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
