package ejercicioBibliotecaFebrero;

public class Socio extends Usuario {

	
	
	
	public Socio(String dni, String nombre) {
		super(dni, nombre,20); // 3º argumento es la cantidad de prestamos maxima de documentos que puede tener a la vez
	}

	

	@Override
	public String toString() {
	    return "\n-Datos del socio:\nD.N.I.: " + super.getDni() + "\nNombre: " + super.getNombre() 
	            + "\nPrestamos maximos simultaneos: " + super.getPrestamosMaximosSimultaneos();
	}

	

}
