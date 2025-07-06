package ejercicio1_Estudiantes_Profesor;



public class App {

    public static void main(String[] args) {

       // Crear profesor
       Profesor profesoraBlanca = new Profesor("Blanca", 45, "Femenino", Asignaturas.MATEMATICAS);

       // Crear estudiantes
       Estudiante estudiante1 = new Estudiante("Ana", 20, "Femenino", 8);
       Estudiante estudiante2 = new Estudiante("Carlos", 21, "Masculino", 6);
       Estudiante estudiante3 = new Estudiante("Laura", 22, "Femenino", 4);
       Estudiante estudiante4 = new Estudiante("Pedro", 21, "Masculino", 7);

       // Creación de un aula
       Aula aula = new Aula(1, 20,  Asignaturas.MATEMATICAS, profesoraBlanca);

       // Agregar estudiantes al aula
       aula.agregarEstudiante(estudiante1);
       aula.agregarEstudiante(estudiante2);
       aula.agregarEstudiante(estudiante3);
       aula.agregarEstudiante(estudiante4);

       // Verificar si se puede impartir clase en el aula
       if (aula.puedeImpartirClase()) {
           System.out.println("Se puede impartir clase en el aula.");
           aula.mostrarEstudiantesAprobados();
       } else {
           System.out.println("No se puede impartir clase en el aula.");
       }

    }

}
