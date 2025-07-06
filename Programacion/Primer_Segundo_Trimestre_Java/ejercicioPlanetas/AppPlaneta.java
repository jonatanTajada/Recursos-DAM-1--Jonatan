package ejercicioPlanetas;
//main de Planeta

public class AppPlaneta {

	
	public static void main(String[] args) {
		
		
		// Crear planetas : 2.
		
        Planeta planeta1 = new Planeta("Tierra", 1, 5.972 * Math.pow(10, 24), 1.08321 * Math.pow(10, 12), 12742, 320, TipoPlaneta.TERRESTRE, true, 2, 730);
                																
        Planeta planeta2 = new Planeta("Júpiter", 79, 1.898 * Math.pow(10, 27),   1.43128 * Math.pow(10, 15), 139820, 778, TipoPlaneta.GASEOSO, false, 1,365);
              

        // Mostrar información de los planetas
        
        System.out.println("Información del Planeta 1:");
        planeta1.imprimirInformacion();
        System.out.println("\nDensidad del Planeta 1: " + planeta1.calcularDensidad() + " kg/km^3");
        System.out.println("Se considera Planeta Exterior: " + (planeta1.esPlanetaExterior() ? "Sí" : "No"));
        
        System.out.println("\n*********************************************************************************************");
        
        System.out.println("\nInformación del Planeta 2:");
        planeta2.imprimirInformacion();
        System.out.println("\nDensidad del Planeta 2: " + planeta2.calcularDensidad() + " kg/km^3");
        System.out.println("Se considera Planeta Exterior:  " + (planeta2.esPlanetaExterior() ? "Sí" : "No"));
		
		
		
	}
	
	
}
