package ejercicio3_Pedido_Restaurante;

import java.util.Scanner;

public class AppConMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear platos
        Plato primerPlato = new Plato("Ensalada", 8.50);
        Plato segundoPlato = new Plato("Lomo Saltado", 12.75);

        // Crear bebidas
        Bebida bebida1 = new Bebida("Gaseosa", 2.50);
        Bebida bebida2 = new Bebida("Jugo", 3.00);

        // Crear postres
        Postre postre = new Postre("Tiramisú", 5.00);

        System.out.println("¡Bienvenido al restaurante!");
        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Hacer un pedido");
            System.out.println("2. Salir");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    Pedido pedido = crearPedido(scanner, primerPlato, segundoPlato, bebida1, bebida2, postre);
                    if (pedido != null) {
                        System.out.println("Detalles del pedido:");
                        System.out.println(pedido.toString());
                    }
                    break;
                case 2:
                    System.out.println("¡Gracias por visitar nuestro restaurante!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
            }
        }
        scanner.close();
    }

    private static Pedido crearPedido(Scanner scanner, Plato primerPlato, Plato segundoPlato,
                                      Bebida bebida1, Bebida bebida2, Postre postre) {
        System.out.println("Seleccione el tipo de pedido:");
        System.out.println("1. Primer plato solo");
        System.out.println("2. Segundo plato solo");
        System.out.println("3. Postre solo");
        System.out.println("4. Bebida solo");
        System.out.println("5. Primer plato y bebida");
        System.out.println("6. Segundo plato, bebida y postre");
        int tipoPedido = Integer.parseInt(scanner.nextLine());

        switch (tipoPedido) {
            case 1:
                return new Pedido(primerPlato);
            case 2:
                return new Pedido(segundoPlato);
            case 3:
                return new Pedido(postre);
            case 4:
                return new Pedido(bebida1);
            case 5:
                return new Pedido(primerPlato, bebida1);
            case 6:
                return new Pedido(primerPlato, segundoPlato, bebida1, postre);
            default:
                System.out.println("Tipo de pedido no válido.");
                return null;
        }
    }
}
