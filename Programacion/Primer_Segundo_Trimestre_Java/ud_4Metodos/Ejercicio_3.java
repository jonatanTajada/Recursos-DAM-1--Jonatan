package ud_4Metodos;

import java.util.Scanner;

public class Ejercicio_3 {

	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número para ver su tabla de multiplicar: ");
        int numero = scanner.nextInt();

        mostrarTablaDeMultiplicar(numero);

        scanner.close();
		
		
		
	}
	
	
	
	public static void mostrarTablaDeMultiplicar(int numero) {
        System.out.println("Tabla de multiplicar del " + numero + ":");

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
    }
	
	
	
	
}
