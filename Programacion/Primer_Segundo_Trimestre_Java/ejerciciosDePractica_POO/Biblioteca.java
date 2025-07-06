package ejerciciosDePractica_POO;

import java.util.ArrayList;

public class Biblioteca {

	ArrayList<LibroBiblioteca> coleccionLibros;
	
	//Constructor
	
	public Biblioteca() {
		coleccionLibros = new ArrayList<LibroBiblioteca>();
	}
	
	
	
	public void agregarLibro(LibroBiblioteca libro) {
		coleccionLibros.add(libro);
	}
	
	
	public void mostrarLibros() {
		System.out.println("\nLista de libros en la biblioteca: ");
		
		for (LibroBiblioteca libro : coleccionLibros) {
			System.out.println("- " + libro.getTitulo() + " por " + libro.getAutor() + ".");
		}
		System.out.println();
	}
	
	
	public LibroBiblioteca buscarLibroPorTitulo(String titulo) {
		
		for (LibroBiblioteca libro : coleccionLibros) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				return libro;
			}
		}
		return null;
	}
	
}
