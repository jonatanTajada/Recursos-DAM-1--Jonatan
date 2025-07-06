package ejercicioGestionNominas;

public class Analista extends Informatico {
	
    public Analista(String dni, String nombre, double salarioBase, String titulacion) {
        super(dni, nombre, salarioBase, titulacion);
        // El complemento para analistas es del 30%
        this.salarioFinal += 0.3 * salarioBase;
    }
    
    @Override
    public String getTipo() {
        return "Analista";
    }
    
}

