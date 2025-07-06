package ejercicioGestionNominas;

public class Informatico extends Trabajador {
	
	//Atributos
    protected String titulacion;

    
  //Constructor
    public Informatico(String dni, String nombre, double salarioBase, String titulacion) {
        super(dni, nombre, salarioBase);
        this.titulacion = titulacion;
    }
    
    //metodo getter
    @Override
    public String getTipo() {
        return "Informatico";
    }
}

