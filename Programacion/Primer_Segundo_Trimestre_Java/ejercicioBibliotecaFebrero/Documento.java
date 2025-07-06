package ejercicioBibliotecaFebrero;

public class Documento {


	//atributos
	private String codigo;
	private String titulo;
	 private boolean prestado;
	
	//constructor
	public Documento(String codigo, String titulo) {
		this.codigo=codigo;
		this.titulo=titulo;
	}

	//getters and setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public boolean getPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	@Override
	public String toString() {
		return "\nCodigo: " + this.codigo + "\nTitulo: " + this.titulo + "\nPrestado: " + this.prestado;
	}

}
