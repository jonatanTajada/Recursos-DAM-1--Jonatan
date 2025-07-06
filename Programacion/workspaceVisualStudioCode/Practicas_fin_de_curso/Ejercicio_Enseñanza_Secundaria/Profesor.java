package Practicas_fin_de_curso.Ejercicio_Enseñanza_Secundaria;

public class Profesor extends Persona {

    // atributos
    private double salario;

    // constructor
    public Profesor(String nombre, String anyoNacimiento, double salario) {
        super(nombre, anyoNacimiento);
        this.salario = salario;

    }

    // setters and getters

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Implementacion del metodo CalcularDescuento Interface
    @Override
    public double calcularDescuento(double cantidad) {
        return cantidad * 0.02;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nSalario: " + this.salario + "€";
    }

}

