package ejercicioGestionNominas;

public class PersonalGestion extends Trabajador {
	
	//Atributos
    protected int antiguedad;

    
  //Constructor
    public PersonalGestion(String dni, String nombre, double salarioBase, int antiguedad) {
        super(dni, nombre, salarioBase);
        this.antiguedad = antiguedad;
    }
    
    //metodo getter
    @Override
    public String getTipo() {
        return "Personal de Gestion";
    }
}

