package ejercicioZoologico;

import java.util.ArrayList;

public class Zoologico {

	private String nombre;
	private ArrayList<Zona> zonas;
	private ArrayList<Instalacion> instalaciones;
	private ArrayList<Animal> animales;
	private ArrayList<Trabajador> trabajadores;
	private ArrayList<Asignacion> asignaciones;

	public Zoologico(String nombre) {
		
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
			this.zonas = new ArrayList<>();
			this.instalaciones = new ArrayList<>();
			this.animales = new ArrayList<>();
			this.trabajadores = new ArrayList<>();
			this.asignaciones = new ArrayList<>();
		} else {
			throw new IllegalArgumentException("El nombre del zoológico no puede ser nulo o vacío.");
		}
	}

	public void agregarZona(Zona zona) {
		zonas.add(zona);
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}

	public ArrayList<Instalacion> getInstalaciones() {
		return instalaciones;
	}

	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public ArrayList<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void agregarInstalacion(Instalacion instalacion) {
		instalaciones.add(instalacion);
	}

	public void agregarAnimal(Animal animal) {
		animales.add(animal);
	}

	public void agregarTrabajador(Trabajador trabajador) {
		trabajadores.add(trabajador);
	}

	public void agregarAsignacion(Asignacion asignacion) {
		asignaciones.add(asignacion);
	}

	public void listarInstalaciones() {
		for (Instalacion instalacion : instalaciones) {
			System.out.println("Número: " + instalacion.getNumero() + ", Año de instalación: "
					+ instalacion.getAnoInstalacion() + ", Descripción: " + instalacion.getDescripcion() + ", Zona: "
					+ instalacion.getZona().getNombre());
		}
	}
	
    
	public void listarAnimales() {
		for (Animal animal : animales) {
			System.out.println("Especie: " + animal.getEspecie() + ", Nombre: " + animal.getNombre()
					+ ", Año de nacimiento: " + animal.getAnoNacimiento() + ", Número de instalación: "
					+ animal.getInstalacion().getNumero() + ", Zona: " + animal.getInstalacion().getZona().getNombre());
		}
	}

	public void listarZonasTrabajador(String dni) {
		for (Asignacion asignacion : asignaciones) {
			if (asignacion.getTrabajador().getDni().equals(dni)) {
				System.out
						.println("Nombre y apellidos del trabajador: " + asignacion.getTrabajador().getNombreApellido()
								+ ", Especialidad: " + asignacion.getTrabajador().getEspecialidad());
				System.out.println("Zona: " + asignacion.getZona().getNombre() + ", Horario de trabajo: "
						+ asignacion.getHorario());
			}
		}
	}

	@Override
	public String toString() {
		return "Zoologico{" + "nombre='" + nombre + '\'' + ", zonas=" + zonas + ", instalaciones=" + instalaciones
				+ ", animales=" + animales + ", trabajadores=" + trabajadores + ", asignaciones=" + asignaciones + '}';
	}
}
