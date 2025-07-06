import java.io.*;

public class Ejercicio_1 {
    public static void main(String[] args) {

        String nombreArchivo = "primos.dat";

        try {
            // Crear un FileWriter para escribir en el archivo
            FileWriter fw = new FileWriter(nombreArchivo);
            BufferedWriter bufferfw = new BufferedWriter(fw);

            // Buscar y escribir los numeros primos en el archivo
            for (int i = 1; i <= 500; i++) {
                if (esPrimo(i)) {
                    bufferfw.write(Integer.toString(i));
                    bufferfw.newLine(); // Saltar a la siguiente linea
                }
            }

            bufferfw.close();
            fw.close();

            System.out.println("Se han guardado los numeros primos en el archivo " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }

    //-----------------------------------------------------------------------------
    // Método para comprobar si un numero es primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
