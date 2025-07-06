package ejercicioZoologico2;

import java.util.ArrayList;
import java.util.List;

public class Zona {

	//Atributos
	
	private String id;
	private String nombre;
	private int metrosCuadrados;
	private List<Instalacion> instalaciones;
	
	public Zona(String id, String nombre, int metrosCuadrados) {
		this.id = id;
		this.nombre = nombre;
		this.metrosCuadrados = metrosCuadrados;
		this.instalaciones = new ArrayList<Instalacion>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	

	@Override
	public String toString() {
		return "Zona [id=" + id + ", nombre=" + nombre + ", metrosCuadrados=" + metrosCuadrados + ", instalaciones="
				+ instalaciones + "]";
	}


	
	
	
	
	
	
	
	
}
