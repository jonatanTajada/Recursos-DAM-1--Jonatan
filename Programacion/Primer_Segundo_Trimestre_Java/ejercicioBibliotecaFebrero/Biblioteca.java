package ejercicioBibliotecaFebrero;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	//atributos
	private List<Documento> listaDocumentos;
	private List<Usuario> listaUsuarios;
	private List<Prestamo> listaPrestamos;
	private Documento documentoActual;

	//constructos
	public Biblioteca() {
		this.listaDocumentos = new ArrayList<>();
		this.listaUsuarios = new ArrayList<>();
		this.listaPrestamos = new ArrayList<>();
		this.documentoActual = null;
	}

//									--------------------------------------------
//									|				-- * METODOS * --			|
//	--------------------------------------------------------------------------------------------------------------------------------------	
	//agregar documento a lista documentos
	public void agregarDocumento(Documento documento) {
		listaDocumentos.add(documento);
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	//agregar usuario a lista usuarios
	public void agregarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	//añadir a documento actual, codigo introducido
	public void seleccionarDocumento(String codigo) {
		for (Documento documento : listaDocumentos) {
			if (documento.getCodigo().equals(codigo)) {
				documentoActual = documento;
				return;
			}
		}
		System.out.println("No existe ningun documento con este codigo.");
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	//prestar documento a usuario
	public void prestarDocumentoActual(String dni) throws Exception{
		
		if (documentoActual == null) {
			System.out.println("No hace referencia a ningun documento.");
			throw new NullPointerException("No hace referencia a ningun documento.");
		}

		Usuario usuario = buscarUsuarioPorDNI(dni);

		if (usuario == null) {
		    System.out.println("No existe ningun usuario con este DNI.");
		    throw new IllegalArgumentException("No existe ningun usuario con el DNI introducido.");
		}


		if (usuario.getPrestamosMaximosSimultaneos() <= contarPrestamosActivos(usuario)) {
		    System.out.println("El usuario ha alcanzado ha alcanzado el limite de prestamos.");
		    throw new IllegalArgumentException("El usuario ha alcanzado el límite de préstamos.");
		}


		if (documentoPrestado(documentoActual)) {
		    System.out.println("El documento ya esta prestado a otro usuario.");
		    throw new IllegalArgumentException("El documento ya esta prestado a otro usuario.");
		}


		int plazo = calcularPlazo(usuario, documentoActual);
		Prestamo prestamo = new Prestamo(documentoActual, usuario, plazo);
		listaPrestamos.add(prestamo);
		System.out.println("El documento ha sido prestado a " + usuario.getNombre() + ".");
	}

//	--------------------------------------------------------------------------------------------------------------------------------------
	public void devuelveDocumentoActual() {
		if (documentoActual == null) {
			System.out.println("No se ha seleccionado ningun documento.");
			return;
		}

		Prestamo prestamo = buscarPrestamoPorDocumento(documentoActual);

		if (prestamo == null) {
			System.out.println("El documento no se ha prestado.");
			return;
		}

		listaPrestamos.remove(prestamo);
		System.out.println("El documento ha sido devuelto con exito.");
	}

//	--------------------------------------------------------------------------------------------------------------------------------------
	
	public void buscaDocumentos(String texto) {
		List<Documento> documentosEncontrados = new ArrayList<>();
		for (Documento documento : listaDocumentos) {
			if (documento.getTitulo().contains(texto)) {
				documentosEncontrados.add(documento);
			}
		}

		System.out.println("Documentos encontrados:");
		for (Documento documento : documentosEncontrados) {
			System.out.println(documento);
		}
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	
	public void informePrestamos() {
		if (listaPrestamos.size() == 0) {
			System.err.println("lista vacia");
		}
		
		for (Prestamo prestamos : listaPrestamos) {
			if (!listaPrestamos.isEmpty()) {
				System.out.println(prestamos.toString());
			}	
		}
	}
	
//	--------------------------------------------------------------------------------------------------------------------------------------
	
	private Usuario buscarUsuarioPorDNI(String DNI) {
		for (Usuario user : listaUsuarios) {
			if (user.getDni().equals(DNI)) {
				return user;
			}
		}
		return null;
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	
	private boolean documentoPrestado(Documento documento) {
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getDocumento().equals(documento)) {
				return true;
			}
		}
		return false;
	}
//	--------------------------------------------------------------------------------------------------------------------------------------//	--------------------------------------------------------------------------------------------------------------------------------------
	private int contarPrestamosActivos(Usuario usuario) {
		int prestamosActivos = 0;
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getUsuario().equals(usuario)) {
				prestamosActivos++;
			}
		}
		return prestamosActivos;
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	private Prestamo buscarPrestamoPorDocumento(Documento documento) {
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getDocumento().equals(documento)) {
				return prestamo;
			}
		}
		return null;
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	private int calcularPlazo(Usuario usuario, Documento documento) {
	    int plazoBase = 0;

	    
	    if (documento instanceof Libro) {
	      
	        if (usuario instanceof Socio) {
	            plazoBase = 30;
	        } else if (usuario instanceof UsuarioOcasional) {
	            plazoBase = 15;
	        }
	    } else if (documento instanceof Revista) {
	        // Si el documento es una revista, establece el plazo como un tercio del plazo de un libro
	        plazoBase = calcularPlazoBaseParaLibro(usuario) / 3;
	    }

	    return plazoBase;
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
	
	private int calcularPlazoBaseParaLibro(Usuario usuario) {
	    if (usuario instanceof Socio) {
	        return 30; // Plazo base para un libro prestado a un socio
	    } else if (usuario instanceof UsuarioOcasional) {
	        return 15; // Plazo base para un libro prestado a un usuario ocasional
	    } else {
	        throw new IllegalArgumentException("Tipo de usuario no valido");
	    }
	}

	

}

//******************************************************************************************************************************************

