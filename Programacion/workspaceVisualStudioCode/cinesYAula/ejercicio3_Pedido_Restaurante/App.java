package ejercicio3_Pedido_Restaurante;

public class App {
    

    public static void main(String[] args) {
        // Crear platos
        Plato primerPlato = new Plato("Ensalada", 8.50);
        Plato segundoPlato = new Plato("Lomo Saltado", 12.75);
        
        // Crear bebidas
        Bebida bebida1 = new Bebida("Gaseosa", 2.50);
        Bebida bebida2 = new Bebida("Jugo", 3.00);
        
        // Crear postres
        Postre postre = new Postre("Tiramisú", 5.00);
        
        // Crear pedidos y calcular valor
        Pedido pedido1 = new Pedido(primerPlato);
        Pedido pedido2 = new Pedido(primerPlato, segundoPlato, bebida2);
        Pedido pedido3 = new Pedido(primerPlato, segundoPlato, bebida1, postre);
        
        // Mostrar detalles de los pedidos y valor total
        System.out.println("Pedido 1:");
        System.out.println(pedido1.toString());
        System.out.println("-----------------------");
        
        System.out.println("Pedido 2:");
        System.out.println(pedido2.toString());
        System.out.println("-----------------------");
        
        System.out.println("Pedido 3:");
        System.out.println(pedido3.toString());
        System.out.println("-----------------------");
    }













}
