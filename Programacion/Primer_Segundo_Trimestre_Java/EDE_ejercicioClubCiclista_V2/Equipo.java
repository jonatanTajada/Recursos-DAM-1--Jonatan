package EDE_ejercicioClubCiclista_V2;

import java.util.*;

import EDE_ejercicioClubCiclista.Ciclista;

public class Equipo {

	
	//atributos
	private String nombreEquipo;
	private String paisEquipo;
	private int tiempoTotal=0;
	private List<Ciclista> listaCiclista;
	
	//Constructor
	
	public Equipo(String nombre,String paisEquipo ){
		this.nombreEquipo="";
		this.paisEquipo="";
		listaCiclista = new ArrayList<Ciclista>();
	}
	
	
	public Equipo(String nombre, String paisEquipo, int tiempoTotal){
		this.nombreEquipo=nombre;
		this.paisEquipo=paisEquipo;
		this.tiempoTotal=tiempoTotal;
		listaCiclista = new ArrayList<Ciclista>();
	}


	//getters ands setters
	public String getNombre() {
		return nombreEquipo;
	}


	public void setNombre(String nombre) {
		this.nombreEquipo = nombre;
	}


	public String getPaisEquipo() {
		return paisEquipo;
	}


	public void setPaisEquipo(String paisEquipo) {
		this.paisEquipo = paisEquipo;
	}


	public int getTiempoTotal() {
		return tiempoTotal;
	}


	public void setTiempoTotal(int tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}


	public List<Ciclista> getListaCiclista() {
		return listaCiclista;
	}


	public void setListaCiclista(List<Ciclista> listaCiclista) {
		this.listaCiclista = listaCiclista;
	}

	public void agregarCiclista(Ciclista ciclista) {
		this.listaCiclista.add(ciclista);
	}

// -------------------------------------------------------------------
	
	//metodo camcularTiempoTotal
	public void calcularTiempoTotal() {
		tiempoTotal= 0;
		// si nova probar con: int sumatotal= 0;
		for (Ciclista ciclista : listaCiclista) {
			tiempoTotal += ciclista.getTiempo();
		}
		System.out.println();
	}
	
	
	
	//metodo muestra nombre de los ciclistras
	public void listarNombresCiclistas() {
		int contador = 1;
		System.out.println("-Lista de nombres de los ciclistas:\n");
		for (Ciclista ciclista : listaCiclista) {
			System.out.println("Ciclista #" + contador + ":");
			System.out.println(ciclista.getNombre());
			contador ++;
		}
	}
	
	//metodo muestra datos del equipo
	public void imprimirDatosEquipo() {
		System.out.println("Nombre del equipo: " + nombreEquipo);
		System.out.println("Pais del equipo: " + paisEquipo);
		System.out.println("Tiempo total de los ciclistas: " + tiempoTotal + " minutos");
		System.out.println("Ciclistas en el equipo:");
		listarNombresCiclistas();
	}
	
	//metodo buscar ciclistas por id
	public Ciclista buscarCiclistaPorId(int id) {
		
		System.out.println("Bucando a ciclista con id: " + id);
		for (Ciclista ciclista : listaCiclista) {
			if (ciclista.getId() == id) {
				return ciclista;
			}
		}
		return null;
	}
	
	
	
	
}
