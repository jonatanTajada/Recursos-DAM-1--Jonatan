package ejercicioZoologico2;

public class Asignacion {

	//Atributos
	private Trabajador trabajador;
	private Zona zona;
	private String horario;
	
	
	public Asignacion(Trabajador trabajador, Zona zona, String horario) {
		this.trabajador = trabajador;
		this.zona = zona;
		this.horario = horario;
	}


	public Trabajador getTrabajador() {
		return trabajador;
	}


	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}


	public Zona getZona() {
		return zona;
	}


	public void setZona(Zona zona) {
		this.zona = zona;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	@Override
	public String toString() {
		return "Asignacion [trabajador=" + trabajador + ", zona=" + zona + ", horario=" + horario + "]";
	}
	
	
	
	
}
