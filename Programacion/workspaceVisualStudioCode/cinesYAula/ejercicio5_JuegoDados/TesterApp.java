package ejercicio5_JuegoDados;

public class TesterApp {

    public static void main(String[] args) {

        Dado[] dados = new Dado[4];

        dados[0] = new Dado(); // Dado por defecto
        dados[1] = new Dado(5); // Dado con 5 caras
        dados[2] = new Dado(4, 10); // Dado con 4 caras y un total de 10 caras
        dados[3] = new Dado(8); // Dado con 8 caras

        int lanzamientos = 10; // Número de lanzamientos

        int[] contadorNumeros = new int[6];

        for (int i = 0; i < lanzamientos; i++) {
            System.out.println("Lanzamiento " + (i + 1) + ":");

            for (Dado dado : dados) {
                dado.tirarDado();
                System.out.println("Cara superior del dado: " + dado.getCaraSuperior());
                System.out.println(dado); // imprimira el dado virtual

                // Incrementar el contador solo si el número generado está dentro del rango, 1-6
                if (dado.getCaraSuperior() >= 1 && dado.getCaraSuperior() <= 6) {
                    contadorNumeros[dado.getCaraSuperior() - 1]++;
                }
            }
            System.out.println();
        }

        // Mostrar los contadores de cada número del 1 al 6
        for (int i = 0; i < contadorNumeros.length; i++) {
            System.out.println("Cantidad de " + (i + 1) + "s: " + contadorNumeros[i]);
        }

    }
}
