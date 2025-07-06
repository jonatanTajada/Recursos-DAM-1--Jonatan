package ejerciciosExtrasPOO;

public class LibroApp {

	//se trata de ver si es posible alquilar un libro
	// si hay disponibilidad de ese ejemplar sera posible y si no es asi, no sera posible
	
	
	public static void main(String[] args) {
		
		Libro aprenderAProgramar =  new Libro("Aprende a programar", "Jonatan Tajada", 6);
		
		//System.out.println(aprenderAProgramar);
		
		
		//Prueba de prestamo
		
		System.out.println(aprenderAProgramar.prestamo());
		System.out.println(aprenderAProgramar);
		
		//Prueba de devolucion
		  
		System.out.println(aprenderAProgramar.devolucion());
		System.out.println(aprenderAProgramar);
		
		
		//Intentar prestar un libro sin ejemplares
		for (int i = 0; i < 8; i++) {
			System.out.println("-------");
			System.out.println(aprenderAProgramar.prestamo());
		}
		
		System.out.println(aprenderAProgramar);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
