package ejerciciosExtrasPOO;

public class Libro {

	
	//Atributos
	
	private String tituloLibro;
	private String autor;
	private int numEjemplaresDisponibles; //ejemplares disponibles
	private int numEjemplaresPrestados;
	
	//Constructores
	
	public Libro() {}
	
	public Libro(String tituloLibro, String autor, int numEjemplaresDisponibles ) {
		this.tituloLibro = tituloLibro;
		this.autor = autor;
		this.numEjemplaresDisponibles = numEjemplaresDisponibles;
	}
	
	
	// Setters and Getters
	
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	
	public void setAutor (String autor){
		this.autor = autor;
	}
	
	public void setNumEjemplaresDisponibles(int numEjemplaresDisponibles) {
		this.numEjemplaresDisponibles= numEjemplaresDisponibles;
	}
	
	public void setNumEjemplaresPrestados(int numEjemplaresPrestados) {
		this.numEjemplaresPrestados = numEjemplaresPrestados;
	}
	
	public String getTituloLibro() {
		return tituloLibro;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getNumEjemplaresDisponibles() {
		return numEjemplaresDisponibles;
	}
	
	public int getNumEjemplaresPrestados() {
		return numEjemplaresDisponibles;
	}
	
	
	
	//Metodos
	
	public boolean prestamo() {
		
		if (numEjemplaresDisponibles > numEjemplaresPrestados) {
			numEjemplaresPrestados++;
			System.out.println("\nPrestamo realizado con exito! \nEjemplares prestados: " + numEjemplaresPrestados);
			return true;
		}else {
			 System.err.println("\nNo es posible prestarlo, estan todos los ejemplares prestados.");
		     return false;
		}
	}
	
	
	public boolean devolucion() {
		
		if (numEjemplaresPrestados > 0) {
			numEjemplaresPrestados--;
			 System.out.println("\nDevolucion realizado con exito! \nEjemplares prestados: " + numEjemplaresPrestados);
			return true;
		}else {
			System.err.println("\nNo es posible devolverlo, no hay ejemplares prestado.");
			return false;
		}
		
	}
	
	

	@Override
	public String toString() {
		
		return "\n***Libro***" + "\nTitulo del libro: " + tituloLibro + "\nAutor del libro: " + autor + "\nNumero de ejemplares disponibles: " + numEjemplaresDisponibles
				+ "\nNumero de ejemplares prestados: " + numEjemplaresPrestados;

	} 
	
	
	
}
