package ejerciciosDePractica_POO;

import java.util.Scanner;

public class DVDMaterialBibliografico extends MaterialBibliografico {

	Scanner scanner = new Scanner(System.in);
	
	// Atributo adicional
    private String director;

    // Constructor
    public DVDMaterialBibliografico(String titulo, String director) {
        super(titulo);
        this.director = director;
    }

    // Implementación del método abstracto
    @Override
    public double calcularPrecioPrestamo() {
        // Lógica para calcular el precio del préstamo de un DVD
        return 3.0;
    }

	//Metodos
	
	
//	@Override
//	public double calcularPrestamo() {
//		
//		int diasPrestados;
//		double precioDVDPorDia = 2.5; 
//		double resultado;
//		
//		System.out.print("\nIntroduce los dias prestados del DVD: ");
//		diasPrestados = scanner.nextInt();
//		
//		resultado = diasPrestados * precioDVDPorDia;
//		
//		System.out.println("\nEl importe por el alquiler del DVD es: " + resultado + "€.");
//		
//		return resultado;
//	}
	
	// toString
	
//	@Override
//	public String toString() {
//		double importeTotal = calcularPrestamo();
//		return super.toString() + "\nDirector: " + director + importeTotal;
//	}

}
