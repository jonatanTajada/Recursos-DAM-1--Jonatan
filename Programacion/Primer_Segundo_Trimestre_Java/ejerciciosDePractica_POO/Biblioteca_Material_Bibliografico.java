package ejerciciosDePractica_POO;

import java.util.ArrayList;

public class Biblioteca_Material_Bibliografico {
	
	//Atributo
    private ArrayList<MaterialBibliografico> materiales;

    // Constructor
    public Biblioteca_Material_Bibliografico() {
        this.materiales = new ArrayList<>();
    }

    // Método para agregar un material a la biblioteca
    public void agregarMaterial(MaterialBibliografico material) {
        materiales.add(material);
    }

    // Método para calcular el total de préstamos en la biblioteca
    public double calcularTotalPrestamo() {
        double totalPrestamo = 0.0;
        for (MaterialBibliografico material : materiales) {
            totalPrestamo += material.calcularPrecioPrestamo();
        }
        return totalPrestamo;
    }

    // Método para mostrar la información de todos los materiales en la biblioteca
//    public void mostrarInformacionMateriales() {
//        for (MaterialBibliografico material : materiales) {
//            System.out.println(material.toString());
//        }
//    }
    
    
 // Método para mostrar la información de los materiales en la biblioteca
    public void mostrarInformacionMateriales(boolean mostrarDetalles) {
        for (MaterialBibliografico material : materiales) {
            if (mostrarDetalles) {
                System.out.println(material.toString());
            } else {
                System.out.println(material.getTitulo());
            }
        }
    }
    
 // Método para obtener la lista de materiales
    public ArrayList<MaterialBibliografico> getMateriales() {
        return materiales;
    }

    
}
