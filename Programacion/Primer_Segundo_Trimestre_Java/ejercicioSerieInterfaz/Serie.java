package ejercicioSerieInterfaz;

// Metodos abstractos a ser implementados por las clases que la utilicen

public interface Serie {
	
    String getTitulo();
    String getCreador();
    int getNumTemporadas();
    String getGenero();
    void setTitulo(String titulo);
    void setCreador(String creador);
    void setNumTemporadas(int numTemporadas);
    void setGenero(String genero);
    String toString();
	int compareTo(Serie objeto);
    
}
