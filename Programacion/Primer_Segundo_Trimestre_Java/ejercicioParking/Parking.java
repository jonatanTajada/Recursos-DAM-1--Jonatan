package ejercicioParking;

import java.util.ArrayList;

public class Parking  {
	
	//Atributos
	private ArrayList<String> matriculas;
	private String nombre;

	//Constructor
	public Parking(String nombre, int numeroPlazas) {
		
		this.nombre = nombre;
		this.matriculas = new ArrayList<>(numeroPlazas);
		
		for (int i = 0; i < numeroPlazas; i++) {
			matriculas.add(null);
		}
	}

	//||-----------------------------------------------||
	//||			***METODOS***					   ||
	//||-----------------------------------------------||
	
	
	public String getNombre() {
		return nombre;
	}

	public void entrada(String matricula, int plaza) throws Exception {
		
		if (matricula == null || matricula.length() < 4) {
			throw new Exception("Matricula incorrecta!!");
		}

		if (plaza < 0 || plaza >= matriculas.size()) {
			throw new Exception("Numero de plaza incorrecto");
		}

		if (matriculas.get(plaza) != null) {
			throw new Exception("Plaza ocupada");
		}

		if (matriculas.contains(matricula)) {
			throw new Exception("Matricula repetida");
		}

		matriculas.set(plaza, matricula);
	}

	public int salida(String matricula) throws Exception {
		
		if (!matriculas.contains(matricula)) {
			throw new Exception("Matrícula no existente");
		}

		int plazaLibre = matriculas.indexOf(matricula);
		matriculas.set(plazaLibre, null);

		return plazaLibre;
	}

	public int getPlazasTotales() {
		return matriculas.size();
	}

	public int getPlazasOcupadas() {
		int contador = 0;
		
		for (String matricula : matriculas) {
			if (matricula != null) {
				contador++;
			}
		}
		return contador;
	}

	public int getPlazasLibres() {
		return matriculas.size() - getPlazasOcupadas();
	}

	@Override
	public String toString() {
		
		StringBuilder resultado = new StringBuilder();
		
		resultado.append(nombre).append("\n");

		for (int i = 0; i < matriculas.size(); i++) {
			resultado.append("Plaza ").append(i).append(": ");
			
			if (matriculas.get(i) == null) {
				resultado.append("(vacía)");
			} else {
				resultado.append(matriculas.get(i));
			}
			resultado.append("\n");
		}

		return resultado.toString();
	}
	
	public String toString2() {
	    String resultado = nombre + "\n";

	    for (int i = 0; i < matriculas.size(); i++) {
	        resultado += "Plaza " + i + ": ";

	        if (matriculas.get(i) == null) {
	            resultado += "(vacía)";
	        } else {
	            resultado += matriculas.get(i);
	        }

	        resultado += "\n";
	    }

	    return resultado;
	}

	
	
	
	
	
	

//	public static void main(String[] args) {
//		try {
//			Parking parking = new Parking("Avenida", 4);
//
//			parking.entrada("3322AB", 1);
//			parking.entrada("5342HW", 2);
//
//			System.out.println(parking);
//
//			int plazaLiberada = parking.salida("3322AB");
//			System.out.println("Coche con matrícula 3322AB salió del parking. Plaza liberada: " + plazaLiberada);
//
//			System.out.println("Plazas totales: " + parking.getPlazasTotales());
//			System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
//			System.out.println("Plazas libres: " + parking.getPlazasLibres());
//
//		} catch (Exception e) {
//			System.out.println("Error: " + e.getMessage());
//		}
//	}
}
