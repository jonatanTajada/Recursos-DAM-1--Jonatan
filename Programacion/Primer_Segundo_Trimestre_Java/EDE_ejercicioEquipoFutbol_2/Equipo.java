package EDE_ejercicioEquipoFutbol_2;

public class Equipo {

	
	//atributos
	private Tecnico tecnico;
	private Persona portero;
	private Defensa defensas[];
	private Mediocampo medioCampos[];
	private Delantero delanteros[];
	private String nombreEquipo;
	private String paisOrigenEquipo;
	
	//constrcutores
	
	public Equipo(String nombreEquipo, String paisOrigenEquipo) {
		this.nombreEquipo=nombreEquipo;
		this.paisOrigenEquipo=paisOrigenEquipo;
	}
	
	
	public Equipo(String nombreEquipo, String paisOrigenEquipo, Tecnico tecnico, Portero portero, Defensa defensas[],
					Mediocampo medioCampos[], Delantero delanteros[]) {
		this(nombreEquipo, paisOrigenEquipo);
		this.tecnico=tecnico;
		this.portero=portero;
		this.defensas=defensas;
		this.medioCampos=medioCampos;
		this.delanteros=delanteros;
	}


	public Tecnico getTecnico() {
		return tecnico;
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}


	public Persona getPortero() {
		return portero;
	}


	public void setPortero(Persona portero) {
		this.portero = portero;
	}


	public Defensa[] getDefensas() {
		return defensas;
	}


	public void setDefensas(Defensa[] defensas) {
		this.defensas = defensas;
	}


	public Mediocampo[] getMedioCampos() {
		return medioCampos;
	}


	public void setMedioCampos(Mediocampo[] medioCampos) {
		this.medioCampos = medioCampos;
	}


	public Delantero[] getDelanteros() {
		return delanteros;
	}


	public void setDelanteros(Delantero[] delanteros) {
		this.delanteros = delanteros;
	}


	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}


	public String getPaisOrigenEquipo() {
		return paisOrigenEquipo;
	}


	public void setPaisOrigenEquipo(String paisOrigenEquipo) {
		this.paisOrigenEquipo = paisOrigenEquipo;
	}
	
	
	//toString
	public void imprimir() {
			System.out.println("Informacion del equipo:\n-------------------------");
			
		 	System.out.println("Equipo: " + this.nombreEquipo);
		    System.out.println("Pais: " + this.paisOrigenEquipo);

		    System.out.println("\n-Tecnico:");
		    System.out.println(tecnico.toString());
		    
		    System.out.println();
		    
		    System.out.println("\n-Portero:");
		    System.out.println(portero.toString());
		    
		    System.out.println();
		    
		    System.out.println("-Defensas:");
		    for (Defensa defensa : defensas) {
				System.out.println(defensa.toString());
			}
		    
		    System.out.println();
		    
		    System.out.println("-Mediocampos: ");
		    for (Mediocampo medioCampo : medioCampos) {
				System.out.println(medioCampo.toString());
			}
		    
		    System.out.println();
		    
		    System.out.println("-Delanteros: ");
		    for (Delantero delanteros : delanteros) {
				System.out.println(delanteros.toString());
			}
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
	}
	
	

	
	
}

