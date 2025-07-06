package ud_5Recursividad;

import javax.swing.JOptionPane;

public class InvertirNumero {

	public static void main(String[] args) {
		
		
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce numero"));
		int numeroInvertido = invertirNumero(numero);
		System.out.println("Número original: " + numero);
		System.out.println("Número invertido: " + numeroInvertido);
		
		
	}
	
	
	
	
	

	public static int invertirNumero(int numero) {
		return invertirNumeroRecursivo(numero, 0);
	}

	private static int invertirNumeroRecursivo(int numero, int resultadoAuxiliar) {
		if (numero == 0) {
			return resultadoAuxiliar;
		} else {
			int digito = numero % 10;
			return invertirNumeroRecursivo(numero / 10, resultadoAuxiliar * 10 + digito);
		}
	}

}
