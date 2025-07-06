package ejercicioGestionarListaAlumnos;

import javax.swing.JOptionPane;

public class InterfazGrafica {
	
	public void mostrarMenu() {
		JOptionPane.showMessageDialog(null,"1. Añadir Alumno\n2. Buscar Alumno por DNI \n3. Ver Datos del Curso \n0. Salir");
	}

	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, "Error: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public String solicitarEntradaUsuario(String mensaje) {
	    return JOptionPane.showInputDialog(null, mensaje);
	}
}
