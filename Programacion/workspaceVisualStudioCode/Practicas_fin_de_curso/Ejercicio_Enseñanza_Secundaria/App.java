package Practicas_fin_de_curso.Ejercicio_Enseñanza_Secundaria;

public class App {

    public static void main(String[] args) {

        // creacion de objetos profesor
        Profesor profesor1 = new Profesor("Estibaliz", "1988", 2500);
        Profesor profesor2 = new Profesor("Blanca", "1980", 4000);

        // creacion de objetos alumno
        Alumno alumno1 = new Alumno("Jonatan", "1988", "Primer año de DAM");
        Alumno alumno2 = new Alumno("Aitor", "2000", "Primer año de DAM");

        // toStrnig de objetos
        System.out.println("Profesores:");
        System.out.println(profesor1);
        System.out.println(profesor2);
        System.out.println("Alumnos:");
        System.out.println(alumno1);
        System.out.println(alumno2);

        // Calculando descuento para un cantidad dado
        double cantidad = 100;
        System.out.println("\nDescuento para profesor: " + profesor1.calcularDescuento(cantidad) + " %");
        System.out.println("Descuento para alumno: " + alumno1.calcularDescuento(cantidad) + " %");

    }
}
