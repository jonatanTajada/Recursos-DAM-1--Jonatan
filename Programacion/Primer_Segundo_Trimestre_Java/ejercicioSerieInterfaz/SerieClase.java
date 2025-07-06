package ejercicioSerieInterfaz;

public class SerieClase implements Serie, Entregable{

	// Atributos
	private String titulo;
	private int numTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;

	// Constructores
	public SerieClase() {
        this.numTemporadas = 3;
        this.entregado = false;
    }

	public SerieClase(String titulo, String creador) {
        this(); // Llamada al constructor por defecto para inicializar los atributos comunes
        this.titulo = titulo;
        this.creador = creador;
    }

	public SerieClase(String titulo, int numTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numTemporadas = numTemporadas;
        this.entregado = false;
        this.genero = genero;
        this.creador = creador;
    }
	

	// Metodos de la interfaz Serie
	public String getTitulo() {
		return titulo;
	}

	public String getCreador() {
		return creador;
	}

	public int getNumTemporadas() {
		return numTemporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
    public boolean isEntregado() {
        return entregado;
    }

	
	@Override
	public String toString() {
		return "\n*** Serie *** :" + "\nTitulo: " + titulo  + "\nNumero de temporadas: " + numTemporadas
				+ "\nEntregado: " + entregado + "\nGenero: " + genero + "\nCreador: " + creador;
		
	}
	
	//----------------------------

	
	// Metodos de la interfaz Entregable
	 public void entregar() {
	        entregado = true;
	    }

	    @Override
	    public void devolver() {
	        entregado = false;
	    }

	    

	@Override
	public int compareTo(Object obj) {
        if (obj instanceof SerieClase) {
            SerieClase otraSerie = (SerieClase) obj;
            return Integer.compare(this.numTemporadas, otraSerie.numTemporadas);
        }
        return -1;
    }

	@Override
	public int compareTo(Serie objeto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
