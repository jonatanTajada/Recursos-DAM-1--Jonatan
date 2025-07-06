package ejercicioGestionNominas;

public class Auxiliar extends PersonalGestion {
	
	//Constructor
    public Auxiliar(String dni, String nombre, double salarioBase, int antiguedad) {
        super(dni, nombre, salarioBase, antiguedad);
        // El complemento para auxiliares es fijo de 100€ independiente de la antiguedad
        this.salarioFinal += 100;
    }
    
    //metodo getter
    public String getTipo() {
        return "Auxiliar";
    }
}

