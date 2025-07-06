package ud_2;

import java.util.Scanner;

public class CondicionalTernario {

	public static void main(String[] args) {
		
		 Scanner teclado = new Scanner( System.in );
		 
	        int x, y; 
	        String cadena; 
	        boolean resultado;
	        
	        System.out.print( "Introducir primer número: " );
	        x = teclado.nextInt(); 
	        
	        System.out.print( "Introducir segundo número: " );
	        y = teclado.nextInt();
	        
	        cadena = (x==y) ? "iguales":"distintos";
	        
	        System.out.printf("Los números %d y %d son %s\n",x,y,cadena);
	        
	        
	        
	        resultado = (x!=y);
	        System.out.println("x != y // es " + resultado);
	        
	        resultado = (x < y );
	        System.out.println("x < y // es " + resultado);
	        
	        resultado = (x > y );
	        System.out.println("x > y // es " + resultado);
	        
	        resultado = (x <= y );
	        System.out.println("x <= y // es " + resultado);
	        
	        resultado = (x >= y );
	        System.out.println("x >= y // es " + resultado);
		
	}
	
	
}
