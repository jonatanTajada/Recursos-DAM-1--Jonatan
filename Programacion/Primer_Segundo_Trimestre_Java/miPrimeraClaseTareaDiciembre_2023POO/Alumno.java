package miPrimeraClaseTareaDiciembre_2023POO;

public class Alumno {

	private final static int CURSOS = 5;
	private String nombre;
	private int id;
	private int anioNacimiento;
	private double notas[];
	private static int total_alumnos = 0;

	// Constructor
	public Alumno(String nombre, int anioNacimiento) {
		this.nombre = nombre;
		this.anioNacimiento = anioNacimiento;
		this.id = ++total_alumnos;
		this.notas = new double[CURSOS];
	}

	// Métodos
	
	public void mostrar() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Identificador: " + id);
		System.out.println("Notas de los 5 años:");
		
		for (int i = 0; i < CURSOS; i++) {
			System.out.println("Año " + (i + 1) + ": " + getNota(i + 1));
		}
	}

	// Método para asignar nota media en un año en concreto
	
	public void setNota(int anio, double nota) {
		if (anio >= 1 && anio <= CURSOS) {
			notas[anio - 1] = nota;
		} else {
			System.out.println("Año incorrecto. Debe estar entre 1 y " + CURSOS);
		}
	}

	// Método para obtener la nota media
	
	public double getNota(int anio) {
		if (anio >= 1 && anio <= CURSOS) {
			return notas[anio - 1];
		} else {
			System.out.println("Año incorrecto. Debe estar entre 1 y " + CURSOS);
			return -1;
		}
	}

	public static void main(String[] args) {
		
		 Alumno alumno1 = new Alumno("Jonatan", 1988);
	        alumno1.setNota(1, 9.5);
	        alumno1.setNota(2, 6.0);
	        alumno1.setNota(3, 9.2);
	        alumno1.mostrar();
	        
	        System.out.println("\n*************\n");
	        
	        Alumno alumno2 = new Alumno("Janire", 1989);
	        alumno2.setNota(1, 4.8);
	        alumno2.setNota(2, 8.5);
	        alumno2.setNota(3, 8.9);
	        alumno2.mostrar();
		
		
	}
	
	
}
