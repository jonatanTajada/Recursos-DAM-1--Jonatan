package ejercicioParking2;

import java.util.ArrayList;
import java.util.List;

public class Parkingg {

	// atributos

	private  List<String> listaMatriculas;
	private String nombreParking;

	// constructor

	public Parkingg(String nombreParkingg, int numeroPlazasParking) {
		this.nombreParking = nombreParkingg;
		listaMatriculas = new ArrayList<String>(numeroPlazasParking);

		for (String string : listaMatriculas) {
			listaMatriculas.add(null);
		}
	}

	// getters and setters

	public List<String> getListaMatriculas() {
		return listaMatriculas;
	}

	public String getNombreParking() {
		return nombreParking;
	}

	
	//------------------------------------ 	**  metodos  **---------------------------------------
	//---------------------------------------------------------------------------------------------

	// metodo entrada
	public  void entrada(String matricula, int plaza) throws Exception {

		if (matricula == null || matricula.length() < 4) {
			throw new Exception("Matricula incorrecta");
		}

		if (listaMatriculas.get(plaza) != null) {
			throw new Exception("Plaza ocupada");
		}

		if (listaMatriculas.contains(matricula)) {
			throw new Exception("Matricula repetida");
		}

		if (listaMatriculas.size() < 0 || listaMatriculas.size() > 10) {
			throw new Exception("No existe ese numero de plaza");
		}

		listaMatriculas.set(plaza, matricula);
		System.out.println("Coche registrado correctamente, puede aparcar el coche.");
	}

	// metodo salida

	public int salida(String matricula) throws Exception {
		int plazaLiberada;

		if (!listaMatriculas.contains(matricula)) {
			throw new Exception("Matricula no existente");
		} else {
			plazaLiberada = listaMatriculas.indexOf(matricula);
		}

		listaMatriculas.set(plazaLiberada, null);

		System.out.println("Puede salir del parking, que tenga un buen dia!");
		return plazaLiberada;
	}

	// obtenr plazas totales del parking

	public int getPlazasTotales() {
		return listaMatriculas.size();
	}

	// obtener plazas ocupas del parking

	public int getPlazasOcupadas() {
	    int contadorPlazasOcupadas = 0;

	    for (String matricula : listaMatriculas) {
	        if (matricula != null) {
	            contadorPlazasOcupadas++;
	        }
	    }

	    return contadorPlazasOcupadas;
	}


	// obtener plzas libres del parking

	public int getPlazasLibres() {
		return getPlazasTotales() - getPlazasOcupadas();
	}

	// toStrnig
	@Override
	public String toString() {

		String resultado = this.nombreParking.toUpperCase() + "\n" +"----------------------";

		for (int i = 0; i < listaMatriculas.size(); i++) {
			resultado += "Plaza " + i + ": ";

			if (listaMatriculas.get(i) == null) {
				resultado += "(vacia)";
			} else {
				resultado += listaMatriculas.get(i);
			}
			resultado += "\n";

		}
		return resultado;

	}
	

	

}
