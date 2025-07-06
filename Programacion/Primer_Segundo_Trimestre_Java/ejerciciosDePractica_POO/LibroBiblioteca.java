package ejerciciosDePractica_POO;

public class LibroBiblioteca {

	
	//Atributos
	private String titulo;
	private String autor;
	
	//Constructor
	public LibroBiblioteca(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	
	
	//setters and getters
	
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}
	
	
	@Override
	public String toString() {
		
		return "\nTitulo: " + titulo + "\nAutor: " + autor;
	}
	
	
	
}
