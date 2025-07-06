package tarea_ultimaSemanaDiciembre_2023;

public class Examen {

	
	//Atributos
	
	private String asignatura;
	private String aula;
	private Fecha fecha;
	private Hora hora;
	
	// Constructor
	
	public Examen(String asignatura, String aula, Fecha fecha, Hora hora) {
		
		this.asignatura = asignatura;
		this.aula = aula;
		this.fecha = fecha;
		this.hora = hora;

	}

	
	//Setters and Getters
	
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}
	
	

	// toString
	
	public String toString() {
		
		return "\n-Características del examen:\n" + "Asignatura: " + asignatura + "\nAula: " + aula  + fecha.toString()  + hora.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
}
