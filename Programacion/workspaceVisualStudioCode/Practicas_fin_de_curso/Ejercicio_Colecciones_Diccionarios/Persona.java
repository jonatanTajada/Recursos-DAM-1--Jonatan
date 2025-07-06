package Practicas_fin_de_curso.Ejercicio_Colecciones_Diccionarios;

public class Persona {
    // atributos
    private String nombre;
    private String apellidos;
    private String dni;
    private int edad;
    private Direccion direccion;

    // constructor
    public Persona(String nombre, String apellidos, String dni, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;

        if (edad < 0 || edad <= 130) {
            this.edad = edad;
        } else {
            System.err.println("La edad debe ser un numero entre 0 y 130");
        }

        this.direccion = direccion;
    }
    // setters and getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    // toString
    @Override
    public String toString() {
        return "\nNombre: " + this.nombre + "\nApellidos: " + this.apellidos + "\nD.N.I: " + this.dni
                + "\nEdad: " + this.edad + "\n-Direccion:\n" + this.direccion;
    }

}
