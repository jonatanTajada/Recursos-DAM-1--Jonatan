package ejercicioSerVivoConHashCode;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
	
//-------------------------------------------------------------------------------------------------------------------------------------
//			-- Uso de ArrayList -- 
//------------------------------------------------------------------------------------------------------------------------------------- 
		
		// Crear ArrayList
		ArrayList<SerVivo> listaSerVivos = new ArrayList<>();

		// Crear instancias de Humano y SerVivo
		SerVivo humano1 = new Humano((byte) 3, "Alice");
		SerVivo humano2 = new Humano((byte) 30, "Bob"); 
		SerVivo serVivo1 = new SerVivo((byte) 5);
		SerVivo serVivo3 = new SerVivo((byte) 20);

		// Agregar SerVivos y Humanos a la lista
		listaSerVivos.add(humano1);
		listaSerVivos.add(humano2);
		listaSerVivos.add(serVivo1);
		listaSerVivos.add(serVivo3);

		// Usar el metodo equals con ArrayList
		System.out.println("-Usando equals con ArrayList:");
		System.out.println("-------------------------------");
		System.out.println("humano1 equals humano2: " + humano1.equals(humano2));
		System.out.println("humano1 equals serVivo1: " + humano1.equals(serVivo1));

		System.out.println();

		int indice = 1;

		for (SerVivo serVivoActual : listaSerVivos) {
			
			System.out.println("#" + indice + serVivoActual.toString());
			indice++;
			System.out.println();
		}
		
		
		SerVivo mayor = humano1.mayor(humano2);

        System.out.println("\nEl SerVivo mayor es:");
        System.out.println(mayor.toString());
		
	}
	
	
	
	
	
	
	
//-------------------------------------------------------------------------------------------------------------------------------------
//	-- En vez de usar metodo arrayList uso equal y hashcode
//------------------------------------------------------------------------------------------------------------------------------------- 
	// Usar metodo equals
//    System.out.println("Usando equals:");
//    System.out.println("serVivo1 equals serVivo2: " + serVivo1.equals(serVivo2));  
//    System.out.println("serVivo1 equals serVivo3: " + serVivo1.equals(serVivo3));  

// Imprimir hashCode
//    System.out.println("\nUsando hashCode:");
//    System.out.println("HashCode de serVivo1: " + serVivo1.hashCode());
//    System.out.println("HashCode de serVivo2: " + serVivo2.hashCode());
//    System.out.println("HashCode de serVivo3: " + serVivo3.hashCode());
	
	// Imprimir hashCode de los elementos de ArrayList
//			System.out.println("\nUsando hashCode con ArrayList:");
//			System.out.println("HashCode de humano1: " + humano1.hashCode());
//			System.out.println("HashCode de humano2: " + humano2.hashCode());
//			System.out.println("HashCode de serVivo1: " + serVivo1.hashCode());

	
	

}
