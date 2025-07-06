package ejercicioSerVivoNormal;

public class App {

	
	
	
	public static void main(String[] args) {
		
		SerVivo x,y;
		
		// • Declarar DOS objetos de la clase SerVivo
		x = new SerVivo((byte) 3);
		y = new SerVivo((byte) 5);
		
		// • Usando el método mayor() DEBERÁ imprimir el mayor SerVivo de los creados anteriormente.
		
		System.out.println(	x.mayor(y));
		
		//•	Crear DOS OBJETOS DE LA CLASE Humano y ASIGNARLOS A LAS VARIABLES DECLARADAS PREVIAMENTE
		
		x= new Humano((byte)34, "Homero");
		y= new Humano((byte)90, "Bart");
		
		// • Usando el método mayor() DEBERÁ imprimir el mayor SerVivo de los creados anteriormente.
	
		System.out.println("\n-El personaje mayor es: " + x.mayor((Humano)y));
		
		//equals no solamente compara String sino tb. objetos por ello le pasamos "x" que es Homero
		if (x.mayor((Humano)y).equals(x) == true) {
		    System.out.println("\nEl menor es " + y);
		} else {
		    System.out.println("\nEl menor es " + x);
		}

	}

}
