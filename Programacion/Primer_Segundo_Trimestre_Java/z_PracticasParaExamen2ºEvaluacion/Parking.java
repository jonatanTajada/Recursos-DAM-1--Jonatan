package z_PracticasParaExamen2ºEvaluacion;

import java.util.ArrayList;
import java.util.List;

public class Parking {

	//Atributos
	
	private List<String> matriculas;
	private String nombre;
	
	
	//Constructor
	
	public Parking(String nombre, int numPlazas) {
		
		this.nombre= nombre;
		matriculas = new ArrayList<String>(numPlazas);
		
		for (int i = 0; i < numPlazas; i++) {
			matriculas.add(null);
		}
	}
	
	
//---------------------------------------------------------------------------------------------------------------
//						*** METODOS ****
//---------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
