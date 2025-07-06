package ud_1;

import java.util.Scanner;

public class CocinarPasta {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("¡Bienvenido a la receta de pasta!");
        
        System.out.print("Elige el tipo de pasta (ej. espaguetis): ");
        String tipoPasta = scanner.nextLine();
        
        System.out.print("Elige la salsa (ej. salsa de tomate): ");
        String salsa = scanner.nextLine();
        
        System.out.println("Ingredientes:");
        System.out.println("- " + tipoPasta);
        System.out.println("- Agua");
        System.out.println("- Sal");
        System.out.println("- " + salsa);
        System.out.println("- Aceite de oliva");
        System.out.println("- Especias y condimentos al gusto");
        
        System.out.println("\nProceso de cocción:");
        System.out.println("1. Llena una olla grande con agua y colócala en la estufa a fuego alto.");
        System.out.println("2. Añade una pizca de sal al agua.");
        System.out.println("3. Cuando el agua esté hirviendo, añade " + tipoPasta + ".");
        System.out.println("4. Sigue las instrucciones del paquete para conocer el tiempo de cocción.");
        System.out.println("5. Mientras la pasta se cocina, calienta la " + salsa + " en una sartén a fuego medio-bajo.");
        System.out.println("6. Revuelve ocasionalmente la salsa.");
        System.out.println("7. Cuando la pasta esté cocida al dente, escúrrela.");
        System.out.println("8. Añade una pequeña cantidad de aceite de oliva y mézclala.");
        System.out.println("9. Sirve la pasta en un plato y agrega la salsa caliente por encima.");
        System.out.println("10. Opcionalmente, espolvorea queso rallado y agrega especias al gusto.");
        System.out.println("11. ¡Listo para disfrutar!");
        
      
        scanner.close();
    }
}

