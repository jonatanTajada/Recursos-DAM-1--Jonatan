package ejerciciosDePractica_POO;

import java.util.Scanner;

public class LibroMaterialBibliografico extends MaterialBibliografico {
	
	Scanner scanner = new Scanner(System.in);

	//Atributos
	private String autor;
	
	
	//Constructor
	public LibroMaterialBibliografico(String titulo, String autor) {
		super(titulo);
		this.autor=autor;
	}


//	@Override
//	public double calcularPrestamo() {
//		int dias;
//		double precioPorDia = 1.50;
//		double importeTotal;
//		
//		System.out.print("\nIntroduce los dias que ha durado el prestamo del libro: ");
//		dias=scanner.nextInt();
//		
//		importeTotal = dias * precioPorDia;
//		
//		System.out.println("\nEl importe total es : " + importeTotal + "€." );
//		
//		return importeTotal;
//	}
	
	// Implementación del método abstracto
    @Override
    public double calcularPrecioPrestamo() {
        // Lógica para calcular el precio del préstamo de un libro
        return 2.5;
    }
	

	// toString
	
//	@Override
//	public String toString() {
//		double importeTotal = calcularPrestamo();
//		return super.toString() + "\nAutor: " + autor + importeTotal;
//	}
	
	
}
