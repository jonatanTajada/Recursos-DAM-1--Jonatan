package relacionesEntreClasesProyectoUniversidad;

import java.util.HashSet;
import java.util.Iterator;

public class Departamento {

	//Atributos
	
	String nombre;
	Universidad universidad;
	
	HashSet<Profesor> profesores =  new HashSet<Profesor>();
	HashSet<Estudiante> estudiantes = new HashSet<Estudiante>();
	HashSet<Curso> cursos = new HashSet<Curso>(); 
	
	
	//Constructor
	
	public Departamento(String nombre) {
		this.nombre=nombre;
	}

	//Setters ands Getters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public void setProfesor(Profesor profesor) {
		profesores.add(profesor);
	}
	
	public void setEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}

	public void setCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public String toString() {
		return "Dep: " + nombre;
	}
	
	
	//Metodos
	
	public Curso buscarCursos(String cod) {
		
		Curso c = null;
		
		Iterator<Curso> iterator = cursos.iterator();
			
		while (iterator.hasNext()) {
			
			c = iterator.next();
			if (c.getNombre().equals(cod)) {
				return c;
			}
		}
		c = null;
		return c;
	}
	
}
