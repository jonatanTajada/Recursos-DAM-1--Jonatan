package EDE_ejercicioClubCiclista;


	public class Escalador extends Ciclista {
		
		//Atributos
	    private float aceleracion;
	    private float gradoRampa;

	    //Constructores
	    public Escalador() {
	        super();
	        this.aceleracion = 0.0f;
	        this.gradoRampa = 0.0f;
	    }

	    public Escalador(int id, String nombre, float aceleracion, float gradoRampa) {
	        super(id, nombre);
	        this.aceleracion = aceleracion;
	        this.gradoRampa = gradoRampa;
	    }

	    // Getters and Setters
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
	        return "Es un Escalador";
	    }

	    //toString
	    @Override
	    public void imprimirDatos() {
	        super.imprimirDatos();
	        System.out.println("Aceleracion promedio en subida: " + this.aceleracion + " m/s^2");
	        System.out.println("Grado de rampa soportada: " + this.gradoRampa + " grados");
	    }
	}
