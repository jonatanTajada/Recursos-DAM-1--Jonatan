package ejercicioGestionNominas;

public class Administrativo extends PersonalGestion {
	
	//Constructor
    public Administrativo(String dni, String nombre, double salarioBase, int antiguedad) {
        super(dni, nombre, salarioBase, antiguedad);
        // El complemento para administrativos es de 20€ por cada año de antiguedad
        this.salarioFinal += 20 * antiguedad;
    }
    
    //metodo getter
    public String getTipo() {
        return "Administrativo";
    }
}

