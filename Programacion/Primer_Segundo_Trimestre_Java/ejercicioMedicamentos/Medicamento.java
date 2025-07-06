package ejercicioMedicamentos;

public class Medicamento {

	// Atributos
	private String nombre;
	private String fabricante;
	private String viaAdministracion;
	private Posologia posologia;

	// Constructor
	public Medicamento(String nombre, String fabricante, String viaAdministracion) {
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.viaAdministracion = viaAdministracion;
	}

	// getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
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

	// mostrar informacion medicamento y su posologia
	public void mostrarInformacion() {
		System.out.println("-Caracteristicas del medicamento:");
		System.out.println("Nombre: " + nombre);
		System.out.println("Fabricante: " + fabricante);
		System.out.println("Vía de Administración: " + viaAdministracion);

		if (posologia != null) {
			System.out.println("\n-Posologia:");
			System.out.println("Usuarios: " + posologia.usuarios);
			System.out.println("Dosis: " + posologia.dosis + " mg");
			System.out.println("Periodo de Tiempo: " + posologia.periodoTiempo);
			System.out.println("Recomendaciones: " + posologia.recomendaciones);
		}
	}

// -------------------------------------------------------------------------------------------------------------------------------
//	clase interna: Posologia
//-------------------------------------------------------------------------------------------------------------------------------

	static class Posologia {

		private String usuarios;
		private int dosis;
		private String periodoTiempo;
		private String recomendaciones;

		public Posologia(String usuarios, int dosis, String periodoTiempo, String recomendaciones) {
			this.usuarios = usuarios;
			this.dosis = dosis;
			this.periodoTiempo = periodoTiempo;
			this.recomendaciones = recomendaciones;
		}
	}

//-------------------------------------------------------------------------------------------------------------------------------
//				*** MAIN ***
//-------------------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {

		// Crear un medicamento
		Medicamento medicamento = new Medicamento("Aspirina", "Bayer", "Oral");

		// Crear una posologia 
		Medicamento.Posologia posologia = new Medicamento.Posologia("Adultos", 500, "Cada 6 horas", "Tomar con comida");
		
		//asignarla al medicamento
		medicamento.asignarPosologia(posologia);

		// Mostrar información del medicamento y su posología
		medicamento.mostrarInformacion();

		System.out.println("\n===============================\n");

		Medicamento medicamento1 = new Medicamento("Aspirina", "Bayer", "Oral");
		Medicamento.Posologia posologia1 = new Medicamento.Posologia("Adultos", 500, "Cada 6 horas","Tomar con comida");
		medicamento1.asignarPosologia(posologia1);

		Medicamento medicamento2 = new Medicamento("Paracetamol", "Generico", "Oral");
		Medicamento.Posologia posologia2 = new Medicamento.Posologia("Niños", 250, "Cada 4 horas", "Con agua");
		medicamento2.asignarPosologia(posologia2);

		Medicamento medicamento3 = new Medicamento("Ibuprofeno", "Pfizer", "Oral");
		Medicamento.Posologia posologia3 = new Medicamento.Posologia("Adultos", 400, "Cada 8 horas", "Con alimentos");
		medicamento3.asignarPosologia(posologia3);

		// Mostrar información de los medicamentos
		medicamento1.mostrarInformacion();
		System.out.println("\n===============================\n");
		medicamento2.mostrarInformacion();
		System.out.println("\n===============================\n");
		medicamento3.mostrarInformacion();

	}

}
