package ejercicioZoologico2;


import java.util.*;

//----------------------------------------------------------------------------------------------------------------------------
//        Esta clase se encarga de gestionar las listas, por lo tanto, todos los metodos de agregar,
//		  eliminar, buscar, modificar y mostrar se implementan en esta clase.
//
//		Esta clase tiene una relacion de agregacion con Zona, Instalacion, Animal y Trabajador.
//----------------------------------------------------------------------------------------------------------------------------

public class Zoologico {

	static Scanner scanner = new Scanner(System.in);

	// Atributos
	private String nombre;
	private List<Zona> zonas = new ArrayList<>();
	private List<Instalacion> instalaciones = new ArrayList<>();
	private List<Animal> animales = new ArrayList<>();
	private List<Trabajador> trabajadores = new ArrayList<>();
	private List<Asignacion> asignaciones = new ArrayList<>();
    private List<Zona> zonasTrabajador = new ArrayList<>();
    private Trabajador trabajadorSeleccionado;

//----------------------------------------------------------------------------------------------------------------------
//			******************************** METODOS**********************************************
//----------------------------------------------------------------------------------------------------------------------

	
//----------------------------------------------------------------------------------------------------------------------
//		Metodo Constructor
//----------------------------------------------------------------------------------------------------------------------
	public Zoologico(String nombre) {
		this.nombre = nombre;
	}

//----------------------------------------------------------------------------------------------------------------------
//	Metodos setters and getters
//----------------------------------------------------------------------------------------------------------------------
	
	 public void seleccionarTrabajador(Trabajador trabajador) {
	        this.trabajadorSeleccionado = trabajador;
	    }

	    public Trabajador getTrabajadorSeleccionado() {
	        return trabajadorSeleccionado;
	    }
	
	
	
//----------------------------------------------------------------------------------------------------------------------
// 				Metodos para agregar objeto en lista.
//----------------------------------------------------------------------------------------------------------------------

	public  void agregarZona() {

		System.out.print("Ingrese el id de la zona: ");
		String codigo = scanner.nextLine();
		System.out.print("Ingrese el nombre de la zona: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese los metros cuadrados de la zona: ");
		int metrosCuadrados = Integer.parseInt(scanner.nextLine());
		// scanner.nextLine();

		Zona zona = new Zona(codigo, nombre, metrosCuadrados);
		zonas.add(zona);
		System.out.println("Zona agregada con éxito.");
	}

	public  void agregarInstalacion() {

		System.out.print("Ingrese el número de la instalación: ");
		String numero = scanner.nextLine();
		System.out.print("Ingrese la descripción de la instalación: ");
		String descripcion = scanner.nextLine();
		System.out.print("Ingrese el año de instalación de la instalación: ");
		int anioInstalacion = scanner.nextInt();
		scanner.nextLine(); 

		System.out.print("Ingrese el código de la zona de la instalación: ");
		String codigoZona = scanner.nextLine();
		Zona zona = buscarZonaPorId(codigoZona);

		if (zona != null) {
			Instalacion instalacion = new Instalacion(numero, descripcion, anioInstalacion, zona);
			instalaciones.add(instalacion);	
			System.out.println("Instalación agregada con éxito.");
		} else {
			System.err.println("No se encontró la zona con el código: " + codigoZona);
		}
	}

	public  void agregarAnimal() {

		System.out.print("Ingrese el ID del animal: ");
		String id = scanner.nextLine();
		System.out.print("Ingrese el nombre del animal: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese la especie del animal: ");
		String especie = scanner.nextLine();
		System.out.print("Ingrese el año de nacimiento del animal: ");
		int anioNacimiento = scanner.nextInt();
		scanner.nextLine(); 

		Animal animal = new Animal(id, nombre, especie, anioNacimiento);
		animales.add(animal);
		System.out.println("Animal agregado con éxito.");
	}

	public  void agregarTrabajador() {

		System.out.print("Ingrese el ID del trabajador: ");
		String id = scanner.nextLine();
		System.out.print("Ingrese el nombre del trabajador: ");
		String nombre = scanner.nextLine();
		System.out.print("Ingrese el primer apellido del trabajador: ");
		String apellido1 = scanner.nextLine();
		System.out.print("Ingrese el segundo apellido del trabajador: ");
		String apellido2 = scanner.nextLine();
		System.out.print("Ingrese la especialidad del trabajador: ");
		String especialidad = scanner.nextLine();
		System.out.print("Ingrese el D.N.I. del trabajador: ");
		String dni = scanner.nextLine();

		Trabajador trabajador = new Trabajador(id, nombre, apellido1, apellido2, especialidad, dni);
		trabajadores.add(trabajador);
		System.out.println("Trabajador agregado con éxito.");
	}


//----------------------------------------------------------------------------------------------------------------------	
//				Metodos para eliminar objeto de la lista.
//----------------------------------------------------------------------------------------------------------------------	

	public  void eliminarZona() {
		
		System.out.print("Ingrese el id de la zona que desea eliminar: ");
		String codigo = scanner.nextLine();

		Zona zona = buscarZonaPorId(codigo);
		if (zona != null && zona.getId().equals(zona)) {
			zonas.remove(zona);
			System.out.println("Zona eliminada con éxito.");
		} else {
			System.err.println("No se encontró la zona con el id: " + codigo);
		}
	}

	public  void eliminarInstalacion() {
		System.out.print("Ingrese el número de la instalación que desea eliminar: ");
		String numero = scanner.nextLine();

		Instalacion instalacion = buscarInstalacionPorNumero(numero);
		if (instalacion != null && instalacion.getNumero().equals(numero)) {
			instalaciones.remove(instalacion);
			System.out.println("Instalación eliminada con éxito.");
		} else {
			System.err.println("No se encontró la instalación con el número: " + numero);
		}
	}

	public  void eliminarAnimal() {
		System.out.print("Ingrese el ID del animal que desea eliminar: ");
		String id = scanner.nextLine();

		Animal animal = buscarAnimalPorId(id);
		if (animal != null && animal.getId().equals(id)) {
			animales.remove(animal);
			System.out.println("Animal eliminado con éxito.");
		} else {
			System.err.println("No se encontró el animal con el ID: " + id);
		}
	}

	public  void eliminarTrabajador() {
		System.out.print("Ingrese el ID del trabajador que desea eliminar: ");
		String id = scanner.nextLine();

		Trabajador trabajador = buscarTrabajadorPorId(id);
		if (trabajador != null && trabajador.getId().equals(id)) {
			trabajadores.remove(trabajador);
			System.out.println("Trabajador eliminado con éxito.");
		} else {
			System.err.println("No se encontró el trabajador con el ID: " + id);
		}
	}

	public void eliminarAsignacion(Trabajador trabajador, Zona zona) {
		
	    Asignacion asignacion = buscarAsignacion(trabajador, zona);
	    if (asignacion != null) {
	        asignaciones.remove(asignacion);
	        System.out.println("Asignación eliminada con éxito.");
	    } else {
	        System.err.println("No se encontró la asignación para el trabajador y la zona especificados.");
	    }
	}


//----------------------------------------------------------------------------------------------------------------------		
// 				  Metodos de busqueda
//----------------------------------------------------------------------------------------------------------------------		

	public  Zona buscarZonaPorId(String id) {

		for (Zona zona : zonas) {
			if (zona.getId().equals(id)) {
				return zona;
			}
		}
		return null;
	}

	public  Instalacion buscarInstalacionPorNumero(String numeroInstalacion) {
		for (Instalacion instalacion : instalaciones) {
			if (instalacion.getNumero().equals(numeroInstalacion)) {
				return instalacion;
			}
		}
		return null;
	}

	public  Animal buscarAnimalPorId(String id) {

		for (Animal animal : animales) {
			if (animal.getId().equals(id)) {
				return animal;
			}
		}
		return null;
	}

	public  Trabajador buscarTrabajadorPorId(String id) {

		for (Trabajador trabajador : trabajadores) {
			if (trabajador.getId().equalsIgnoreCase(id)) {
				return trabajador;
			}
		}
		return null;
	}

	public Asignacion buscarAsignacion(Trabajador trabajador, Zona zona) {
		
		for (Asignacion asignacion : asignaciones) {
			if (asignacion.getTrabajador().equals(trabajador) && asignacion.getZona().equals(zona)) {
				return asignacion;
			}
		}
		return null;
	}

//----------------------------------------------------------------------------------------------------------------------		
//	  Metodos de modificacion de datos en objetos
//----------------------------------------------------------------------------------------------------------------------		

	//me quedado aqui revisa este apartado si esta todo bien...
	public  void modificarZona() {
		
	    try {
	        System.out.print("Ingrese el id de la zona que desea modificar: ");
	        String codigo = scanner.nextLine();

	        Zona zona = buscarZonaPorId(codigo);
	        if (zona != null) {
	            System.out.print("Ingrese el nuevo nombre de la zona: ");
	            String nuevoNombre = scanner.nextLine();
	            System.out.print("Ingrese los nuevos metros cuadrados de la zona: ");
	            int nuevosMetrosCuadrados = Integer.parseInt(scanner.nextLine());

	            zona.setNombre(nuevoNombre);
	            zona.setMetrosCuadrados(nuevosMetrosCuadrados);

	            System.out.println("Zona modificada con éxito.");
	        } else {
	            System.err.println("No se encontró la zona con el código: " + codigo);
	        }
	         
	    } catch (NumberFormatException e) {
	        System.err.println("Error: Ingrese un valor válido para los metros cuadrados.");
	    }
	}

	public void modificarInstalacion() {

		System.out.print("Ingrese el número de la instalación que desea modificar: ");
		String numero = scanner.nextLine();

		Instalacion instalacion = buscarInstalacionPorNumero(numero);
		
		
		if (instalacion != null) {
			
			System.out.print("Ingrese la nueva descripción de la instalación: ");
			String nuevaDescripcion = scanner.nextLine();
			System.out.print("Ingrese el nuevo año de instalación de la instalación: ");
			int nuevoAnioInstalacion = Integer.parseInt(scanner.next());
			
			
			instalacion.setDescripcion(nuevaDescripcion);
			instalacion.setAnioInstalacion(nuevoAnioInstalacion);
			System.out.println("Instalacion modificada con exito.");
		} else {
			System.err.println("No se encontró la instalacion con numero: " + numero);
		}

	}

	public void modificarAnimal() {

		System.out.print("Ingrese el ID del animal que desea modificar: ");
		String id = scanner.nextLine();

		Animal animal = buscarAnimalPorId(id);
		
		if (animal != null) {
			
			System.out.print("Ingrese el nuevo nombre del animal: ");
			String nuevoNombre = scanner.nextLine();
			System.out.print("Ingrese la nueva especie del animal: ");
			String nuevaEspecie = scanner.nextLine();
			System.out.print("Ingrese el nuevo año de nacimiento del animal: ");
			int nuevoAnioNacimiento = scanner.nextInt();
			scanner.nextLine(); 

			animal.setNombre(nuevoNombre);
			animal.setEspecie(nuevaEspecie);
			animal.setAnioNacimiento(nuevoAnioNacimiento);
			System.out.println("Animal modificado con exito.");
		} else {
			System.err.println("No se encontró el animal con el id: " + id);
		}

	}

	public void modificarTrabajador() {


		System.out.print("Ingrese el ID del trabajador que desea modificar: ");
		String id = scanner.nextLine();
		
		Trabajador trabajador = buscarTrabajadorPorId(id);
		if (trabajador != null) {
			
			System.out.print("Ingrese el nuevo D.N.I. del trabajador: ");
			String nuevoDniTrabajador = scanner.nextLine();
			System.out.print("Ingrese el nuevo nombre del trabajador: ");
			String nuevoNombre = scanner.nextLine();
			System.out.print("Ingrese el nuevo primer apellido del trabajador: ");
			String nuevoApellido1 = scanner.nextLine();
			System.out.print("Ingrese el nuevo segundo apellido del trabajador: ");
			String nuevoApellido2 = scanner.nextLine();
			System.out.print("Ingrese la nueva especialidad del trabajador: ");
			String nuevaEspecialidad = scanner.nextLine();
			
			trabajador.setNombre(nuevoNombre);
			trabajador.setApellido1(nuevoApellido1);
			trabajador.setApellido2(nuevoApellido2);
			trabajador.setEspecialidad(nuevaEspecialidad);
			System.out.println("Trabajador modificado con exito.");
		} else {
			System.err.println("No se encontró el trabajador con id: " + id);
		}
	}
		

//----------------------------------------------------------------------------------------------------------------------		
//	  Metodos para obtener listas.  
//----------------------------------------------------------------------------------------------------------------------		

	public List<Instalacion> getInstalaciones() {
		return instalaciones;
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public List<Zona> getZonas() {
		return zonas;
	}

	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public List<Zona> getZonasTrabajador() {
		return zonasTrabajador;
	}

//----------------------------------------------------------------------------------------------------------------------		
//	  Metodo para obtener listado de zonas de los trabjadores 
//----------------------------------------------------------------------------------------------------------------------		

	public void listarZonasTrabajador() {
		
	    System.out.println("Listado de Zonas para Trabajadores:");
	    
	    if (trabajadorSeleccionado != null) {
	    	
	        List<Zona> zonasAsignadas = new ArrayList<>();
	        for (Asignacion asignacion : asignaciones) {
	            if (asignacion.getTrabajador().equals(trabajadorSeleccionado)) {
	                zonasAsignadas.add(asignacion.getZona());
	            }
	        }

	        if (!zonasAsignadas.isEmpty()) {
	            for (Zona zona : zonasAsignadas) {
	                System.out.println(zona);
	            }
	        } else {
	            System.out.println("El trabajador no tiene asignadas zonas.");
	        }
	    } else {
	        System.out.println("No se ha seleccionado ningún trabajador.");
	    }
	}

	
	
	
	
//----------------------------------------------------------------------------------------------------------------------		
//	  Metodo mostrar menu
//----------------------------------------------------------------------------------------------------------------------		
	
	public void mostrarMenu() {
		System.out.println("\nMenu:");
		System.out.println("1.  Agregar Zona");
		System.out.println("2.  Agregar Instalacion");
		System.out.println("3.  Agregar Animal");
		System.out.println("4.  Agregar Trabajador");
		System.out.println("5.  Mostrar listado de instalaciones");
		System.out.println("6.  Mostrar listado de animales");
		System.out.println("7.  Mostrar zonas de trabajo de un trabajador");
		System.out.println("8.  Mostrar lista trabajadores");
		System.out.println("9.  Modificar Zona");
		System.out.println("10. Modificar Instalacion");
		System.out.println("11. Modificar Animal");
		System.out.println("12. Modificar Trabajador");
		System.out.println("13. Eliminar Zona");
		System.out.println("14. Eliminar Instalacion");
		System.out.println("15. Eliminar Animal");
		System.out.println("16. Eliminar Trabajador");
		System.out.println("0.  Salir");
	}

}
