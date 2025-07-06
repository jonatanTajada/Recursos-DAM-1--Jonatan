import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio_2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Random random = new Random();

        int tamanio = random.nextInt(6) + 5;
        int suma = 0;
        double media = 0;
        int maximo, minimo;

        List<Integer> listaNumerosAleatorios = new ArrayList<>();

        for (int i = 0; i < tamanio; i++) {
            int numAleatorio = random.nextInt(101);
            listaNumerosAleatorios.add(numAleatorio);
            System.out.println(numAleatorio + " ");
        }
        System.out.println();

        // calcular la suma
        for (Integer num : listaNumerosAleatorios) {
            suma += num;
        }

        // Calcular el máximo y el mínimo
        maximo = Integer.MIN_VALUE;
        minimo = Integer.MAX_VALUE;

        for (Integer num : listaNumerosAleatorios) {
            if (num > maximo) {
                maximo = num;
            }

            if (num < minimo) {
                minimo = num;
            }
        }

        // calcular la media
        media = (double) suma / tamanio;

        // Mostrar los resultados
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Maximo: " + maximo);
        System.out.println("Minimo: " + minimo);

    }

}
