package ud_4Metodos;

import java.util.Scanner;

public class Ejercicio_2 {

	
	
	
	public static void main(String[] args) {
		
		mostrarDatos("Jonatan", "Tajada", 35);
		mostrarDatos();
	}
	
	
	
	public static void mostrarDatos(String nombre, String apellido, int edad) {
		
		System.out.println("\nNombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad);
		
		if (edad < 18) {
			System.out.println("Menor de edad");
		}else {
			System.out.println("Mayor de edad");
		}
		System.out.println("**************");
		
	}
	
	
	
	public static void mostrarDatos() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce nombre: ");
		String nombre = scanner.next();
		
		System.out.print("Introduce apellido: ");
		String apellido = scanner.next();
		
		System.out.println("Introduce edad: ");
		byte edad = scanner.nextByte();
		
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Edad: " + edad);
		
		if (edad < 18) {
			System.out.println("Menor de edad");
		}else {
			System.out.println("Mayor de edad");
		}

		scanner.close();
	}
	
	
	
}
