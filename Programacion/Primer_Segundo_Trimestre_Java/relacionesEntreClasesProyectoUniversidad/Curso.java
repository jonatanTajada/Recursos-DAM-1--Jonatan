package relacionesEntreClasesProyectoUniversidad;

import java.util.HashSet;

public class Curso {

	
	String nombre;
	String cod;
	Profesor profesor;
	Departamento departamento;
	HashSet<Estudiante> estudiantes = new HashSet<Estudiante>();
	
	//Constructor
	
	public Curso(String nombre, String cod) {
		this.nombre= nombre;
		this.cod = cod;
	}

	
	//Setters and Getters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public Departamento getDepartamento() {
		return departamento ;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	
	
}
