package ejercicioEjemplosUsoDeInterfaces;


//esto es un ejercicio de EDE....ejercicio varios diagramas


public class EjercicioVariosDiagramas {

	
	// 1.	Implementacion de interfaz
	//------------------------------------------------------
	
	// Interfaz
//	public interface MiInterfaz {
//	    void metodoInterfaz();
//	}
//
//	// Clase que implementa la interfaz
//	public class MiClase implements MiInterfaz {
//	    @Override
//	    public void metodoInterfaz() {
//	        System.out.println("Implementación del método de la interfaz");
//	    }
//
//	    // Método adicional de la clase
//	    public void otroMetodo() {
//	        System.out.println("Otro método de la clase");
//	    }
//
//	    // Ejemplo de uso
//	    public static void main(String[] args) {
//	        MiClase miObjeto = new MiClase();
//	        miObjeto.metodoInterfaz(); // Llama al método de la interfaz
//	        miObjeto.otroMetodo(); // Llama a otro método de la clase
//	    }
//	}

	//-------------------------------------------------------
	//		2.	 Herencia de interfaz
	//---------------------------------------------------------
	
	// Interfaz base
//	public interface InterfazA {
//	    void metodoA();
//	}
//
//	// Interfaz que extiende otra interfaz
//	public interface InterfazB extends InterfazA {
//	    void metodoB();
//	}
//
//	// Clase que implementa la interfaz extendida
//	public class MiClase implements InterfazB {
//	    @Override
//	    public void metodoA() {
//	        System.out.println("Implementación del método de InterfazA");
//	    }
//
//	    @Override
//	    public void metodoB() {
//	        System.out.println("Implementación del método de InterfazB");
//	    }
//
//	    // Ejemplo de uso
//	    public static void main(String[] args) {
//	        MiClase miObjeto = new MiClase();
//	        miObjeto.metodoA(); // Llama al método de InterfazA
//	        miObjeto.metodoB(); // Llama al método de InterfazB
//	    }
//	}
	
	//-----------------------------------------------------------------------------------------------------------
	//			3.	Multiples implementaciones de Interfaz
	//--------------------------------------------------------------------------------------------------------------

	
	// Interfaz A
//	public interface InterfazA {
//	    void metodoA();
//	}
//
//	// Interfaz B
//	public interface InterfazB {
//	    void metodoB();
//	}
//
//	// Clase que implementa múltiples interfaces
//	public class MiClase implements InterfazA, InterfazB {
//	    @Override
//	    public void metodoA() {
//	        System.out.println("Implementación del método de InterfazA");
//	    }
//
//	    @Override
//	    public void metodoB() {
//	        System.out.println("Implementación del método de InterfazB");
//	    }
//
//	    // Ejemplo de uso
//	    public static void main(String[] args) {
//	        MiClase miObjeto = new MiClase();
//	        miObjeto.metodoA(); // Llama al método de InterfazA
//	        miObjeto.metodoB(); // Llama al método de InterfazB
//	    }
//	}

	//-----------------------------------------------------------------------------------------------------------------
	//				4. Relacion de Dependencia
	//---------------------------------------------------------------------------------------------------------------
	
	// Interfaz
//	public interface MiInterfaz {
//	    void metodoInterfaz();
//	}
//
//	// Clase que depende de la interfaz
//	public class OtraClase {
//	    public void usarInterfaz(MiInterfaz interfaz) {
//	        interfaz.metodoInterfaz(); // Utiliza el método de la interfaz
//	        System.out.println("Operaciones utilizando la interfaz");
//	    }
//
//	    // Ejemplo de uso
//	    public static void main(String[] args) {
//	        OtraClase otraObjeto = new OtraClase();
//	        MiInterfaz miInterfaz = new MiInterfaz() {
//	            @Override
//	            public void metodoInterfaz() {
//	                System.out.println("Implementación del método de la interfaz");
//	            }
//	        };
//	        otraObjeto.usarInterfaz(miInterfaz); // Llama al método que utiliza la interfaz
//	    }
//	}

	
	
	
	
	
	
	
	
	
	
	
	
}
