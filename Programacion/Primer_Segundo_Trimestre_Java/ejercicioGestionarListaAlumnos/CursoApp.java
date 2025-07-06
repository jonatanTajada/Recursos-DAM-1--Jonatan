package ejercicioGestionarListaAlumnos;

import javax.swing.JOptionPane;

public class CursoApp {
	
	public static void main(String[] args) {
		
		ListaAlumnos listaAlumnos = new ListaAlumnos();
		InterfazGrafica interfaz = new InterfazGrafica();

		int opcion;
		
		do {
			
				interfaz.mostrarMenu();
				opcion = Integer.parseInt(interfaz.solicitarEntradaUsuario("Ingrese su opción"));
				
			switch (opcion) {
			case 1:
				// Añadir Alumno
				String nombre = interfaz.solicitarEntradaUsuario("Ingrese el nombre del alumno");
				String direccion = interfaz.solicitarEntradaUsuario("Ingrese la direccion del alumno");
				String telefono = interfaz.solicitarEntradaUsuario("Ingrese el telefono del alumno");
				String dni = interfaz.solicitarEntradaUsuario("Ingrese el DNI del alumno");

				Alumno nuevoAlumno = new Alumno(nombre, direccion, telefono, dni);
				listaAlumnos.agregarAlumno(nuevoAlumno);
				break;
				
			case 2:
				// Buscar Alumno por DNI
				String buscarDNI = interfaz.solicitarEntradaUsuario("Ingrese el DNI del alumno a buscar");
				Alumno alumnoEncontrado = listaAlumnos.buscarAlumno(buscarDNI);

				if (alumnoEncontrado != null) {
					JOptionPane.showMessageDialog(null, "El alumno buscado es:\n " + alumnoEncontrado.getNombre());
				}
				break;
				
			case 3:
				// Ver Datos del Curso
				listaAlumnos.mostrarDatos();
				break;
				
			case 0:
				JOptionPane.showMessageDialog(null, "Saliendo de la aplicacion...");
				break;
				
			default:
				interfaz.mostrarError("Opcion no valida. Intentelo de nuevo.");
				break;
			}
			
		} while (opcion != 0);
	}
}
