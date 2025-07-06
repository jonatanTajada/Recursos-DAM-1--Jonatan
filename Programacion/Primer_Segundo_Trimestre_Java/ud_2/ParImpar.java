package ud_2;

import javax.swing.JOptionPane;

public class ParImpar {

	public static void main(String[] args) {

//		int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un numero"));
//
//		if (num1 % 2 == 0) {
//			JOptionPane.showMessageDialog(null, "EL numero " + num1 + " es PAR");
//		} else {
//			JOptionPane.showMessageDialog(null, "El numero " + num1 + " es IMPAR");
//		}
		
		
		int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce un numero"));
		String mensaje = (num1 % 2 == 0) ? "es PAR" : "es IMPAR";
		JOptionPane.showMessageDialog(null, "El numero " + num1 + " " + mensaje);
		
		
		
	}

}
