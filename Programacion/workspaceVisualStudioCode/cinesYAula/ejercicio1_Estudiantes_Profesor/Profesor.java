package ejercicio1_Estudiantes_Profesor;

import java.util.Random;

public class Profesor extends Persona {

    // atributos
    private Asignaturas materia;

    // constructor
    public Profesor(String nombre, int edad, String sexo, Asignaturas materia) {
        super(nombre, edad, sexo);
        this.materia = materia;
    }

    // setters and getters
    public Asignaturas getMateria() {
        return materia;
    }

    public void setMateria(Asignaturas materia) {
        this.materia = materia;
    }

    // metodo polimorfico ausente
    public boolean ausente() {
        Random random = new Random();
        return random.nextDouble() < 0.2;
    }

    // toString
    @Override
    public String toString() {
        return "\nProfesor: " + "\nNombre: " + super.getNombre() + "\nEdad: " + super.getEdad() +
                "\nSexo: " + super.getSexo() + "\nCalificacion: " + this.materia;
    }

}
