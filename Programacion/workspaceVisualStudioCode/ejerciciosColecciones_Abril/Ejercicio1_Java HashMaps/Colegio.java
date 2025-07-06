import java.util.HashMap;

public class Colegio {

    // atributos
    private HashMap<String, Integer> nacionalidades;

    // constructor
    public Colegio() {
        this.nacionalidades = new HashMap<>();
    }

    // añadir alumno
    public void addAlumno(String nacionalidad) throws ExceptionVacio {
        if (nacionalidad.isEmpty()) {
            throw new ExceptionVacio("La nacionalidad no puede estar vacia!");
        }

        nacionalidad = nacionalidad.toUpperCase();

        if (nacionalidades.containsKey(nacionalidad)) {
            nacionalidades.put(nacionalidad, nacionalidades.get(nacionalidad) + 1);
        } else {
            nacionalidades.put(nacionalidad, 1);
        }
    }

    // Muestra las distintas nacionalidades y el número de alumnos que existen por
    // nacionalidad.
    public void showAll() {
        for (String key : nacionalidades.keySet()) {
            System.out.println(key + " - " + nacionalidades.get(key));
        }
    }

    // Muestra la nacionalidad y el número de alumnos de esa nacionalidad
    public void showNacionalidad(String nacionalidad) {
        nacionalidad = nacionalidad.toUpperCase();
        if (nacionalidades.containsKey(nacionalidad)) {
            System.out.println(nacionalidad + " - " + nacionalidades.get(nacionalidad));
        } else {
            System.out.println("No hay alumnos con nacionalidad " + nacionalidad);
        }
    }

    // Muestra cuántas nacionalidades diferentes existen en el colegio.
    public void cuantos() {
        System.out.println("Numero de nacionalidades diferentes: " + nacionalidades.size());
    }

    // Elimina los datos insertados.
    public void borra() {
        nacionalidades.clear();
        System.out.println("Datos eliminados con exito!");
    }

}
