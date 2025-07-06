package ud_5Recursividad;

import javax.swing.JOptionPane;

public class SumaNumeros {

	
	
	public static void main(String[] args) {
		
	int n = Integer.parseInt(JOptionPane.showInputDialog("Intoduce un numero"));
	//int suma = sumarHastaNConFor(n);
	int suma = sumarHastaN(n);
	System.out.println("La suma de los numeros desde 1 hasta " + n + " es: " + suma);
		
	}
	
	
	
	
	
	
	
	public static int sumarHastaN(int n) {
		
		if (n <=0) {
			return 0;
		}else {
			return n + sumarHastaN(n - 1);
		}
		
	}
	
//	public static int sumarHastaNConFor(int n) {
//	    int suma = 0;
//	    for (int i = 1; i <= n; i++) {
//	        suma += i;
//	    }
//	    return suma;
//	}
	
	
	
}
