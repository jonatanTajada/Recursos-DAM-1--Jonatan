package ejercicio2_SalaCine;

import java.text.DecimalFormat;
import java.util.Random;

public class Espectador {

    // atributos
    private String nombre;
    private int edad;
    private double dinero;

    // constructor

    public Espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    // getters and setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    // metodo comprobar si especador dinero suficiente para comprar entrada
    public boolean puedePermitirse(double precioEntrada) {
        return dinero >= precioEntrada;
    }

    // metodo generar espectador aleatoriamente
    public static Espectador generarEspectadorAleatorio() {
        Random random = new Random();
        String[] nombres = { "Juan", "Maria", "Carlos", "Laura", "Pedro", "Ana", "David", "Sofia" };
        String nombre = nombres[random.nextInt(nombres.length)];
        int edad = random.nextInt(80) + 1; // Edad entre 1 y 80 años
        double dinero = random.nextDouble() * 100; // Dinero entre 0 y 100
        return new Espectador(nombre, edad, dinero);
    }

    // toString
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return "Espectador: " + nombre + "\n" +
               "Edad: " + edad + " años\n" +
               "Dinero: " + decimalFormat.format(dinero) ;
    }

}
