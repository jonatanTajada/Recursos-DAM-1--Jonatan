package ejercicioPersona;

public class Persona {

	//Atributos
	private String nombre;
	private String apellido;
	private String dni;
	private String fechaNacimiento;
	private String paisNacimiento;
	private char genero;
	
	//Constrcutor
	public Persona(String nombre, String apellido, String dni, String fechaNacimiento, String paisNacimiento,
			char genero) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.paisNacimiento = paisNacimiento;
		
		if (genero == 'H' || genero == 'h' || genero == 'M'|| genero == 'm') {
			this.genero = genero;
		}else {
			System.err.println("Error: solo puede introducir : h/ m/ H/ M. Se te asignado un valor por defecto: 'h'");
			this.genero = 'h';
		}
		
	}

	//Setters and Getters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getPaisNacimiento() {
		return paisNacimiento;
	}


	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}


	public char getGenero() {
		return genero;
	}


	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	//****metodos****
	
	//toString
	
	public String toString() {
		return "****\nCaracteristicas de la persona: ***" + "\n-Nombre: " + nombre + "\n-Apellido: " + apellido 
				+ "\n-D.N.I.: " + dni + "\n-Pais de nacimiento: " + paisNacimiento + "\n-Genero: " + genero;
	}
	
	
}
