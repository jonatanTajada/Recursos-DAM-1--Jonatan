package ejercicio1_Estudiantes_Profesor;

public abstract class Persona {
    
//atributos    
private String nombre;
private int edad;
private String sexo;

//constructor
public Persona(String nombre, int edad, String sexo) {
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = sexo;
}

//setters and getters
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getEdad() {
    return edad;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public String getSexo() {
    return sexo;
}

public void setSexo(String sexo) {
    this.sexo = sexo;
}

//toString
public String toString(){
    return "Nombre: " + nombre + "\nEdad: " + edad + "\nSexo: " + sexo;
}

    // metodo poliformico ausente
    public abstract boolean ausente();


}
