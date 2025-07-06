import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejercicio_3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> listaNumeros = new ArrayList<>();

        int contador = 10;
        int numUsuario;

        for (int i = 0; i < contador; i++) {
            System.out.print("Introduce un numero: ");
            numUsuario = scanner.nextInt();
            listaNumeros.add(numUsuario);
            System.out.println();

        }

        System.out.println("Mostrar array sin ordenar: ");
        for (Integer num : listaNumeros) {
            System.out.println(num.toString());
        }

        Collections.sort(listaNumeros);

        System.out.println("Mostrar array ordenados");
        for (int num : listaNumeros) {
            System.out.println(num);
        }

        scanner.close();

    }

}
