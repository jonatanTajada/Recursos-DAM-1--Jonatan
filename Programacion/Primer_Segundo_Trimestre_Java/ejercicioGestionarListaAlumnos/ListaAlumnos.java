package ejercicioGestionarListaAlumnos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ListaAlumnos {

	//Atributos
	private List<Alumno> listaAlumnos;
	
	public ListaAlumnos() {
		this.listaAlumnos = new ArrayList<Alumno>();
	}
	
	//Metodos
	
	//Agregar alumno
	public void agregarAlumno(Alumno alumno) {
		if (!listaAlumnos.contains(alumno)) {
			listaAlumnos.add(alumno);
			JOptionPane.showMessageDialog(null, "Alumno agregado correctamente!");
		}else {
			JOptionPane.showMessageDialog(null, "Error: Ya existe un alumno con este mismo D.N.I!!!");
		}
	}
	
	
	//Buscar alumno
	public Alumno buscarAlumno(String dni) {
		
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		JOptionPane.showMessageDialog(null, "No se encontro ningun alumno con ese DNI!!!");
		return null;
	}
	
	
	//Mostrar datos
	public void mostrarDatos() {
		
		if (listaAlumnos.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "No hay alumnos matriculados");
		}else {
			
			 StringBuilder mensaje = new StringBuilder("Lista de Alumnos:\n");
			 
			for (Alumno alumno : listaAlumnos) {
				mensaje.append("Nombre: ").append(alumno.getNombre()).append(alumno.getDni()).append("\n");
			}
			JOptionPane.showMessageDialog(null, mensaje.toString());
		}
	}
	
	
	
	
	
	
}
