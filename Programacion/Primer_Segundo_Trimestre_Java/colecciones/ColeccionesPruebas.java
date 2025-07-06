package colecciones;


import java.util.Objects;
import java.util.ArrayList;

public class ColeccionesPruebas {
	
    public static void main(String[] args) {
        // Crear un ArrayList de libros
        ArrayList<Libro> listaLibros = new ArrayList<>();

      
        listaLibros.add(new Libro("El Gran Gatsby", "F. Scott Fitzgerald", "24/09/1896", 128));
        listaLibros.add(new Libro("1984", "George Orwell", "25/06/1903", 46));

        
        // Convertir el ArrayList a un array normal
        Libro[] arrayLibros = listaLibros.toArray(new Libro[0]);

        // Imprimir los libros del array
        for (Libro libro : arrayLibros) {
            System.out.println(libro);
        }
        
        
        
        //admite valores duplicados porque es uso un arrayList de la interface List
        Libro libro1 = new Libro("P aen java", "10/02/2014", "Jonatan Tajada", 35);
        Libro libro2 = new Libro("P en java", "10/02/2014", "Jonatan Tajada", 35);
        
       
   //aui sobre escribo el metodo equals segun mis necesidades
        if (libro1.equals(libro2)) {
			System.out.println("son iguales");
			System.out.println("HashCode libro 1: " + libro1.hashCode());
			System.out.println("HashCode libro 2: " +libro2.hashCode());
		}else {
			System.err.println("no son iguales");
			
			//el codigo hashCode de cada objeto,, memoria de Heap
			System.out.println("HashCode libro 1: " + libro1.hashCode());
			System.out.println("HashCode libro 2: " +libro2.hashCode());
		}
        
        
        
        
        
        
    }
    
  

    
}


//-------------------------------------------------------------------------

class Libro {
	
    private String titulo;
    private String autor;
    private String fechaNacimientoAutor;
    private int edad;

    // Constructor
    public Libro(String titulo, String autor, String fechaNacimientoAutor, int edad) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaNacimientoAutor = fechaNacimientoAutor;
        this.edad = edad;
    }

    // Método toString para imprimir los detalles del libro
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaNacimientoAutor='" + fechaNacimientoAutor + '\'' +
                ", edad=" + edad +
                '}';
    }

	@Override
	
	
	//hecho con el source ...
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(titulo, other.titulo);
	}


    
    //sobreescribir metodo si son iguales segun titulo y no referencia hecho de manera manual
//	public boolean equals(Object obj) {
//
//		if (obj instanceof Libro) {
//			Libro otro = (Libro) obj;
//
//			if (this.titulo == otro.titulo) {
//				return true;
//			} else {
//				return false;
//			}
//
//		} else {
//			return false;
//		}
//
//	}
//    
    
    
    
    
    
}

