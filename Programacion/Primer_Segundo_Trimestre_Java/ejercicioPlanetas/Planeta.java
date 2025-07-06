package ejercicioPlanetas;

//creo la clase Planeta con sus atributos y metodos. Usamos la "clase" TipoPlaneta como atributo y es de tipo enum.

public class Planeta {

	// Atributos

	private String nombre = null;
	private int cantidadSatelites = 0;
	private double masa = 0;
	private double volumen = 0;
	private int diametro = 0;
	private double distanciaAlSolUdMillones;
	private TipoPlaneta tipo;
	private boolean observable;
    private static final double UA_EN_KM = 149597870.0;
    private double periodoOrbitalEnAnios;
    private int periodoRotacionEnDias;



	// Constructor

	public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, double distanciaAlSol,
					TipoPlaneta tipo, boolean observable, double periodoOrbitalEnAnios, int periodoRotacionEnDias) {
		this.nombre = nombre;
		this.cantidadSatelites = cantidadSatelites;
		this.masa = masa;
		this.volumen = volumen;
		this.diametro = diametro;
		this.distanciaAlSolUdMillones = distanciaAlSol;
		this.tipo = tipo;
		this.observable = observable;
		this.periodoOrbitalEnAnios = periodoOrbitalEnAnios;
		this.periodoRotacionEnDias = periodoRotacionEnDias;
	
	}
	//Setters and Getters


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadSatelites() {
		return cantidadSatelites;
	}

	public void setCantidadSatelites(int cantidadSatelites) {
		this.cantidadSatelites = cantidadSatelites;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public double getDistanciaAlSolUdMillones() {
		return distanciaAlSolUdMillones;
	}


	public void setDistanciaAlSolUdMillones(double distanciaAlSolUdMillones) {
		this.distanciaAlSolUdMillones = distanciaAlSolUdMillones;
	}

	public TipoPlaneta getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlaneta tipo) {
		this.tipo = tipo;
	}

	public boolean isObservable() {
		return observable;
	}

	public void setObservable(boolean observable) {
		this.observable = observable;
	}
	
	public double getPeriodoOrbitalEnAnios() {
		return periodoOrbitalEnAnios;
	}


	public void setPeriodoOrbitalEnAnios(double periodoOrbitalEnAnios) {
		this.periodoOrbitalEnAnios = periodoOrbitalEnAnios;
	}


	public int getPeriodoRotacionEnDias() {
		return periodoRotacionEnDias;
	}


	public void setPeriodoRotacionEnDias(int periodoRotacionEnDias) {
		this.periodoRotacionEnDias = periodoRotacionEnDias;
	}
	
	
						//**** Metodos*******

	// calcular la densidad de un planeta	
	public double calcularDensidad() {
		return masa / volumen;
	}
	
	// para saber si un planeta pertenece al exterior	
	public boolean esPlanetaExterior() {
	    double distanciaEnUA = distanciaAlSolUdMillones / UA_EN_KM;
	    return distanciaEnUA < 2.1 || distanciaEnUA > 3.4;
	}



	// mostrar informacion del objeto Planeta
	public void imprimirInformacion() {
		System.out.println("Caracteristicas del Planeta: ");
		System.out.println("Nombre: " + nombre);
		System.out.println("Cantidad de Satélites: " + cantidadSatelites);
		System.out.println("Masa del planeta: " + masa);
		System.out.println("Volumen del planeta: " + volumen);
		System.out.println("Diametro del planeta: " + diametro);
		System.out.println("Distancia del planeta al Sol: " + distanciaAlSolUdMillones + " millones de km.");
		System.out.println("Tipo de planeta: " + tipo);
		System.out.println("Planeta observable: " + observable);
		System.out.println("Periodo Orbital del planeta: " + periodoOrbitalEnAnios + " años");
        System.out.println("Periodo de Rotación del planeta: " + periodoRotacionEnDias + " días");
	}
	
	
	
	
}	
	
	

