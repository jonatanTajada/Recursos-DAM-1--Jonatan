package ejercicio_Diccionario_HashMap_abril;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Diccionario diccionario = new Diccionario();
        cargarDiccionario(diccionario,
                "D:\\Users\\famil\\Desktop\\PROGRAMACION\\DAM ORDUÑA 2023_2024\\Programacion\\workspaceVisualStudioCode\\ejercicio_Diccionario_HashMap_abril\\palabras.txt");

        Scanner scanner = new Scanner(System.in);
        int totalPreguntas = 0;
        int totalAciertos = 0;
        int totalErrores = 0;

        System.out.println("Bienvenido al cuestionario de traducción español-inglés.");
        System.out.println("Escribe 'fin' en cualquier momento para terminar el programa.\n");

        while (true) {
            String palabraEspañol = diccionario.palabraAleatoria();
            char primeraLetraTraduccion = diccionario.primeraLetraTraduccion(palabraEspañol);

            System.out.print(palabraEspañol + ": " + primeraLetraTraduccion + "...");
            System.out.print("\nIndique la respuesta: ");
            String respuestaUsuario = scanner.nextLine();

            if (respuestaUsuario.equalsIgnoreCase("fin")) {
                break;
            }

            totalPreguntas++;

            String traduccionCorrecta = diccionario.traduce(palabraEspañol);
            if (respuestaUsuario.equalsIgnoreCase(traduccionCorrecta)) {
                totalAciertos++;
                System.out.println("¡CORRECTO!\n");
            } else {
                totalErrores++;
                System.out.println("¡NO! La respuesta correcta es " + traduccionCorrecta + "\n");
            }
        }

        System.out.println("FIN DEL PROGRAMA");
        System.out.println("Total preguntas: " + totalPreguntas);
        System.out.println("Total aciertos: " + totalAciertos);
        System.out.println("Total errores: " + totalErrores);
        double porcentajeAciertos = (double) totalAciertos / totalPreguntas * 100;
        System.out.println("Aciertos: " + porcentajeAciertos + "%");
    }

    // ----------METODOS----------------------------
    private static void cargarDiccionario(Diccionario diccionario, String archivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length != 2) {
                    System.out.println("Error: Formato incorrecto en la línea: " + linea);
                    continue; // Saltar esta línea y continuar con la siguiente
                }
                diccionario.nuevoPar(partes[0], partes[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * el programa está diseñado para cargar un diccionario desde un archivo de
     * texto que contiene pares de palabras en español e inglés. Luego, genera
     * preguntas aleatorias a partir de ese diccionario, pidiendo al usuario que
     * traduzca una palabra en español a su equivalente en inglés.
     */

}
