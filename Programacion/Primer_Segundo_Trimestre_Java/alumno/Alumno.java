package alumno;

public class Alumno {

	
	//Atributos
	private String nombre;
	private   String dni;
	private String direccion;
	
	//Constructores
	public Alumno(String nombre, String dni, String direccion) {
		this.nombre=nombre;
		this.dni=dni;
		this.direccion=direccion;
	}
	
	
	public Alumno() {}


	//setters and getters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	};
	
	
	
	//metodos
	
	public void realizarActividad(String actividad) {
        System.out.println(nombre + " está realizando la actividad: " + actividad);
    }
	
	
	public void preguntarAlgoAProfe(String pregunta) {
        System.out.println(nombre + " está preguntando a la profesora: " + pregunta);
    }

	
	//toString
	@Override
	public String toString() {
		return "Datos del alumno: " + "\nAlumno: " + nombre + "\nDireccion: " + direccion + "\nDNI: " + dni;
	}
	
	public static void main(String[] args) {
		
		Alumno alumno1 = new Alumno("Jonatan", "1234A", "Orduña 3");
		
		System.out.println(	alumno1.toString());
		
	}
	
}
