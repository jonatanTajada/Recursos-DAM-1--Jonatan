package tarea_ultimaSemanaDiciembre_2023;

public class Hora {

	
	//Atributos
	
	private int hora;
	private int minuto;
	
	
	//Constructor
	
	
	
//	public Hora(int hora, int minutos) {
//		
//		if (hora < 0 || hora > 23) {
//			System.out.println("Introduce una hora valida, por favor.");
//		}else {
//			this.hora = hora;
//		}
//		
//		if (minutos < 0 || minutos > 59) {
//			System.out.println("Introduce los minutos de forma correcta, por favor.");
//		}else {
//			this.minuto = minutos;
//		}
//
//	}

	
	public Hora(int hora, int minutos) throws IllegalArgumentException {
	    if (hora < 0 || hora > 23 || minutos < 0 || minutos > 59) {
	        throw new IllegalArgumentException("Introduce de nuevo valores correctos para las horas y minutos.");
	    }

	    this.hora = hora;
	    this.minuto = minutos;
	}

	

	//Setters and Getters
	
	public int getHora() {
		return hora;
	}


	public void setHora(int hora) {
		this.hora = hora;
	}


	public int getMinutos() {
		return minuto;
	}


	public void setMinutos(int minutos) {
		this.minuto = minutos;
	}


	// toString
	
	@Override
	public String toString() {
		return "\n***HORA EXAMEN***" + "\nHora: " + hora + "\nMinuto: " + minuto;
	}
	
	
	
	
	
	
	
	
}
