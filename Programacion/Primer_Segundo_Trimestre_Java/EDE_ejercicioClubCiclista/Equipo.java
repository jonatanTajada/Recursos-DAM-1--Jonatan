package EDE_ejercicioClubCiclista;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	//Atributos
	private String nombreEquipo;
	private String paisEquipo;
	private  int tiempoTotal = 0; 
	private List<Ciclista> listaCiclistas;

	
	//Constructores
	public Equipo() {
		this.nombreEquipo = "";
		this.paisEquipo = "";
		this.listaCiclistas = new ArrayList<>();
	}

	public Equipo(String nombreEquipo, String paisEquipo) {
		this.nombreEquipo = nombreEquipo;
		this.paisEquipo = paisEquipo;
		this.listaCiclistas = new ArrayList<>();
	}

	
	// Getters and Setters
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getPaisEquipo() {
		return paisEquipo;
	}

	public void setPaisEquipo(String paisEquipo) {
		this.paisEquipo = paisEquipo;
	}

	public  int getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(int tiempoTotal) {
	        this.tiempoTotal = tiempoTotal;
	}

	public List<Ciclista> getCiclistas() {
		return listaCiclistas;
	}

	public void setCiclistas(List<Ciclista> ciclistas) {
		this.listaCiclistas = ciclistas;
	}

	public void agregarCiclista(Ciclista ciclista) {
		listaCiclistas.add(ciclista);
	}

// 	---------------------------------------------------------------
	
	// metodo calcular tiempo total ciclista
	public void calcularTiempoTotal() {
		tiempoTotal = 0;
		for (Ciclista ciclista : listaCiclistas) {
			tiempoTotal += ciclista.getTiempo();
		}
	}

	//metodo lista de ciclistas
	public void listarNombresCiclistas() {
		for (Ciclista ciclista : listaCiclistas) {
			System.out.println(ciclista.getNombre());
		}
	}

	// toString
	public void imprimirDatosEquipo() {
		System.out.println("Nombre del equipo: " + this.nombreEquipo);
		System.out.println("Pais del equipo: " + this.paisEquipo);
		System.out.println("Tiempo total de los ciclistas: " + this.tiempoTotal + " minutos");
		System.out.println("Ciclistas en el equipo:");
		listarNombresCiclistas();
	}

	
	//metodo buscarCiclista por id
	public Ciclista buscarCiclistaPorId(int id) {
		for (Ciclista ciclista : listaCiclistas) {
			if (ciclista.getId() == id) {
				return ciclista;
			}
		}
		return null;
	}
}
