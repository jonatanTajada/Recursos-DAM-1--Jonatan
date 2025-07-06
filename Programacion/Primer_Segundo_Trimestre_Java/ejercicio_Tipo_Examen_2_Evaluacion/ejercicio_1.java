package ejercicio_Tipo_Examen_2_Evaluacion;


public class ejercicio_1 {

	
	public static void main(String[] args) {
		
		String frase = "En mi proxima vida, creere en la reencarnacion";
		
		int longitudFrase = frase.length();
		char caracterPosicion7 = frase.charAt(7);
		String fraseDesdeHasta = frase.substring(20, 27);
		int caracterX = frase.indexOf('x');
		String fraseMayus = frase.toUpperCase();
		
		
		System.out.println("Longitud de la cadena: " + longitudFrase);
		System.out.println("Caracter asociado al indice 7 es: " + caracterPosicion7);
		System.out.println("Subcadena: " + fraseDesdeHasta);
		System.out.println("Posicion del caracter 'x': " + caracterX);
		System.out.println("La cadena en mayusculas es: " + fraseMayus);

		if (frase.charAt(0) == 'E' || frase.charAt(0) == 'e') {
            System.out.println("La cadena empieza por: " + frase.charAt(0) );
        } else {
            System.out.println("El primer caracter no es 'E' ni 'e'.");
        }
		
		
	}
	
	
	
	
	
	
	
	
}
