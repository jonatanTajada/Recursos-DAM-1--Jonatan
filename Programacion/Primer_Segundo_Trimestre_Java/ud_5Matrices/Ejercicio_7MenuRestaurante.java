package ud_5Matrices;

import java.util.Scanner;

public class Ejercicio_7MenuRestaurante {

	public static void main(String[] args) {
		
		
        Scanner scanner = new Scanner(System.in);
        
        int numeroDeMenus = 3;
        int numeroComensales;
        
        do {
  
        	mostrarMenu1();
        	mostrarMenu2();
        	mostrarMenu3();
        	System.out.println("***********************************************************************************************");
        	
        	System.out.print("\nIntroduce el número de comensales (1-5): ");
            numeroComensales = scanner.nextInt();

            if (numeroComensales < 1 || numeroComensales > 5) {
                System.err.println("Error: el número de comensales debe estar entre 1 y 5.");
            }
		} while (numeroComensales < 1 || numeroComensales > 5);

        int arrayRegistroDecisionMenuComensales[] = new int[numeroComensales];
        String continuar;

        do {
        	
            for (int i = 0; i < numeroComensales; i++) {
                int opcionMenu; 

                do {
                    System.out.println("\nComensal #" + (i + 1) + ":");
                    System.out.println("Menús disponibles: 1, 2, 3");
                    System.out.print("Elija el menú para el comensal " + (i + 1) + ": ");
                    opcionMenu = scanner.nextInt();
                    
                    System.out.println();
                    
                    if (opcionMenu < 1 || opcionMenu > numeroDeMenus) {
                        System.err.println("Error: el menú debe ser 1, 2 o 3.");
                    } else {
                        arrayRegistroDecisionMenuComensales[i] = opcionMenu;
                    }
                } while (opcionMenu < 1 || opcionMenu > numeroDeMenus);
            }

            System.out.print("\nQuieres ver los menus seleccionados por los comensales? (si/no): ");
            String respuesta = scanner.next();
            
            if (respuesta.equalsIgnoreCase("si")) {
				imprimirMenusSeleccionados(arrayRegistroDecisionMenuComensales);
			}
            
            System.out.print("¿Deseas volver al programa? (si/no): ");
            continuar = scanner.next();
        } while (continuar.equalsIgnoreCase("si"));


        scanner.close();
    }
	
	//METODOS
	public static void imprimirMenusSeleccionados(int[] arrayRegistroDecisionMenuComensales) {
	    System.out.println("\nMenús seleccionados por los comensales:");
	    for (int i = 0; i < arrayRegistroDecisionMenuComensales.length; i++) {
	        System.out.println("Comensal " + (i + 1) + ": - Menú " + arrayRegistroDecisionMenuComensales[i]);
	    }
	}

	
	public static void mostrarMenu1() {
		System.out.println("		\n***MENU 1***");
    	System.out.println("1º Plato: Lentejas" + "\n2º Plato: Chuleta" + "\nPostre: Flan " + "\nPan y vino y/o agua");
	}

	public static void mostrarMenu2() {
		System.out.println("		\n***MENU 2***");
		System.out.println("1º Plato: Pure de verduras" + "\n2º Plato: Salmon" + "\nPostre: Yogurth " + "\nPan y vino y/o agua");
	}
	
	public static void mostrarMenu3() {
		System.out.println("		\n***MENU 3***");
    	System.out.println("1º Plato: Lasaña" + "\n2º Plato: Merluza" + "\nPostre: Helado	 " + "\nPan y vino y/o agua");
	}
	
}
