package ejercicio5_JuegoDados;

import java.util.Random;

public class Dado {

    // atributos
    private int caras;
    private int caraSuperior;

    // Constructor por defecto: dado de 6 caras
    public Dado() {
        this.caras = 6;
        tirarDado();
    }

    // Constructor con especificación del número de caras
    public Dado(int caras) {
        this.caras = caras;
        tirarDado();
    }

    // Constructor con especificación del número de caras y la cara superior
    public Dado(int caraSuperior, int caras) {
        this.caraSuperior = caraSuperior;
        this.caras = caras;
    }

    // Getter para obtener la cara superior del dado
    public int getCaraSuperior() {
        return caraSuperior;
    }

    // Getter para obtener el número de caras del dado
    public int getCaras() {
        return caras;
    }

    // Método para tirar el dado al azar
    public void tirarDado() {
        Random rand = new Random();
        caraSuperior = rand.nextInt(caras) + 1;
    }

    // Método toString para representar el dado como una cadena
    @Override
    public String toString() {
        switch (caraSuperior) {
            case 1:
                return " _______\n" +
                        "|       |\n" +
                        "|   ●   |\n" +
                        "|       |\n" +
                        " ‾‾‾‾‾‾‾";
            case 2:
                return " _______\n" +
                        "| ●     |\n" +
                        "|       |\n" +
                        "|     ● |\n" +
                        " ‾‾‾‾‾‾‾";
            case 3:
                return " _______\n" +
                        "| ●     |\n" +
                        "|   ●   |\n" +
                        "|     ● |\n" +
                        " ‾‾‾‾‾‾‾";
            case 4:
                return " _______\n" +
                        "| ●   ● |\n" +
                        "|       |\n" +
                        "| ●   ● |\n" +
                        " ‾‾‾‾‾‾‾";
            case 5:
                return " _______\n" +
                        "| ●   ● |\n" +
                        "|   ●   |\n" +
                        "| ●   ● |\n" +
                        " ‾‾‾‾‾‾‾";
            case 6:
                return " _______\n" +
                        "| ●   ● |\n" +
                        "| ●   ● |\n" +
                        "| ●   ● |\n" +
                        " ‾‾‾‾‾‾‾";

        }
        return "";
    }
}
