package Ejercicios_De_Escritura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Escribir una línea en un archivo: Crea un programa que escriba una línea de texto en un archivo.
 * 
 *     try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))){
 * el parametro - true - se hace para escribir al final del texto, y asi no sobreescribir lo que ya 
 * habia en el archivo, porque si no lo que hace borra lo que habia y se pierde lo anterio
 */
public class EscribirLineaEnArchivo {

    public static void main(String[] args) {

        String nombreArchivo = "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\Ficheros\\textoEscritura.txt";

        // crear y escribir en archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write("hola mundo!, esta linea estoy creando archivo y despues escribiendo.");
            bw.newLine();
            System.out.println("linea escrita en el archivo " + nombreArchivo + " con exito!");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: ");
            System.err.println(e.getMessage());
        }

        // escribir en un archivo existente(en el segundo parametro, true)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write("en esta linea estoy escribiendo, no creando, metiendo en el paramentro Filewriter -true-.");
            bw.newLine();
            System.out.println("linea escrita con exito en el archivo: ");
            System.out.println(nombreArchivo);

        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: ");
            System.err.println(e.getMessage());
        }

    }

}
