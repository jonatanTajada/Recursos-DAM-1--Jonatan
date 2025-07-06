package Practicas_fin_de_curso.Ejercicio_Enseñanza_Secundaria;

public abstract class Persona implements CalcularDescuentoI {
    // atributos
    protected String nombre;
    protected String anyoNacimiento;

    // constructor

    public Persona(String nombre, String anyoNacimiento) {
        this.nombre = nombre;
        this.anyoNacimiento = anyoNacimiento;
    }

    // setters and getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public void setAnyoNacimiento(String anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }

    // toString
    @Override
    public String toString() {
        return "\nNombre: " + this.nombre + "\nAño nacimiento: " + this.anyoNacimiento;
    }

 
}

