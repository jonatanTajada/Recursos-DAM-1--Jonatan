package ejerciciosArrays7Nov;

public class ejercicio_1_MostrarPalabraMasLarga {

	 public static void main(String[] args) {
	        
	        String[] arrayCadenas = {"Hola", "Adiós", "Java", "Programación"};
	        
	        String cadenaMasLarga = obtenerCadenaMasLarga(arrayCadenas);
	        
	        System.out.println("La cadena más larga es: " + cadenaMasLarga);
	    }

	    public static String obtenerCadenaMasLarga(String[] arrayCadenas) {
	    	
	        if (arrayCadenas == null || arrayCadenas.length == 0) {
	            return "El array esta vacio o es nulo";
	        }

	        String palabraMasLarga = arrayCadenas[0]; 

	        for (int i = 1; i < arrayCadenas.length; i++) {
	        	
	            if (arrayCadenas[i].length() > palabraMasLarga.length()) {
	            	palabraMasLarga = arrayCadenas[i];
	            }
	        }

	        return palabraMasLarga;
	    }
	
	
	
	
	
}
