package ud_4Metodos;

import java.util.Scanner;

public class Ejercicio_1 {

	
	
	public static void main(String[] args) {
		
		
		pedirDatos();
		pedirDatos("Janire", "Perez", 35);
		
		
	}
	
	
	public static void pedirDatos() {
		try (Scanner scanner = new Scanner(System.in)) {
			String nombre, apellido;
			byte edad;
			
			System.out.print("Introduce nombre: ");
			nombre=scanner.next();
			System.out.print("Introduce apellido: ");
			apellido= scanner.next();
			System.out.print("Introduce edad: ");
			edad=scanner.nextByte();
			
			System.out.println("\nNombre: " + nombre);
			System.out.println("Apellido: " + apellido);
			System.out.println("Edad: " + edad);
		}
	}
	
	
	
	
	
	public static void pedirDatos(String nombre, String apellido, int edad) {
		System.out.println("********");
		System.out.println("Nombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad);
		
	}
	
}
