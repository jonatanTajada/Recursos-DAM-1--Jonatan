package tarea_ultimaSemanaDiciembre_2023;

public class Fecha {

	//Atributos
	
	private int dia;
	private int mes;
	private int anio;
	
	//Constructor
	
//	public Fecha(int dia, int mes, int anio) {
//		
//		if (dia <1 || dia > 31) {
//			System.err.println("Introduce un dia valida, por favor");
//		}else {
//			this.dia = dia;
//		}
//		
//		
//		if (mes < 1|| mes > 12) {
//			System.err.println("Introduce un mes validdo, por favor");
//		}else {
//			this.mes = mes;
//		}
//		
//		
//		if (anio  < 1000 || anio > 2500) {
//			System.err.println("Introduce una fecha valida");
//		}else {
//			this.anio = anio;
//		}
//		
//	}

	
	public Fecha(int dia, int mes, int anio) throws IllegalArgumentException {
		
	    if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 1000 || anio > 2500) {
	        throw new IllegalArgumentException("Introduce valores correctos para los dias, meses y/o años.");
	    }

	    this.dia = dia;
	    this.mes = mes;
	    this.anio = anio;
	}

	
	
	
	
	
	
	
	//Setters and Getters
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	
	
	// toString
	
	@Override
	public String toString() {
		
		return "\n***FECHA EXAMEN***" + "\nDia: " + dia + "\nMes: "  + mes + "\nAño: " + anio;
	}
	
	

	
	
	
	
	
	
	
	
}
