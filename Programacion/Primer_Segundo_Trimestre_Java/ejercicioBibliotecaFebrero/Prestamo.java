package ejercicioBibliotecaFebrero;

public class Prestamo {

	
	//atributos
	private Documento documento;
	private Usuario usuario;
	private int plazo;
	
	//constructor
	public Prestamo(Documento documento, Usuario usuario, int plazo) {
		this.documento = documento;
		this.usuario = usuario;
		this.plazo = plazo;
	}

	//getters and setters
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}


	public String toString() {
		return "Datos Documento prestado: " + this.documento 
				+ "\nDatos del usuario: " + this.usuario
				+ "\nDias de alquiler: " + this.plazo;
	}
}
