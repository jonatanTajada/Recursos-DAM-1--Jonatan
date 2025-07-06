package EDE_ejercicioClubCiclista_V2;

public class Escalador extends Ciclista{

	//Atributos
	private float aceleracion;
	private float gradoRampa;
	
	


	public Escalador(int id, String nombre, int tiempo,float aceleracion, float gradoRampa) {
		super(id,nombre, tiempo);
		this.aceleracion = aceleracion;
		this.gradoRampa = gradoRampa;
	}

	public Escalador() {}
	

	//getters ands setters
	public float getAceleracion() {
		return aceleracion;
	}

	public void setAceleracion(float aceleracion) {
		this.aceleracion = aceleracion;
	}

	public float getGradoRampa() {
		return gradoRampa;
	}

	public void setGradoRampa(float gradoRampa) {
		this.gradoRampa = gradoRampa;
	}


	@Override
	public String imprimirTipo() {
		
		return "Ciclista de tipo: Escalador ";
	}
	
	@Override
	public void imprimirDatos() {
		super.imprimirDatos();
		System.out.println("Aceleracion: " + this.aceleracion + " m/s^2." + "\nGrado Rampa: " + this.gradoRampa + " grados.");
	}
	
	
	


}
