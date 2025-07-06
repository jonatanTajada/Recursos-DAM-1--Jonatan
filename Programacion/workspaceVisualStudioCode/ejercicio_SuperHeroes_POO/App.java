public class App {

    public static void main(String[] args) {

        // Crear Superheroes
        SuperHeroe batman = new SuperHeroe("Batman");
        batman.setDescripcion("Hombre murcielago");
        batman.setTieneCapa(true);

        SuperHeroe superman = new SuperHeroe("Superman");
        superman.setDescripcion("Hombre de acero");
        superman.setTieneCapa(true);

        // Crear Dimensiones
        Dimension dimensionBatman = new Dimension(10, 5, 3);
        Dimension dimensionSuperman = new Dimension(12, 6, 4);

        // Crear Figuras
        Figura figura1 = new Figura("BAT001", 25.0, batman, dimensionBatman);
        Figura figura2 = new Figura("SUP001", 30.0, superman, dimensionSuperman);
        

        // Crear Coleccion
        Coleccion coleccionHeroesDC = new Coleccion("Heroes DC");

        // Añadir Figuras a la Coleccion
        coleccionHeroesDC.aniadirFigura(figura1);
        coleccionHeroesDC.aniadirFigura(figura2);

        // Mostrar Colección
        System.out.println("=== Coleccion ===");
        System.out.println(coleccionHeroesDC);

        // Subir precio de una figura
        coleccionHeroesDC.subirPrecio(5.0, "BAT001");

        // Mostrar colección despues de subir precio
        System.out.println("\n=== Coleccion despues de subir precio ===");
        System.out.println(coleccionHeroesDC);

        // Mostrar figuras con capa
        System.out.println("\n=== Figuras con capa ===");
        System.out.println(coleccionHeroesDC.conCapa());

        // Mostrar figura mas valiosa
        System.out.println("\n=== Figura mas valiosa ===");
        System.out.println(coleccionHeroesDC.masValioso());

        // Mostrar valor total de la coleccion
        System.out.println("\nValor total de la coleccion: " + coleccionHeroesDC.getValorColeccion());

        // Mostrar volumen total de la coleccion
        System.out.println("Volumen total de la coleccion: " + coleccionHeroesDC.getVolumenColeccion());
    }

}


