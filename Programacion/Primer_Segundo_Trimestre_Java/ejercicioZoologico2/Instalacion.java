package ejercicioZoologico2;

import java.util.List;

public class Instalacion {

	
	//Atributos
	private String numero;
	private String descripcion;
	private int anioInstalacion;
	private Zona zona;
	private List<Animal> animales;
	
	//Constructor
	public Instalacion(String numero, String descripcion, int anioInstalacion, Zona zona) {
		this.numero = numero;
		this.descripcion = descripcion;
		this.anioInstalacion = anioInstalacion;
		this.zona = zona;
	}


	//Setters ands Getters
	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getAnioInstalacion() {
		return anioInstalacion;
	}


	public void setAnioInstalacion(int anioInstalacion) {
		this.anioInstalacion = anioInstalacion;
	}


	public Zona getZona() {
		return zona;
	}


	public void setZona(Zona zona) {
		this.zona = zona;
	}


	//toString
	@Override
	public String toString() {
		return "Instalacion [numero=" + numero + ", descripcion=" + descripcion + ", anioInstalacion=" + anioInstalacion
				+ ", zona=" + zona + ", animales=" + animales + "]";
	}
	
	
	
	
}
