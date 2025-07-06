package BateriasEjerciciosPracticaExamenPOO;

import java.util.ArrayList;
import java.util.List;

public class Medicamento {

	//atributos
	private String nombreMedicamento;
	private String nombreFabricante;
	private String viaAdministracion;
	private Posologia posologia;
	


	//constructor
	public Medicamento(String nombreMedicamento, String nombreFabricante, String viaAdministracion) {
		this.nombreMedicamento = nombreMedicamento;
		this.nombreFabricante = nombreFabricante;
		this.viaAdministracion = viaAdministracion;
	}

	//getters and setters
	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public String getNombreFabricante() {
		return nombreFabricante;
	}

	public void setNombreFabricante(String nombreFabricante) {
		this.nombreFabricante = nombreFabricante;
	}

	public String getViaAdministracion() {
		return viaAdministracion;
	}

	public void setViaAdministracion(String viaAdministracion) {
		this.viaAdministracion = viaAdministracion;
	}
	
	public Posologia getPosologia() {
		return posologia;
	}

	public void asignarPosologia(Posologia posologia) {
		this.posologia = posologia;
	}
	
	public void mostrarInformacion() {
		
		System.out.println("\nInformacion del medicamento:\n--------------------------");
		System.out.println("Nombre del medicamento: " + this.nombreMedicamento);
		System.out.println("Nombre del fabricante: " + this.nombreFabricante);
		System.out.println("Via de administracion: " + this.viaAdministracion);
		
		if (posologia != null) {
			System.out.println("-Posologia para el medicamento: ");
			System.out.println("Usuario medicamentos: " + posologia.usuariosMedicamento);
			System.out.println("Dosis de medicamento recomendado: " + posologia.dosisMedicamentoMg + " Mg");
			System.out.println("Recomendaciones de uso: " + posologia.recomendaciones);
			
		}
		
		
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------*** MAIN (Medicamento)*** --------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
		List<Medicamento> listaMedicamentos = new ArrayList<Medicamento>(); // agrego una lista para guardar todos los medicamentos
		
		Medicamento medicamento1 = new Medicamento("Aspira", "Bayer", "Por vena");
		Posologia posologia1 = new Posologia("Adultos", 12, 6, "Su uso es recomendado con el estomago lleno");
		medicamento1.asignarPosologia(posologia1);
		
		Medicamento medicamento2 = new Medicamento("Antiflamatorio", "Farmaceutica S.L.", "Oral con agua");
		Posologia posologia2 = new Posologia("Adultos", 19, 8, "Su uso es recomendado con el estomago vacio");
		medicamento2.asignarPosologia(posologia1);
		
		
		listaMedicamentos.add(medicamento1);
		listaMedicamentos.add(medicamento2);
		
		System.out.println("Mostrando lista de medicamentos:\n---------------------------");
		for (Medicamento medicamento : listaMedicamentos) {
			medicamento.mostrarInformacion();
			System.out.println();
		}
		
		
		
		
//		medicamento1.mostrarInformacion();
//		System.out.println("-------------------------------");
//		medicamento2.mostrarInformacion();
//		
		
	
	}

	
	
//--------------------------------------------------------------------------------------------------------------------------------------------
//----------------------------*** CLASE INTERNA PSOLOGIA--------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------
	
	static class Posologia{
		
	//atributos
	private String usuariosMedicamento;
	private int dosisMedicamentoMg;
	private int periodoTiempoRecomendado;
	private String recomendaciones;
	
	//constructores
	public Posologia(String usuariosMedicamento, int dosisMedicamentoMg, int periodoTiempoRecomendado,
			String recomendaciones) {
		this.usuariosMedicamento = usuariosMedicamento;
		this.dosisMedicamentoMg = dosisMedicamentoMg;
		this.periodoTiempoRecomendado = periodoTiempoRecomendado;
		this.recomendaciones = recomendaciones;
	}

	//getters and setters
	public String getUsuariosMedicamento() {
		return usuariosMedicamento;
	}

	public void setUsuariosMedicamento(String usuariosMedicamento) {
		this.usuariosMedicamento = usuariosMedicamento;
	}

	public int getDosisMedicamentoMg() {
		return dosisMedicamentoMg;
	}

	public void setDosisMedicamentoMg(int dosisMedicamentoMg) {
		this.dosisMedicamentoMg = dosisMedicamentoMg;
	}

	public int getPeriodoTiempoRecomendado() {
		return periodoTiempoRecomendado;
	}

	public void setPeriodoTiempoRecomendado(int periodoTiempoRecomendado) {
		this.periodoTiempoRecomendado = periodoTiempoRecomendado;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
	
	
	
	
	
		
		
	}
	
	
	
	
	

}
