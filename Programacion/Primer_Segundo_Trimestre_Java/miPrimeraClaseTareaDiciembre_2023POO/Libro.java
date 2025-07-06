package miPrimeraClaseTareaDiciembre_2023POO;

public class Libro {

	// Atributos
    private String titulo;
    private String autor;
    private int ejemplares;
    private int prestados;

    // Constructores
    public Libro() {
        // Constructor por defecto
    }

    public Libro(String titulo, String autor, int ejemplares) {
        // Constructor con parámetros
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
        this.prestados = 0; // Inicialmente, no hay libros prestados
    }

    // Métodos Setters/getters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    // Método préstamo
    public boolean prestamo() {
        if (ejemplares > 0) {
            ejemplares--;
            prestados++;
            return true; // Préstamo exitoso
        } else {
            return false; // No hay ejemplares disponibles para préstamo
        }
    }

    // Método devolución
    public boolean devolucion() {
        if (prestados > 0) {
            ejemplares++;
            prestados--;
            return true; // Devolución exitosa
        } else {
            return false; // No hay libros prestados para devolver
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor +
                "\nEjemplares disponibles: " + ejemplares + "\nEjemplares prestados: " + prestados;
    }

    public static void main(String[] args) {
    	
      
        Libro libro1 = new Libro("Java Programming", "John Doe", 10);

        // Mostrar información inicial
        System.out.println("Información inicial del libro:");
        System.out.println(libro1);

        // Realizar un préstamo
        if (libro1.prestamo()) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No hay ejemplares disponibles para préstamo.");
        }

        
        // Mostrar información después del préstamo
        System.out.println("\nInformación después del préstamo:");
        System.out.println(libro1);

       
        if (libro1.devolucion()) {
            System.out.println("Devolución realizada con éxito.");
        } else {
            System.out.println("No hay libros prestados para devolver.");
        }

        
        
        System.out.println("\nInformación después de la devolución:");
        System.out.println(libro1);
    }
	
}
