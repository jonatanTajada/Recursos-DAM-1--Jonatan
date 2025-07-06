package ejercicioGestionNominas;

public class Trabajador {
	
	//Atributos
    protected String dni;
    protected String nombre;
    protected double salarioBase;
    protected double salarioFinal;

  //Constructor
    public Trabajador(String dni, String nombre, double salarioBase) {
        this.dni = dni;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.salarioFinal = salarioBase; 
    }

    //metodo getter
    public String getTipo() {
        return "Trabajador";
    }

    // metodo toString
    public String toString() {
        return getTipo() + ": {dni=" + dni + ", nombre=" + nombre +
               ", salarioB=" + salarioBase + ", salarioF=" + salarioFinal + "}";
    }
    
}

