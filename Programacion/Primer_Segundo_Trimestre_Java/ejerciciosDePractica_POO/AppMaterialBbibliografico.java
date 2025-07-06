package ejerciciosDePractica_POO;

public class AppMaterialBbibliografico {

    public static void main(String[] args) {
    	
    	// Crear una biblioteca
        Biblioteca_Material_Bibliografico miBiblioteca = new Biblioteca_Material_Bibliografico();

        // Agregar materiales a la biblioteca
        MaterialBibliografico libro = new LibroMaterialBibliografico("El Principito", "Antoine de Saint-Exupéry");
        MaterialBibliografico dvd = new DVDMaterialBibliografico("Inception", "Christopher Nolan");

        miBiblioteca.agregarMaterial(libro);
        miBiblioteca.agregarMaterial(dvd);

        // Obtener la lista de materiales y recorrerla
        for (MaterialBibliografico material : miBiblioteca.getMateriales()) {
            System.out.println(material.toString());
        }
    }
}

