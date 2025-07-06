package ud_5Arrays;

import javax.swing.JOptionPane;

public class Strings {


	public static void main(String[] args) {
		
	String cadenaInput = JOptionPane.showInputDialog("Introduce la primera cadena:");
    String patron = JOptionPane.showInputDialog("Introduce la segunda cadena (para buscar y transformar):");

    String resultado = transformarSubcadenaAMayusculas(cadenaInput, patron);

    
    JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
    
	}

	
	
	public static String transformarSubcadenaAMayusculas(String cadena, String patron) {
		
    if (cadena == null || patron == null || cadena.isEmpty() || patron.isEmpty()) {
        return cadena;
    }

    int inicio = cadena.indexOf(patron);

    if (inicio == -1) {
        return cadena;
    }

    int fin = inicio + patron.length();

    String resultado = cadena.substring(0, inicio) + cadena.substring(inicio, fin).toUpperCase() + cadena.substring(fin);

    return resultado;
    
	}

}


