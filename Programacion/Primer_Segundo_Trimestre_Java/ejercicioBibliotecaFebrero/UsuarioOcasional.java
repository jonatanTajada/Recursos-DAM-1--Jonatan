package ejercicioBibliotecaFebrero;

public class UsuarioOcasional extends Usuario{

	public UsuarioOcasional(String dni, String nombre) {
		
		super(dni, nombre,2); // 3º argumento es la cantidad de prestamos maxima de documentos que puede tener a la vez
		
	}

	
	@Override
	public String toString() {
		return "\n-Datos del usuario ocasional:\nD.N.I.: " + super.getDni() + "\nNomrbe: " + super.getNombre()
		 + "\nPrestamos maximos simultaneos: " + super.getPrestamosMaximosSimultaneos();
	}
	
	
}
