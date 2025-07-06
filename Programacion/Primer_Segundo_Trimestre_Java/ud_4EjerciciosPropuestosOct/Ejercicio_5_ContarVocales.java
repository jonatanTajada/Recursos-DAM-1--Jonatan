package ud_4EjerciciosPropuestosOct;

import java.util.Iterator;

public class Ejercicio_5_ContarVocales {

	
	public static void main(String[] args) {
		
		String frase = "La lluvia en Sevilla es una maravilla";
        int contadorVocales = 0;
        
        for (int i = 0; i < frase.length(); i++) {
        	
            //char caracter = frase.charAt(i);
            //char caracterEnMinusculas = Character.toLowerCase(caracter);
            char caracterEnMinusculas = Character.toLowerCase(frase.charAt(i));

            
            
            if (caracterEnMinusculas == 'a' || caracterEnMinusculas == 'e' || caracterEnMinusculas == 'i' || caracterEnMinusculas == 'o' || caracterEnMinusculas == 'u') {
                contadorVocales++;
            }
        }
        
        System.out.println("El número de vocales en la frase es: " + contadorVocales);
	
        
        //usando String
        
//        String frase = "La lluvia en Sevilla es una maravilla";
//        int contadorVocales = 0;
//        
//        for (int i = 0; i < frase.length(); i++) {
//            String letra = frase.substring(i, i + 1).toLowerCase(); // Convierte la letra a minúsculas
//            if ("aeiou".contains(letra)) {
//                contadorVocales++;
//            }
//        }
//        
//        System.out.println("El número de vocales en la frase es: " + contadorVocales);
//    }
        
        
        
        
        
        
        
        
        
        
	}
	
	
}
