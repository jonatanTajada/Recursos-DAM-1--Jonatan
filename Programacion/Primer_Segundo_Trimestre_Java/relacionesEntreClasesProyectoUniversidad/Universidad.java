package relacionesEntreClasesProyectoUniversidad;

import java.util.HashSet;
import java.util.Iterator;

public class Universidad {

	//Atributos
	String nombre;

	HashSet<Departamento> departamentos = new HashSet<Departamento>();
	HashSet<Estudiante> estudiantes = new HashSet<Estudiante>();
	
	//Constructor
	
	public Universidad(String nombre) {
		this.nombre= nombre;
	}

	//Setters and Getters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Estos los hago yo manualmente...en todas las clases que tenga hashSet los hago yo manualmente...!!!
	public void setDepartamento(Departamento departamento) {
		departamentos.add(departamento);
	}
	
	public void setEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	
	//Metodos
	
	public void matricularEstudiante(Estudiante estudiante, Departamento departamento) {
		estudiantes.add(estudiante);
		estudiante.setUniversidad(this);
		departamento.setEstudiante(estudiante);
		estudiante.setDepartamento(departamento);
	}
	
	
	public Departamento buscarDepartamento(String nombre) {
		
		Departamento d = null;
		
		Iterator<Departamento> iterator = departamentos.iterator();
			
		while (iterator.hasNext()) {
			
			d = iterator.next();
			if (d.getNombre().equals(nombre)) {
				return d;
			}
		}
		d = null;
		return d;
	}
	

	public String mostrarDepartamentos() {
		
		StringBuilder dato = new StringBuilder();
        for (Departamento departamento : departamentos) {
            dato.append(departamento.toString()).append("\n");
        }
		
		return dato.toString();
	}
	
	
	
}
