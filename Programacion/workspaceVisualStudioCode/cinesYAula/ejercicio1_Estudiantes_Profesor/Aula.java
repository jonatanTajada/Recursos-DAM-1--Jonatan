package ejercicio1_Estudiantes_Profesor;

import java.util.ArrayList;

public class Aula {

    // atributos
    private int id;
    private int maxEstudiantes;
    private Asignaturas materiaDestinada;
    private Profesor profesor;
    private ArrayList<Estudiante> listaEstudiantes;

    // constructor
    public Aula(int id, int maxEstudiantes, Asignaturas materiaDestinada, Profesor profesor) {
        this.id = id;
        // this.maxEstudiantes = maxEstudiantes;
        this.materiaDestinada = materiaDestinada;
        this.profesor = profesor;
        this.listaEstudiantes = new ArrayList<>();
    }

    // setters and getters
    public int getId() {
        return id;

    }

    public void setMateriaDestinada(Asignaturas materiaDestinada) {
        this.materiaDestinada = materiaDestinada;
    }

    public Asignaturas getMateriaDestinada() {
        return materiaDestinada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxEstudiantes() {
        return maxEstudiantes;
    }

    public void setMaxEstudiantes(int maxEstudiantes) {
        this.maxEstudiantes = maxEstudiantes;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public ArrayList<Estudiante> getEstudiantesPresentes() {
        ArrayList<Estudiante> estudiantesPresentes = new ArrayList<>();
        for (Estudiante estudiante : listaEstudiantes) {
            if (!estudiante.ausente()) {
                estudiantesPresentes.add(estudiante);
            }
        }
        return estudiantesPresentes;
    }

    // metodo para saber si se puede impartir clase

    public boolean puedeImpartirClase() {
        // Comprobación del número de estudiantes
        int cantidadPresentes = 0;
        for (Estudiante estudiante : listaEstudiantes) {
            if (!estudiante.ausente()) {
                cantidadPresentes++;
            }
        }
        System.out.println("Cantidad de estudiantes presentes: " + cantidadPresentes);
        return cantidadPresentes >= maxEstudiantes * 0.5;
    }

    // mostrar estudiantes aprobados
    public void mostrarEstudiantesAprobados() {
        int aprobadosHombres = 0;
        int aprobadosMujeres = 0;

        for (Estudiante estudiante : listaEstudiantes) {
            if (!estudiante.ausente()) {
                if (estudiante.getCalificacion() >= 5) {
                    if (estudiante.getSexo().equalsIgnoreCase("Masculino")) {
                        aprobadosHombres++;
                    } else {
                        aprobadosMujeres++;
                    }
                }
            }
        }

        System.out.println("Estudiantes aprobados:");
        System.out.println("- Hombres: " + aprobadosHombres);
        System.out.println("- Mujeres: " + aprobadosMujeres);
    }

}
