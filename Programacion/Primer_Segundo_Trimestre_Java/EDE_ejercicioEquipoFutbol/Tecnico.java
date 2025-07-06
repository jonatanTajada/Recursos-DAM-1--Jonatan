package EDE_ejercicioEquipoFutbol;

public class Tecnico extends Persona {
    private int experiencia;
    private boolean nacional;

    public Tecnico(String nombre, String apellidos, int edad, int experiencia, boolean nacional) {
        super(nombre, apellidos, edad);
        this.experiencia = experiencia;
        this.nacional = nacional;
    }

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public boolean esNacional() {
		return nacional;
	}

	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}

	@Override
	public String toString() {
		return "Tecnico [experiencia=" + experiencia + ", nacional=" + nacional + "]";
	}
    
    
    
}
