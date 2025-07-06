package ud_2;

public class NumAleatorio {

	
	
	public static void main(String[] args) {
		double d = Math.random() * 100;
        int numeroEntero = (int) d; // Convierte a entero eliminando la parte decimal

        boolean enRango1 = (numeroEntero >= 0 && numeroEntero < 20);
        boolean enRango2 = (numeroEntero >= 20 && numeroEntero <= 50);
        boolean enRango3 = (numeroEntero > 50 && numeroEntero < 75);
        boolean enRango4 = (numeroEntero >= 75 && numeroEntero <= 100);

        System.out.println("El número aleatorio generado es: " + numeroEntero);
        System.out.println("Está en el rango 0-20 (20 no incluido): " + (enRango1 ? "Sí" : "No"));
        System.out.println("Está en el rango 20-50 (ambos incluidos): " + (enRango2 ? "Sí" : "No"));
        System.out.println("Está en el rango 50-75 (ninguno incluido): " + (enRango3 ? "Sí" : "No"));
        System.out.println("Está en el rango 75-100 (ambos incluidos): " + (enRango4 ? "Sí" : "No"));
        
        
        
        String c1 = "jonatan";
        String c2 = "tajada";
        
        System.out.println(c1);
        
        
        
        
        
        
        
	}
	
	
	
}
