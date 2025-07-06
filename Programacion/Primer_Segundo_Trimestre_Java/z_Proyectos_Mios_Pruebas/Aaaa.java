package z_Proyectos_Mios_Pruebas;

public class Aaaa {

	public class LanzaExcepciones {
	    private static final int CASO;

	    public static class MiExcepción extends Exception {}

	    public static class MiRuntimeExcepción extends RuntimeException {}

	    private static void método3(int caso) throws MiExcepción, MiRuntimeExcepción {
	        switch (caso) {
	            case 0:
	                throw new MiExcepción();
	            case 1:
	                throw new MiRuntimeExcepción();
	        }
	    }

	    private static int método2() throws MiExcepción, MiRuntimeExcepción {
	        int ret = 1;
	        try {
	            System.out.println("2:antes");
	            método3(CASO);
	            System.out.println("2:después");
	            return 2;
	        } catch (RuntimeException e) {
	            System.out.println("2:catch");

	        } finally {
	            System.out.println("2:finally");
	        }
	        System.out.println("2:final");
	        return ret;
	    }

	    private static int método1() throws MiExcepción, MiRuntimeExcepción {
	        int ret = 0;
	        try {
	            System.out.println("1:antes");
	            ret = método2();
	            System.out.println("1:después");
	        } catch (MiExcepción e) {
	            System.out.println("1:catch");
	        }
	        System.out.println("1:final");
	        return ret;
	    }

	    public static void main(String[] args) {
	        System.out.println("main:antes");
	        int ret = 0;
	        try {
	            ret = método1();
	        } catch (MiExcepción | MiRuntimeExcepción e) {
	            // Manejo de excepciones en el método main
	        }
	        System.out.println("main:después. ret:" + ret);
	    }
	}

	
//---------------------------------------------------------------------------------------------------------------------------	
//								Teoria Excepciones
//---------------------------------------------------------------------------------------------------------------------------
	
	
//	En Java, las excepciones se dividen en dos categorías principales: excepciones verificadas (checked exceptions) y 
//	excepciones no verificadas (unchecked exceptions). Además, todas las excepciones de tiempo de ejecución (runtime exceptions) 
//	son automáticamente no verificadas.
//
//	Excepciones Verificadas (Checked Exceptions):
//
//	Estas son excepciones que el compilador de Java requiere que el programador maneje explícitamente mediante el uso de 
//	bloques try-catch o declarando que el método puede lanzar dichas excepciones.
//	Se derivan directamente de la clase Exception (que no es RuntimeException).
//	Ejemplos comunes incluyen IOException, SQLException, y cualquier excepción personalizada que herede de Exception pero no de
//	RuntimeException.
//	Excepciones No Verificadas (Unchecked Exceptions):
//
//	Estas son excepciones que el compilador de Java no requiere manejar explícitamente. El programador tiene la opción de manejarlas o no.
//	Se derivan directamente de la clase RuntimeException o de sus subclases.
//	Ejemplos comunes incluyen NullPointerException, ArrayIndexOutOfBoundsException, y cualquier excepción personalizada que herede 
//	de RuntimeException.
//	Excepciones de Tiempo de Ejecución (Runtime Exceptions):
//
//	Todas las excepciones que heredan de la clase RuntimeException o sus subclases son consideradas excepciones de tiempo de ejecución.
//	Estas excepciones no verificadas son aquellas que ocurren durante la ejecución del programa y no necesitan ser manejadas de manera 
//	explícita.
//	Ejemplos comunes incluyen ArithmeticException, ClassCastException, IllegalArgumentException, y cualquier excepción personalizada 
//	que herede de RuntimeException.
//	Ejemplos:
//
//	Excepción Verificada:
//
//	
//	
//	try {
//	    // Código que puede lanzar una IOException
//	} catch (IOException e) {
//	    // Manejo de la excepción
//	}
//	Excepción No Verificada:
//
//	
//	
//	int[] array = {1, 2, 3};
//	System.out.println(array[5]); // Esto lanzará ArrayIndexOutOfBoundsException, una excepción no verificada
//	Excepción de Tiempo de Ejecución:
//
//	java
//	Copy code
//	int resultado = 5 / 0; // Esto lanzará ArithmeticException, una excepción de tiempo de ejecución
//	En resumen, las excepciones verificadas deben ser manejadas explícitamente, mientras que las excepciones no verificadas
//	y las de tiempo de ejecución no requieren ser manejadas, aunque es una buena práctica hacerlo para mejorar la robustez del código.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
