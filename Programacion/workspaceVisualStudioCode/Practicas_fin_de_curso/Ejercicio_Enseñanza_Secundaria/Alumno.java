package Practicas_fin_de_curso.Ejercicio_Enseñanza_Secundaria;

public class Alumno extends Persona {

//atributos
private String curso;


//constructor

public Alumno(String nombre, String anyoNacimiento, String curso) {
    super(nombre, anyoNacimiento);
    this.curso=curso;
}


//setters and getters
public String getCurso() {
    return curso;
}

public void setCurso(String curso) {
    this.curso = curso;
}


    // Implementacion del metodo CalcularDescuento Interface
    @Override
    public double calcularDescuento(double cantidad) {
        return cantidad * 0.1;
    }


   //toString
   @Override
   public String toString() {
       return super.toString() + "\nCurso: " + this.curso;
   }
    
}
