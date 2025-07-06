package ejerciciosDePractica_POO;

public abstract class MaterialBibliografico implements Prestable {

	
	// Atributo
    private String titulo;

    // Constructor
    public MaterialBibliografico(String titulo) {
        this.titulo = titulo;
    }

    // Métodos abstractos
    public abstract double calcularPrecioPrestamo();
    
    
    
    
    

    public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	// Implementación de la interfaz Prestable
    @Override
    public void prestar() {
        System.out.println("Préstamo de " + titulo);
    }

    @Override
    public void devolver() {
        System.out.println("Devolución de " + titulo);
    }
	
}
