package relacionesEntreClasesProyectoUniversidad;

import java.util.HashSet;

public class Profesor {

	//Atributos
	
	String nombre;
	String cod;
	Departamento departamento;
	
	HashSet<Curso> cursos = new HashSet<Curso>();

	// Constructor

	public Profesor(String nombre, String cod) {
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void setCurso(Curso curso) {
		cursos.add(curso);
	}
	
	

}
