package ejercicioBibliotecaFebrero;

public class Revista extends Documento {

	
	
	
	public Revista(String codigo, String titulo) {
		super(codigo, titulo);
	}
	
	@Override
	public String toString() {
		return "\n-Datos de la revista:\n" + "Codigo revista:" + super.getCodigo() + "\nTitulo revista: " + super.getTitulo();
	}

	

}
