import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coleccion coleccion = crearColeccionEjemplo(); // Crear una colección con figuras de ejemplo

        int opcion;
        do {
            System.out.println("\n=== Menu de Opciones ===");
            System.out.println("1. Mostrar coleccion");
            System.out.println("2. Subir precio de figura");
            System.out.println("3. Mostrar figuras con capa");
            System.out.println("4. Mostrar figura mas valiosa");
            System.out.println("5. Mostrar valor total de la coleccion");
            System.out.println("6. Mostrar volumen total de la coleccion");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n=== Coleccion ===");
                    System.out.println(coleccion);
                    break;
                case 2:
                    System.out.print("\nIngrese el codigo de la figura: ");
                    scanner.nextLine(); // Consumir el salto de línea
                    String codigoFigura = scanner.nextLine();
                    System.out.print("Ingrese la cantidad para subir el precio: ");
                    double cantidadSubir = scanner.nextDouble();
                    coleccion.subirPrecio(cantidadSubir, codigoFigura);
                    System.out.println("¡Precio actualizado!");
                    break;
                case 3:
                    System.out.println("\n=== Figuras con capa ===");
                    System.out.println(coleccion.conCapa());
                    break;
                case 4:
                    System.out.println("\n=== Figura mas valiosa ===");
                    System.out.println(coleccion.masValioso());
                    break;
                case 5:
                    System.out.println("\nValor total de la coleccion: " + coleccion.getValorColeccion());
                    break;
                case 6:
                    System.out.println("\nVolumen total de la coleccion: " + coleccion.getVolumenColeccion());
                    break;
                case 7:
                    System.out.println("¡Adios!");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    public static Coleccion crearColeccionEjemplo() {
        SuperHeroe batman = new SuperHeroe("Batman");
        batman.setDescripcion("Hombre murcielago");
        batman.setTieneCapa(true);

        SuperHeroe superman = new SuperHeroe("Superman");
        superman.setDescripcion("Hombre de acero");
        superman.setTieneCapa(true);

        Dimension dimensionBatman = new Dimension(10, 5, 3);
        Dimension dimensionSuperman = new Dimension(12, 6, 4);

        Figura figura1 = new Figura("BAT001", 25.0, batman, dimensionBatman);
        Figura figura2 = new Figura("SUP001", 30.0, superman, dimensionSuperman);

        Coleccion coleccion = new Coleccion("Heroes DC");
        coleccion.aniadirFigura(figura1);
        coleccion.aniadirFigura(figura2);

        return coleccion;
    }
}
