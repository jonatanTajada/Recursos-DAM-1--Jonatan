package ejercicioGestionNominas;

public class Programador extends Informatico {
	
	//Constructor
    public Programador(String dni, String nombre, double salarioBase, String titulacion) {
        super(dni, nombre, salarioBase, titulacion);
        // El complemento para programadores es del 15%
        this.salarioFinal += 0.15 * salarioBase;
    }
    
    //metodo getter
    @Override
    public String getTipo() {
        return "Programador";
    }
}

