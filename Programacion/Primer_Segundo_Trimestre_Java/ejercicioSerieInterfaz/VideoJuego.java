package ejercicioSerieInterfaz;

public class VideoJuego implements Entregable {

	// Atributos de la clase
	private String titulo;
	private int horasEstimadas;
	private boolean entregado;
	private String genero;
	private String compania;

	// Constructores 
	public VideoJuego() {
        this.horasEstimadas = 10;
        this.entregado = false;
       
    }


	public VideoJuego(String titulo, int horasEstimadas) {
        this(); // Llamada al constructor por defecto para inicializar los atributos comunes
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
    }


	public VideoJuego(String titulo, int horasEstimadas, String genero, String compañia) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = false;
        this.genero = genero;
        this.compania = compañia;
    }
	
	//Setters and Getters
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getHorasEstimadas() {
		return horasEstimadas;
	}


	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getCompañia() {
		return compania;
	}


	public void setCompañia(String compañia) {
		this.compania = compañia;
	}


	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}


	// Metodos de la interfaz Entregable
	@Override
	public void entregar() {
		entregado = true;
	}

	@Override
	public void devolver() {
		entregado = false;
	}

	@Override
	public boolean isEntregado() {
		return entregado;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof VideoJuego) {
			VideoJuego otroVideojuego = (VideoJuego) obj;
			return Integer.compare(this.horasEstimadas, otroVideojuego.horasEstimadas);
		}
		return -1; 
					
	}
	

	@Override
	public String toString() {
	    return "\n*** Videojuego *** :" + "\nTitulo: " + titulo + "\nHoras estimadas: " + horasEstimadas
	            + "\nEntregado: " + entregado + "\nGenero: " + genero + "\nCompañía: " + compania;
	}


}
