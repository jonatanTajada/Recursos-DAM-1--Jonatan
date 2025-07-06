package relacionesEntreClasesProyectoUniversidad;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

public class App {

	//TENGO QUE BUSCAR LA PARTE 3 DE ESTE CURSO...YOUTUBER:  TONY ALCAST TOTULO DE VIDEO: JAVA - RELACIONES ENTRE CLASES(03)-- NO TIENE LA PARTE 3
	//TERMINARLO YO MISOM
	
	public static void main(String[] args) {
		
		
		Universidad universidad = new Universidad("UNIVERSIDAD ORDUÑA");
		
		universidad.setDepartamento(new Departamento("Ing. de Electronica"));
		universidad.setDepartamento(new Departamento("Ing. de Sistemas"));
		universidad.setDepartamento(new Departamento("Ing. Civil"));
		
		
		boolean salir = false;
		String datosMenu;
		int opcion;
		
		while (salir != true) {
			
			do {
				
				datosMenu = "***SISTEMA UNIVERSITARIO: "  + universidad.getNombre() + "***\n" + 
						"1. Matricula estudiante\n"+
						"2. Asignar profesor a departamento\n"+
						"3. Crear curso en el sistema\n"+
						"4. Asignar alumnos a un curso\n"+
						"5. Listar los datos de un curso\n"+
						"6. Listar cursos de un estudiante\n"+
						"7. Salir\n"+
						"\nIngrese opcion: ";
				
				opcion = Integer.valueOf(JOptionPane.showInputDialog(datosMenu));
				
				if (opcion < 1 || opcion > 7) {
					System.err.println("Por favor, ingrese un numero entre el 1 y el 7, Gracias!!");
				}
				
			} while (opcion < 1 || opcion > 7);
			
			
			switch (opcion) {
			
			case 1:
				
				String nombre;
				String cod;
				cod = JOptionPane.showInputDialog("Introduce el codigo del estudiante:  \n");
				nombre = JOptionPane.showInputDialog("Introduce el nombre del estudiante a matricular: \n");
				Estudiante e = new Estudiante(nombre, cod);
				
				nombre = JOptionPane.showInputDialog(universidad.mostrarDepartamentos() + "\n\nIngrese departamento a matricular: \n" );
				Departamento d = universidad.buscarDepartamento(nombre);
				if (d == null) {
					JOptionPane.showMessageDialog(null, "\nEl departamentoingresado no existe.");
					break;
				}
				universidad.matricularEstudiante(e, d);
				JOptionPane.showMessageDialog(null, "\nEl estudiante se ha matriculado con exito!");
				break;
				
			case 2:
				
				String nDep;
				String nProf;
				String codProf;
				nDep = JOptionPane.showInputDialog(universidad.mostrarDepartamentos() + "\n\nIngrese departamento de profesor a asignar.\n");
				Departamento dep = universidad.buscarDepartamento(nDep);
				if (dep == null) {
					JOptionPane.showMessageDialog(null, "El departamento ingresado no exite.");
					break;
				}
				nProf= JOptionPane.showInputDialog("Ingrese el nombre del profesor a asiganr:\n");
				codProf= JOptionPane.showInputDialog("Ingrese el codigo de profesor a asignar: \n");
				Profesor profe = new Profesor(nProf, codProf);
				profe.setDepartamento(dep);
				dep.setProfesor(profe);
				JOptionPane.showMessageDialog(null, "El profesor se asignado al departamento con exito al " + dep.toString());
				break;
				
			case 3:
				
				String nDepa;
				String codCurso;
				String nombreCurso;
				
				nDepa = JOptionPane.showInputDialog(universidad.mostrarDepartamentos() + "\n\nIngrese departamento de curso a crear:\n");
				Departamento depa = universidad.buscarDepartamento(nDepa);
				if (depa == null) {
					JOptionPane.showMessageDialog(null, "El departamento ingresado no exite.");
					break;
				}
				
				codCurso = JOptionPane.showInputDialog("\n\nIngrese codigo del curso a crear:\n");
				Curso newCurso = depa.buscarCursos(codCurso);
				if (newCurso != null) {
					JOptionPane.showMessageDialog(null, "El codigo ingresado ya existe.");
					break;
				}
				
				nombreCurso = JOptionPane.showInputDialog("\n\nIngrese el nombre del curso a crear:\n");
				Curso nCurso = new Curso(nombreCurso, codCurso);
				
				depa.setCurso(nCurso);
				nCurso.setNombre(nombreCurso);
				
				JOptionPane.showMessageDialog(null, "\nEl nuevo curso " + nCurso.getNombre() +  " se ha creado con exito en el " + depa.toString());
				
				break;
				
			case 4:
				break;
				
			case 5:
				break;
				
			case 6:
				break;
				
			case 7:
				salir = true;
				break;	

			default:
				break;
				
				
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
