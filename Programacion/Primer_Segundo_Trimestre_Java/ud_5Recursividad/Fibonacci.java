package ud_5Recursividad;

import javax.swing.JOptionPane;

public class Fibonacci {

	
	
	public static void main(String[] args) {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para calcular la serie Fibonacci."));
		long resultado = calcularFibonacci(n);
		
		System.out.println("El " + n + " -esimo termino de la serie de Fibonacci es: " +  resultado);
		
		
		
	}
	
	
	public static long calcularFibonacci (int n) {
		
		if (n <= 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			return calcularFibonacci(n - 1) + calcularFibonacci(n -2);
		}
		
	}
	
	
}
