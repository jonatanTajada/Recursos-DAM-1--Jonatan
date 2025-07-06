package ejercicioBibliotecaFebrero;

public class Libro extends Documento{


	//atributos
	private int anioPublicacion;
	
	//constructor
	public Libro(String codigo, String titulo, int anioPublicacion) {
		super(codigo, titulo);
		this.anioPublicacion = anioPublicacion;
	}

	//setters and getters
	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	
	@Override
	public String toString() {
		return "\n-Datos del libro:\n" + "Codigo libro:" + super.getCodigo() + "\nTitulo libro: " + super.getTitulo()
				+ "\nAño publicacion: " + this.anioPublicacion;
	}
	

}
