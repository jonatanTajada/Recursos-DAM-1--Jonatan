package ud_5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_2 {

	
	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
		 
		final int LETRAS_ABECEDARIO = 26;
		 
		char[] arrayChar = new char[LETRAS_ABECEDARIO]; 

        
        for (int i = 0; i < LETRAS_ABECEDARIO; i++) {
            arrayChar[i] = (char) ('A' + i);
        }

        System.out.println(Arrays.toString(arrayChar));
        
        StringBuilder cadenaResultado = new StringBuilder(); 

        System.out.println("Introduce un numero para posicionarte en el array y extraer su letra correspondiente, para salir -1. Valores entre 0-25");

        int posicion;
		
		while ((posicion= scanner.nextInt()) != -1) {
			
			if (posicion >= 0 && posicion < LETRAS_ABECEDARIO) {
				cadenaResultado.append(arrayChar[posicion]);
			}else {
				System.out.println("Error, introduce un numero entre 0 - 25.");
			}
		}

        System.out.println("Cadena resultante: " + cadenaResultado.toString());
    }

			
}
	

















	//2º Opcion sin utilizar el StringBuider...Mejor
// como la opcion 1 ya que es mas eficiente al no uti.lizar tantas concatenaciones...
//
//char[] arrayLetras = new char[26]; // Crear un arreglo de caracteres para A-Z
//
//// Inicializar el arreglo con las letras A-Z
//for (int i = 0; i < 26; i++) {
//    arrayLetras[i] = (char) ('A' + i);
//}
//
//String cadenaResultado = ""; // Inicializar una cadena vacía
//
//Scanner scanner = new Scanner(System.in);
//
//System.out.println("Ingrese posiciones del arreglo para agregar caracteres (0-25). Ingrese -1 para finalizar.");
//
//while (true) {
//    int posicion = scanner.nextInt();
//
//    if (posicion == -1) {
//        break; // Salir del bucle si se ingresa -1
//    } else if (posicion >= 0 && posicion < 26) {
//        cadenaResultado += arrayLetras[posicion];
//    } else {
//        System.out.println("Error, inserte otro número (0-25).");
//    }
//}
//
//System.out.println("Cadena resultante: " + cadenaResultado);
//}
	
	
	
	
	
