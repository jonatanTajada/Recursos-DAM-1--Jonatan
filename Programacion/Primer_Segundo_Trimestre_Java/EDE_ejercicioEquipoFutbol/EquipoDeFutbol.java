package EDE_ejercicioEquipoFutbol;



public class EquipoDeFutbol {
	
	//atributos
	private String nombre;
	private String pais;
	private Tecnico tecnico;
	private Portero portero;
	private Defensa[] defensas;
	private Mediocampo[] mediocampos;
	private Delantero[] delanteros;

	public EquipoDeFutbol(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}

	public EquipoDeFutbol(String nombre, String pais, Tecnico tecnico, Portero portero, Defensa[] defensas,
							Mediocampo[] mediocampos, Delantero[] delanteros) {
		this(nombre, pais);
		this.tecnico = tecnico;
		this.portero = portero;
		this.defensas = defensas;
		this.mediocampos = mediocampos;
		this.delanteros = delanteros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Portero getPortero() {
		return portero;
	}

	public void setPortero(Portero portero) {
		this.portero = portero;
	}

	public Defensa[] getDefensas() {
		return defensas;
	}

	public void setDefensas(Defensa[] defensas) {
		this.defensas = defensas;
	}

	public Mediocampo[] getMediocampos() {
		return mediocampos;
	}

	public void setMediocampos(Mediocampo[] mediocampos) {
		this.mediocampos = mediocampos;
	}

	public Delantero[] getDelanteros() {
		return delanteros;
	}

	public void setDelanteros(Delantero[] delanteros) {
		this.delanteros = delanteros;
	}
	
	
	public void imprimir() {
		
		
	    System.out.println("Equipo: " + nombre);
	    System.out.println("Pais: " + pais);

	    System.out.println("\nTecnico:");
	    System.out.println("Nombre: " + tecnico.getNombre() + " " + tecnico.getApellidos());
	    System.out.println("Edad: " + tecnico.getEdad());
	    System.out.println("Experiencia: " + tecnico.getExperiencia() + " años");
	    System.out.println("Nacionalidad: " + (tecnico.esNacional() ? "Nacional" : "Extranjero"));

	    System.out.println("\nPortero:");
	    System.out.println("Nombre: " + portero.getNombre() + " " + portero.getApellidos());
	    System.out.println("Edad: " + portero.getEdad());
	    System.out.println("Goles Recibidos: " + portero.getGolesRecibidos());

	    System.out.println("\nDefensas:");
	    for (Defensa defensa : defensas) {
	        System.out.println("Nombre: " + defensa.getNombre() + " " + defensa.getApellidos());
	        System.out.println("Edad: " + defensa.getEdad());
	        System.out.println("Titular: " + (defensa.isTitular() ? "Si" : "No"));
	        System.out.println("---");
	    }

	    System.out.println("\nMediocampos:");
	    for (Mediocampo mediocampo : mediocampos) {
	        System.out.println("Nombre: " + mediocampo.getNombre() + " " + mediocampo.getApellidos());
	        System.out.println("Edad: " + mediocampo.getEdad());
	        System.out.println("Titular: " + (mediocampo.isTitular() ? "Si" : "No"));
	        System.out.println("Asistencias: " + mediocampo.getAsistencias());
	        System.out.println("---");
	    }

	    System.out.println("\nDelanteros:");
	    for (Delantero delantero : delanteros) {
	        System.out.println("Nombre: " + delantero.getNombre() + " " + delantero.getApellidos());
	        System.out.println("Edad: " + delantero.getEdad());
	        System.out.println("Titular: " + (delantero.isTitular() ? "Si" : "No"));
	        System.out.println("Goles Anotados: " + delantero.getGolesAnotados());
	        System.out.println("---");
	    }
	}

	


}
