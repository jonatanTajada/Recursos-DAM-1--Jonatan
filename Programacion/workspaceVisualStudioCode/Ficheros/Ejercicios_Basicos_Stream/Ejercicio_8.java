package Ejercicios_Basicos_Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio_8 {

    public static void main(String[] args) {

        String archivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ejercicios_Basicos_Stream\\prueba.txt";

        int sumaEnteros = 0;
        double sumaDoubles = 0.0;

        try {
            // Abrir el archivo para lectura
            BufferedReader bf = new BufferedReader(new FileReader(archivo));

            // Leer la primera línea que contiene números enteros
            String lineaEnteros = bf.readLine();
            System.out.println("Números de tipo int:");
            System.out.println(lineaEnteros);

            // Dividir la línea en números enteros y calcular su suma
            if (lineaEnteros != null && !lineaEnteros.isEmpty()) { // Verificar si la línea no es nula o vacía
                String[] numerosEnteros = lineaEnteros.split(" ");
                for (String numEntero : numerosEnteros) {
                    if (!numEntero.isEmpty()) { // Verificar si el número no es una cadena vacía
                        sumaEnteros += Integer.parseInt(numEntero);
                    }
                }
            }
            System.out.println("Suma de los int: " + sumaEnteros);

            // Leer la segunda línea que contiene números double
            String lineaDoubles = bf.readLine();
            System.out.println("\nNúmeros de tipo double:");
            System.out.println(lineaDoubles);

            // Reemplazar comas por puntos para poder parsear a double
            if (lineaDoubles != null && !lineaDoubles.isEmpty()) { // Verificar si la línea no es nula o vacía
                lineaDoubles = lineaDoubles.replace(",", ".");
                String[] numerosDoubles = lineaDoubles.split(" ");
                for (String numDouble : numerosDoubles) {
                    if (!numDouble.isEmpty()) { // Verificar si el número no es una cadena vacía
                        sumaDoubles += Double.parseDouble(numDouble);
                    }
                }
            }
            System.out.println("Suma de los doubles: " + sumaDoubles);

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
