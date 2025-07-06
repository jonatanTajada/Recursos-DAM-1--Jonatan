package ejerciciosDePractica_POO;

public class AppBiblioteca {

	
	
	
	
	public static void main(String[] args) {
		
		LibroBiblioteca libro1 = new LibroBiblioteca("Programando Java", "Jonatan Tajada");
		LibroBiblioteca libro2 = new LibroBiblioteca("Aprendiendo con Eclipse", "Bill Gates");
		
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.agregarLibro(libro2);
		biblioteca.agregarLibro(libro1);
		
		biblioteca.mostrarLibros();
		
		//Buscar un libro por su titulo
		
		String tituloABuscar = "Programando Java";
		LibroBiblioteca libroEncontrado = biblioteca.buscarLibroPorTitulo(tituloABuscar);
		
		if (libroEncontrado != null) {
			System.out.println("\nSe encontró el libro: " + libroEncontrado);
		}else {
			System.err.println("\nLibro no encontrado.");
		}
		
	}
	
	
	
	
	
}
