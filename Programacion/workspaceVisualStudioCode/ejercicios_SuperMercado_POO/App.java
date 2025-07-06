package ejercicios_SuperMercado_POO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Crear listaProductos
        Vino vino = new Vino("Vino1", 15.99, "Tinto", 12.5);
        vino.setVolumen(750);
        vino.setDescuento(10);
        vino.setTipoEnvase("Botella de vidrio");

        Detergente detergente = new Detergente("Detergente1", 3.99, 1000, "Botella", 5);

        Cereal cereal = new Cereal("Cereal1", 2.49, "maiz");
        cereal.setCaducidad(LocalDate.of(2025, 6, 30));

        // Crear  lista de listaProductos
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(vino);
        listaProductos.add(detergente);
        listaProductos.add(cereal);

        // Mostrar información de los listaProductos
        for (Producto producto : listaProductos) {
            System.out.println("\nInformacion del producto:");
            System.out.println(producto);
        }

        // Calcular precio con descuento del vino
        System.out.println("\nPrecio del vino con descuento: " + vino.getPrecioDescuento());

        // Calcular las calorías del cereal
        System.out.println("Calorias del cereal: " + cereal.getCalorias());

        // Prueba de la interfaz EsAlimento (métodos set y get de caducidad)
        System.out.println("\nPrueba de la interfaz EsAlimento:");
        LocalDate nuevaCaducidad = LocalDate.of(2026, 12, 31);
        cereal.setCaducidad(nuevaCaducidad);
        System.out.println("Nueva fecha de caducidad del cereal: " + cereal.getCaducidad());

        // Prueba de la interfaz EsLiquido (métodos set y get de volumen y tipo de envase)
        System.out.println("\nPrueba de la interfaz EsLiquido:");
        vino.setVolumen(500);
        vino.setTipoEnvase("Botella de plastico");
        System.out.println("Nuevo volumen del vino: " + vino.getVolumen() + " ml");
        System.out.println("Nuevo tipo de envase del vino: " + vino.getTipoEnvase());

        // Calcular la suma de calorías de los listaProductos alimenticios
        int sumaCalorias = 0;
        for (Producto producto : listaProductos) {
            if (producto instanceof EsAlimento) {
                EsAlimento alimento = (EsAlimento) producto;
                sumaCalorias += alimento.getCalorias();
            }
        }

        // Mostrar la suma de calorías
        System.out.println("\nSuma total de calorias de los listaProductos alimenticios: " + sumaCalorias + " calorias");
    }
}
