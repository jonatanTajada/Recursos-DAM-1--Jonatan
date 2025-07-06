package ejercicio1_Estudiantes_Profesor;

import java.util.Random;

public class Estudiante extends Persona {

    // atributos
    private double calificacion;

    // constructor
    public Estudiante(String nombre, int edad, String sexo, double calificacion) {
        super(nombre, edad, sexo);
        this.calificacion = calificacion;
    }

    // getters and setters
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    // metodo poliformico ausente
    public boolean ausente() {
        Random random = new Random();
        return random.nextDouble() < 0.5;
    }

    // toString
    @Override
    public String toString() {
        return "\nEstudiante: " + "\nNombre: " + super.getNombre() + "\nEdad: " + super.getEdad() +
                "\nSexo: " + super.getSexo() + "\nCalificacion: " + this.calificacion;
    }

}
