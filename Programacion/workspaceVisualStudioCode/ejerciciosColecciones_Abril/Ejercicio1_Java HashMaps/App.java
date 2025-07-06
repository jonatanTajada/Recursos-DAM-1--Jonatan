public class App {

    public static void main(String[] args) {
        Colegio colegio = new Colegio();

        // Agregamos algunos alumnos con nacionalidades
        try {
            colegio.addAlumno("Español");
            colegio.addAlumno("Mexicano");
            colegio.addAlumno("Mexicano");
            colegio.addAlumno("Argentino");
            colegio.addAlumno("Español");
            colegio.addAlumno("Colombiano");
            colegio.addAlumno("Colombiano");
            colegio.addAlumno("Venezolano");
            colegio.addAlumno("Ecuatoriano");
        } catch (ExceptionVacio e) {
            System.out.println(e.getMessage());
        }

        // Mostramos todas las nacionalidades y sus alumnos
        System.out.println("Lista de nacionalidades y sus alumnos:");
        colegio.showAll();
        System.out.println();

        // Mostramos la nacionalidad "Español"
        System.out.println("Alumnos con nacionalidad Español:");
        colegio.showNacionalidad("Español");
        System.out.println();

        // Mostramos la nacionalidad "Mexicano"
        System.out.println("Alumnos con nacionalidad Mexicano:");
        colegio.showNacionalidad("Mexicano");
        System.out.println();

        // Mostramos el número de nacionalidades diferentes
        colegio.cuantos();
        System.out.println();

        // Borramos los datos
        colegio.borra();
        System.out.println();

        // Intentamos agregar un alumno con nacionalidad vacía
        try {
            colegio.addAlumno("");
        } catch (ExceptionVacio e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Mostramos todas las nacionalidades después de borrar los datos
        System.out.println("Lista de nacionalidades después de borrar los datos:");
        colegio.showAll();
        System.out.println();

        // Intentamos mostrar la nacionalidad "Colombiano" después de borrar los datos
        System.out.println("Intentamos mostrar la nacionalidad Colombiano después de borrar los datos:");
        colegio.showNacionalidad("Colombiano");
        System.out.println();

        // Mostramos el número de nacionalidades diferentes después de borrar los datos
        colegio.cuantos();
        System.out.println();
    }

}
