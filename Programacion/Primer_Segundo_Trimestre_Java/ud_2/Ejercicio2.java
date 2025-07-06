package ud_2;

//Dada una variable entera x cuyo valor inicial es 5, y otra variable entera z cuyo valor inicial es 6,
//haz que se muestre la secuencia de resultados: true, false, true, false, true, y false (6 en total);
//usando un operador de relación diferente en cada caso.


public class Ejercicio2 {

	public static void main(String[] args) {
	
		int x = 5, z = 6;
		
		boolean resultado1 = (x == z);  
        System.out.println(resultado1); 

        boolean resultado2 = (x != z);  
        System.out.println(resultado2); 

        boolean resultado3 = (x < z);   
        System.out.println(resultado3); 

        boolean resultado4 = (x >= z);  
        System.out.println(resultado4); 

        boolean resultado5 = (x > z);   
        System.out.println(resultado5); 

        boolean resultado6 = (x <= z);  
        System.out.println(resultado6); 
		

	}

}
